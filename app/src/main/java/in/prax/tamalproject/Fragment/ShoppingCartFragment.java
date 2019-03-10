package in.prax.tamalproject.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.R;


public class ShoppingCartFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public ShoppingCartFragment() {
        // Required empty public constructor
    }

    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Shopping cart");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Shopping cart");

        }


        return view;
    }
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
