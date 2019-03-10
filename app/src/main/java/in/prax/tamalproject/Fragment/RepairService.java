package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
public class RepairService extends Fragment {

    @BindView(R.id.btnWarrenty)
    AppCompatButton btnWarrenty;
    @BindView(R.id.btnOutOfWarrenty)
    AppCompatButton btnOutOfWarrenty;
    @BindView(R.id.terms1)
    LinearLayout terms1;
    @BindView(R.id.terms2)
    LinearLayout terms2;
    Unbinder unbinder;
    private OnFragmentInteractionListener mListener;

    public RepairService() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_repair, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((ServiceActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Repair Services");

        btnWarrenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terms1.setVisibility(View.VISIBLE);
                terms2.setVisibility(View.GONE);
                btnWarrenty.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector_white));
                btnWarrenty.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnOutOfWarrenty.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector));
                btnOutOfWarrenty.setTextColor(getResources().getColor(R.color.white));
            }
        });
        btnOutOfWarrenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terms2.setVisibility(View.VISIBLE);
                terms1.setVisibility(View.GONE);
                btnOutOfWarrenty.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector_white));
                btnOutOfWarrenty.setTextColor(getResources().getColor(R.color.colorPrimary));
                btnWarrenty.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector));
                btnWarrenty.setTextColor(getResources().getColor(R.color.white));
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
