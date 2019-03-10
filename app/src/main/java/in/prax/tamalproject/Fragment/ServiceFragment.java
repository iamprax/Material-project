package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.ServiceActivity;
import in.prax.tamalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ServiceFragment extends Fragment {

    @BindView(R.id.chkSpareparts)
    AppCompatCheckBox chkSpareparts;
    @BindView(R.id.btnSearch)
    AppCompatButton btnSearch;
    @BindView(R.id.btnAdvanceSearch)
    AppCompatButton btnAdvanceSearch;
    @BindView(R.id.searchcontainer)
    LinearLayout searchcontainer;
    @BindView(R.id.advancesearchcontainer)
    LinearLayout advancesearchcontainer;
    Unbinder unbinder;
    @BindView(R.id.servicecontainer1)
    ScrollView servicecontainer1;
    @BindView(R.id.servicecontainer2)
    LinearLayout servicecontainer2;
    private OnFragmentInteractionListener mListener;
    View view;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((ServiceActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Spare parts");

        servicecontainer2.setVisibility(View.VISIBLE);
        servicecontainer1.setVisibility(View.GONE);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchcontainer.setVisibility(View.VISIBLE);
                advancesearchcontainer.setVisibility(View.GONE);
                btnSearch.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector_white));
                btnSearch.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnAdvanceSearch.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector));
                btnAdvanceSearch.setTextColor(getResources().getColor(R.color.white));
            }
        });
        btnAdvanceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancesearchcontainer.setVisibility(View.VISIBLE);
                searchcontainer.setVisibility(View.GONE);
                btnAdvanceSearch.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector_white));
                btnAdvanceSearch.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnSearch.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector));
                btnSearch.setTextColor(getResources().getColor(R.color.white));
            }
        });

        chkSpareparts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    servicecontainer1.setVisibility(View.GONE);
                    servicecontainer2.setVisibility(View.VISIBLE);
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
        ((ServiceActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Services and repair");

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
