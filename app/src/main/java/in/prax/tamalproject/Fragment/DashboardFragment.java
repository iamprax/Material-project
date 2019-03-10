package in.prax.tamalproject.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.Activity.RegisterActivity;
import in.prax.tamalproject.Activity.ServiceActivity;
import in.prax.tamalproject.Adapter.DashboardAdapter;
import in.prax.tamalproject.Apppref;
import in.prax.tamalproject.BuyerProductsPojo;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;

public class DashboardFragment extends Fragment implements OnDashboardclicklistener {
    private RecyclerView recyclerView;
    private DashboardAdapter madapter;
    private ArrayList<BuyerProductsPojo> mDashList;
    SwipeRefreshLayout refreshDashboard;
    private GridLayoutManager manager;
    private final int[] color = {R.color.GRAPEFRUIT, R.color.bittersweet, R.color.Sunflower, R.color.grass, R.color.mint, R.color.lavender, R.color.pinkrose, R.color.grey_light};

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ((MainActivity) Objects.requireNonNull(getActivity())).setTitle("Dashboard");
        refreshDashboard = view.findViewById(R.id.refreshDashboard);
        refreshDashboard.setRefreshing(false);
        refreshDashboard.setOnRefreshListener(() -> {
        });
        recyclerView = view.findViewById(R.id.rvDashboard);

        mDashList = new ArrayList<>();

        mDashList.add(new BuyerProductsPojo("Products", R.drawable.ic_nav_myorders));
        mDashList.add(new BuyerProductsPojo("Products", R.drawable.ic_nav_myorders));
        mDashList.add(new BuyerProductsPojo("Product videos", R.drawable.ic_baseline_theaters_24px));
        mDashList.add(new BuyerProductsPojo("Enquiry generation", R.drawable.ic_baseline_mail_24px));
        mDashList.add(new BuyerProductsPojo("Place your order/Buy here", R.drawable.ic_baseline_shopping_basket_24px));
        mDashList.add(new BuyerProductsPojo("Comparision with compititors(videos/technical)", R.drawable.ic_baseline_theaters_24px));
        mDashList.add(new BuyerProductsPojo("Services and repair", R.drawable.ic_baseline_build_24px));
        mDashList.add(new BuyerProductsPojo("Technical Documents Library", R.drawable.ic_baseline_assignment_24px));
        mDashList.add(new BuyerProductsPojo("Engineering", R.drawable.ic_baseline_build_24px));
        mDashList.add(new BuyerProductsPojo("Latest updates", R.drawable.ic_outline_settings_remote_24px));

        mDashList.add(new BuyerProductsPojo("Service centre and store location", R.drawable.ic_baseline_store_24px));
        mDashList.add(new BuyerProductsPojo("about us", R.drawable.ic_nav_aboutus));
        mDashList.add(new BuyerProductsPojo("stay connected in social media", R.drawable.ic_nav_myaccount));
        mDashList.add(new BuyerProductsPojo("Contact us", R.drawable.ic_baseline_contact_mail_24px));
        mDashList.add(new BuyerProductsPojo("Track your order", R.drawable.ic_outline_motorcycle_24px));

        madapter = new DashboardAdapter(mDashList, getActivity());
        manager = new GridLayoutManager(getActivity(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == mDashList.size() || position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(madapter);
        madapter.setOnDashboardclicklistener(DashboardFragment.this);
        madapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void ondashboardclicked(int position) {
        if (mDashList.get(position).getProductname().equals("Products")) {
            Intent intent = new Intent(getActivity(), ProductActivity.class);
            startActivity(intent);
//            assert getFragmentManager() != null;
            Apppref.getInstance(getContext()).setVideo(false);
//            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Products").addToBackStack("").commit();
        }
        if (mDashList.get(position).getProductname().equals("Enquiry generation")) {
            EnquiryGenerationFragment productsfragment = new EnquiryGenerationFragment();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Enquiry generation").addToBackStack("").commit();
        }
        if (mDashList.get(position).getProductname().equals("about us")) {
            AboutUsFragment productsfragment = new AboutUsFragment();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "about us").addToBackStack("").commit();
        }
        if (mDashList.get(position).getProductname().equals("Contact us")) {
            ContactUsFragment productsfragment = new ContactUsFragment();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Contact us").addToBackStack("").commit();
        }
        if (mDashList.get(position).getProductname().equals("Place your order/Buy here")) {
            FairPricingFragment productsfragment = new FairPricingFragment();
            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Product").addToBackStack("").commit();
//            login.dismiss();
            final Dialog login = new Dialog(Objects.requireNonNull(getActivity()));
// Set GUI of login screen
            login.setContentView(R.layout.login_dialog);
            login.setTitle("Login to Pulse 7");
            // Init button of login GUI
            Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
            Button btnCancel = (Button) login.findViewById(R.id.btnCancel);
// Attached listener for login GUI button
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),
                            "Login Sucessfull", Toast.LENGTH_LONG).show();



                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                login.dismiss();
                    Intent intent = new Intent(getActivity(), RegisterActivity.class);
                    startActivity(intent);
                }
            });

//            login.show();
        }
        if (mDashList.get(position).getProductname().equals("Product videos")) {
//            Productsfragment productsfragment = new Productsfragment();
            Intent intent = new Intent(getActivity(), ProductActivity.class);
            startActivity(intent);
            Apppref.getInstance(getContext()).setVideo(true);
//            assert getFragmentManager() != null;
//            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Products").addToBackStack("").commit();
        }
        if (mDashList.get(position).getProductname().equals("Comparision with compititors(videos/technical)")) {
            ComparisionFragment productsfragment = new ComparisionFragment();
//            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.frame, productsfragment, "Products").addToBackStack("").commit();
        }
        if (mDashList.get(position).getProductname().equals("Services and repair")) {
            Intent intent = new Intent(getActivity(), ServiceActivity.class);
            startActivity(intent);
        }
    }
}
