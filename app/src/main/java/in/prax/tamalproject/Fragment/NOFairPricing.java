package in.prax.tamalproject.Fragment;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class NOFairPricing extends Fragment {

    @BindView(R.id.chkrelatedtoprice)
    AppCompatCheckBox chkrelatedtoprice;
    @BindView(R.id.chkcallfurther)
    AppCompatCheckBox chkcallfurther;
    @BindView(R.id.btnsubmitbofair)
    AppCompatButton btnsubmitbofair;
    Unbinder unbinder;
    @BindView(R.id.chkVolume)
    AppCompatCheckBox chkVolume;
    private OnFragmentInteractionListener mListener;

    public NOFairPricing() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nofair_pricing, container, false);
        unbinder = ButterKnife.bind(this, view);
        chkcallfurther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkrelatedtoprice.setChecked(!isChecked);
                chkVolume.setChecked(!isChecked);


            }
        });
        chkVolume.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkcallfurther.setChecked(!isChecked);


            }
        });
        chkrelatedtoprice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkcallfurther.setChecked(!isChecked);
                if (isChecked) {
                    final Dialog nofair = new Dialog(Objects.requireNonNull(getActivity()));
                    nofair.setContentView(R.layout.nofairdialogue_view);
                    nofair.show();
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
