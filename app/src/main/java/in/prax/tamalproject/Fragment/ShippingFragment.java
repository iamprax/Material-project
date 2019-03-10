package in.prax.tamalproject.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShippingFragment extends Fragment {


    @BindView(R.id.chkBillingAddress)
    CheckBox chkBillingAddress;
    @BindView(R.id.billingaddress)
    LinearLayout billingaddress;
    @BindView(R.id.continuebilling)
    AppCompatButton continuebilling;
    @BindView(R.id.shipping1)
    LinearLayout shipping1;
    Unbinder unbinder;
    @BindView(R.id.placeyourorder)
    AppCompatButton placeyourorder;
    @BindView(R.id.shipping2)
    LinearLayout shipping2;

    public ShippingFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shipping, container, false);
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).getSupportActionBar().setTitle("Shipping details");
        } else {
            ((ProductActivity) getActivity()).getSupportActionBar().setTitle("Shipping details");
        }
        unbinder = ButterKnife.bind(this, view);
        chkBillingAddress.setChecked(false);
        placeyourorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FairPricingFragment productsfragment = new FairPricingFragment();

                assert getFragmentManager() != null;
                if (getActivity() instanceof MainActivity) {
                    getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "FairPricingFragment").addToBackStack("").commit();
                }
                if (getActivity() instanceof ProductActivity) {
                    getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "FairPricingFragment").addToBackStack("").commit();
                }

            }
        });
        chkBillingAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    billingaddress.setVisibility(View.GONE);
                } else {
                    billingaddress.setVisibility(View.VISIBLE);
                }
            }
        });

        continuebilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shipping1.setVisibility(View.GONE);
                shipping2.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Anchor Rods and Elements");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Anchor Rods and Elements");

        }

        super.onDestroyView();
        unbinder.unbind();
    }
}
