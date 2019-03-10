package in.prax.tamalproject.Fragment.product;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Unbinder;
import in.prax.tamalproject.Adapter.ProductsAdapter;
import in.prax.tamalproject.BuyerProductsPojo;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;

public class Productsfragment extends Fragment implements OnDashboardclicklistener {

    View view;
    RecyclerView rvProducts;
    SwipeRefreshLayout refreshproducts;
    Unbinder unbinder;
    private RecyclerView recyclerView;
    private ProductsAdapter madapter;
    private ArrayList<BuyerProductsPojo> mProductsList;
    SwipeRefreshLayout refreshDashboard;
    private LinearLayoutManager manager;
    private final int[] color = {R.color.GRAPEFRUIT, R.color.bittersweet, R.color.Sunflower, R.color.grass, R.color.mint, R.color.lavender, R.color.pinkrose, R.color.grey_light};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products, container, false);

        getActivity().setTitle("Products");
        refreshproducts = view.findViewById(R.id.refreshproducts);
        refreshproducts.setRefreshing(false);
        refreshproducts.setOnRefreshListener(() -> {
        });
        rvProducts = view.findViewById(R.id.rvProducts);
        mProductsList = new ArrayList<>();
        mProductsList.add(new BuyerProductsPojo("Anchor Fasteners", "anchor_fasteners_image"));
        mProductsList.add(new BuyerProductsPojo("Measuring systems", "measuring_system_image"));
        mProductsList.add(new BuyerProductsPojo("Cordless Systems", "cordless_system_image"));
        mProductsList.add(new BuyerProductsPojo("Drilling Demolition", "drilling_demolition_image"));
        mProductsList.add(new BuyerProductsPojo("Diamond Coring and sawing", "diamond_coring_image"));
        mProductsList.add(new BuyerProductsPojo("Inserts", "inserts_image"));
        mProductsList.add(new BuyerProductsPojo("Firestops and Fire Protection systems", "firestop_image"));
        mProductsList.add(new BuyerProductsPojo("Softwares", "software"));
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvProducts.setLayoutManager(manager);
        madapter = new ProductsAdapter(mProductsList, getActivity());
        madapter.setOnDashboardclicklistener(this);
        rvProducts.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void ondashboardclicked(int position) {
        if (mProductsList.get(position).getProductname().equals("Anchor Fasteners")) {
            ProductDetailFragment productsfragment = new ProductDetailFragment(mProductsList.get(position).getProductname());

            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "productdetail").addToBackStack("").commit();
        }
    }
}



