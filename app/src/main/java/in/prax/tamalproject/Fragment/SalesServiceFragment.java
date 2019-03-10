package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import in.prax.tamalproject.Activity.ServiceActivity;
import in.prax.tamalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SalesServiceFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SalesServiceFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public SalesServiceFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sales, container, false);
        ((ServiceActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("After-Sales service");

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((ServiceActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Services and repair");
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
