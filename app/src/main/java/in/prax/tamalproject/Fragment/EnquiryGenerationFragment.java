package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Fragment.product.Productsfragment;
import in.prax.tamalproject.R;
import in.prax.tamalproject.view.MyTextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class EnquiryGenerationFragment extends Fragment {

    @BindView(R.id.toolsAndcategory)
    MyTextView toolsAndcategory;
    @BindView(R.id.btnRegister)
    AppCompatButton btnRegister;
    Unbinder unbinder;
    private OnFragmentInteractionListener mListener;

    public EnquiryGenerationFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_enquiry_generation, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Enquiry generation");

        unbinder = ButterKnife.bind(this, view);
        toolsAndcategory.setOnClickListener(v -> {
            Productsfragment productsfragment = new Productsfragment();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Enquiry generation").addToBackStack("").commit();

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
        ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Dashboard");
        super.onDestroyView();
        unbinder.unbind();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
