package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.R;

public class ComparisionFragment extends Fragment {


    Unbinder unbinder;
    private AboutUsFragment.OnFragmentInteractionListener mListener;

    public ComparisionFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Comparision with competitions");
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_comparision, container, false);
        unbinder = ButterKnife.bind(this, view);


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
