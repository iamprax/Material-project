package in.prax.tamalproject.Fragment.product;

import android.annotation.SuppressLint;
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
import java.util.Objects;

import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.Adapter.SubProductadapter;
import in.prax.tamalproject.BuyerProductsPojo;
import in.prax.tamalproject.Fragment.SubProductDetailFragment;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;

@SuppressLint("ValidFragment")
public class ProductDetailFragment extends Fragment implements OnDashboardclicklistener {

    View view;
    RecyclerView rvProducts;
    SwipeRefreshLayout refreshproducts;
    Unbinder unbinder;
    private RecyclerView recyclerView;
    private SubProductadapter madapter;
    private ArrayList<BuyerProductsPojo> mProductsList;
    SwipeRefreshLayout refreshDashboard;
    private LinearLayoutManager manager;
    private final int[] color = {R.color.GRAPEFRUIT, R.color.bittersweet, R.color.Sunflower, R.color.grass, R.color.mint, R.color.lavender, R.color.pinkrose, R.color.grey_light};
    String title;

    @SuppressLint("ValidFragment")
    public ProductDetailFragment(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products, container, false);
        getActivity().setTitle("Anchor Fasteners");
        refreshproducts = view.findViewById(R.id.refreshproducts);
        refreshproducts.setRefreshing(false);
        refreshproducts.setOnRefreshListener(() -> {
        });
        rvProducts = view.findViewById(R.id.rvProducts);
        mProductsList = new ArrayList<>();
        mProductsList.add(new BuyerProductsPojo("Anchor Rods and Elements", "anchord_rods_and_elements_image"));
        mProductsList.add(new BuyerProductsPojo("Screw Anchors", "screw_anchors_image"));
        mProductsList.add(new BuyerProductsPojo("Exapansion Anchors", "expansion_anchors_image"));
        mProductsList.add(new BuyerProductsPojo("Elastic Dry wall Anchors", "plastic_anchors_image"));
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvProducts.setLayoutManager(manager);
        madapter = new SubProductadapter(mProductsList, getActivity());
        madapter.setOnDashboardclicklistener(this);
        rvProducts.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Products");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Products");

        }

        super.onDestroyView();


    }

    @Override
    public void ondashboardclicked(int position) {
        if (mProductsList.get(position).getProductname().equals("Anchor Rods and Elements")) {
            SubProductDetailFragment productsfragment = new SubProductDetailFragment(title, mProductsList.get(position).getProductname());

            assert getFragmentManager() != null;
            getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "productdetail").addToBackStack("").commit();
        }
    }
}
