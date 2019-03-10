package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.R;
import in.prax.tamalproject.view.MyEditText;
import in.prax.tamalproject.view.MyTextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class CurrentPricing extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.chkRelatedtoexistingdiscount)
    CheckBox chkRelatedtoexistingdiscount;
    @BindView(R.id.chkVolume)
    MyEditText chkVolume;
    @BindView(R.id.chkrelatedtoprice)
    MyEditText chkrelatedtoprice;
    @BindView(R.id.chkcallfurther)
    AppCompatCheckBox chkcallfurther;
    @BindView(R.id.cardCurrentPricing)
    CardView cardCurrentPricing;
    @BindView(R.id.chkAnyOtherRequest)
    CheckBox chkAnyOtherRequest;
    @BindView(R.id.chknew)
    MyTextView chknew;
    @BindView(R.id.btnsubmitbofair)
    AppCompatButton btnsubmitbofair;
    private OnFragmentInteractionListener mListener;

    public CurrentPricing() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_current_pricing, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Current pricing");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Current pricing");

        }

        chkRelatedtoexistingdiscount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cardCurrentPricing.setVisibility(View.VISIBLE);
                    chkAnyOtherRequest.setChecked(false);
                }

            }
        });
        chkAnyOtherRequest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cardCurrentPricing.setVisibility(View.GONE);
                    chkRelatedtoexistingdiscount.setChecked(false);
                }

            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDestroyView() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Fair pricing");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Fair pricing");

        }

        super.onDestroyView();
        unbinder.unbind();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
