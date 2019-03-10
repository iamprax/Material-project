package in.prax.tamalproject.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.Apppref;
import in.prax.tamalproject.R;
import in.prax.tamalproject.view.MyEditText;
import in.prax.tamalproject.view.MyTextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FairPricingFragment extends Fragment {

    @BindView(R.id.btnBuyNow)
    AppCompatButton btnBuyNow;
    @BindView(R.id.btnAddtocart)
    AppCompatButton btnAddtocart;
    Unbinder unbinder;
    @BindView(R.id.checkpurchasehistory)
    CheckBox checkpurchasehistory;
    @BindView(R.id.edtGSTINCase2)
    MyEditText edtGSTINCase2;
    @BindView(R.id.txtDiscount)
    AppCompatTextView txtDiscount;
    @BindView(R.id.txtGSTPFcase2)
    AppCompatTextView txtGSTPFcase2;
    @BindView(R.id.way1)
    CheckBox way1;
    @BindView(R.id.way2)
    CheckBox way2;
    @BindView(R.id.case1)
    CheckBox case1;
    @BindView(R.id.case2)
    CheckBox case2;
    @BindView(R.id.containercase)
    LinearLayout containercase;
    @BindView(R.id.btnyess)
    AppCompatButton btnyess;
    private OnFragmentInteractionListener mListener;

    public FairPricingFragment() {
        // Required empty public constructor
    }

    View view;
    Dialog reorder;
    Dialog offer;
    boolean vi = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fair_pricing2, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Fair pricing");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Fair pricing");

        }
        txtDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vi = !vi;
                containercase.setVisibility(vi ? View.VISIBLE : View.GONE);
            }
        });

//////////////////////////////////////////////////////////////////Reorder??????????????????????????????
        reorder = new Dialog(Objects.requireNonNull(getActivity()));
        reorder.setContentView(R.layout.reorder_dialogue_view);
        reorder.setTitle("Login to Pulse 7");
        Button btnReorder = (Button) reorder.findViewById(R.id.btnReorderdialogue);
        Button btnModify = (Button) reorder.findViewById(R.id.btnModifyReorderdialogue);
        MyTextView txtspecialoffer = (MyTextView) reorder.findViewById(R.id.txtspecialoffer);


//////////////////////////////////////////////////////////////////Offer??????????????????????????????
        offer = new Dialog(Objects.requireNonNull(getActivity()));
        offer.setContentView(R.layout.modify_reorder_dialogue);
        CheckBox checkBox = offer.findViewById(R.id.chkavailable);
        txtspecialoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offer.show();
//                nofair.show();
                reorder.dismiss();
            }
        });

        case1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Apppref.getInstance(getContext()).setCase1(isChecked);
                    txtDiscount.setText("Discount");
                    case2.setChecked(false);
                    Apppref.getInstance(getActivity()).setCase2(false);
                }
            }
        });
        case2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    offer.dismiss();
                    txtDiscount.setText("Existing Discount");
                    Apppref.getInstance(getContext()).setCase2(isChecked);
                    case1.setChecked(false);
                    Apppref.getInstance(getActivity()).setCase1(false);
                }
            }
        });
        way1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    offer.dismiss();
                    Apppref.getInstance(getContext()).setWay1(isChecked);
                    txtDiscount.setText("Discount");
                    edtGSTINCase2.setVisibility(View.GONE);
                    way1.setChecked(false);
                }
            }
        });
        way2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Apppref.getInstance(getContext()).setWay2(isChecked);
                    edtGSTINCase2.setVisibility(View.VISIBLE);
                    txtDiscount.setText("Existing Discount");
                    way2.setChecked(false);
                }
            }
        });
        btnyess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NOFairPricing productsfragment = new NOFairPricing();
                CurrentPricing productsfragment1 = new CurrentPricing();

                assert getFragmentManager() != null;
                if (getActivity() instanceof MainActivity) {
                    getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "NOFairPricing").addToBackStack("").commit();
                }
                if (getActivity() instanceof ProductActivity) {
//                        getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "NOFairPricing").addToBackStack("").commit();
                    getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment1, "NOFairPricing").addToBackStack("").commit();
                }


            }
        });

        DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    //Yes button clicked
                    NOFairPricing productsfragment = new NOFairPricing();
                    CurrentPricing productsfragment1 = new CurrentPricing();

                    assert getFragmentManager() != null;

                    if (getActivity() instanceof MainActivity) {
                        getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "NOFairPricing").addToBackStack("").commit();
                    }
                    if (getActivity() instanceof ProductActivity) {
//                        getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "NOFairPricing").addToBackStack("").commit();
                        getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment1, "NOFairPricing").addToBackStack("").commit();
                    }

                    break;


                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        btnReorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reorder.dismiss();
//                Intent intent = new Intent(getActivity(), RegisterActivity.class);
//                startActivity(intent);
            }
        });
        checkpurchasehistory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

//                    if (Apppref.getInstance(getActivity()).isCase1()) {
                    reorder.show();
//                    } else {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                        builder.setMessage("Special request for buisness need or any other purpose").setPositiveButton("Yes", dialogClickListener)
//                                .setNegativeButton("No", dialogClickListener).show();
//                    }
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
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Dashboard");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Shipping details");

        }

        super.onDestroyView();
        unbinder.unbind();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }
}
