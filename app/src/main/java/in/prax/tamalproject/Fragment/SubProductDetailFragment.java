package in.prax.tamalproject.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.MainActivity;
import in.prax.tamalproject.Activity.ProductActivity;
import in.prax.tamalproject.Adapter.ProductDetailAdapter;
import in.prax.tamalproject.BuyerProductsPojo;
import in.prax.tamalproject.Fragment.product.ProductlineFragment;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;
import in.prax.tamalproject.view.MyTextView;

public class SubProductDetailFragment extends Fragment implements OnDashboardclicklistener {

    View view;
    RecyclerView rvProducts;
    SwipeRefreshLayout refreshproducts;
    Unbinder unbinder;
    @BindView(R.id.txtCalender)
    MyTextView txtCalender;
    @BindView(R.id.txtSubproduct)
    MyTextView txtSubproduct;
    @BindView(R.id.carddashboard)
    CardView carddashboard;

    Unbinder unbinder1;
    private RecyclerView recyclerView;
    private ProductDetailAdapter madapter;
    private ArrayList<BuyerProductsPojo> mProductsList;
    SwipeRefreshLayout refreshDashboard;
    private LinearLayoutManager manager;
    private final int[] color = {R.color.GRAPEFRUIT, R.color.bittersweet, R.color.Sunflower, R.color.grass, R.color.mint, R.color.lavender, R.color.pinkrose, R.color.grey_light};
    String title, subtitle;

    @SuppressLint("ValidFragment")
    public SubProductDetailFragment(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @SuppressLint("ValidFragment")
    public SubProductDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_products_details, container, false);
        unbinder1 = ButterKnife.bind(this, view);


        getActivity().setTitle("Anchor Rods and Elements-");
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
        txtSubproduct.setText(subtitle + "\ntotal " + mProductsList.size() + " products");
        manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvProducts.setLayoutManager(manager);
        madapter = new ProductDetailAdapter(mProductsList, getActivity());
        madapter.setOnDashboardclicklistener(this);
        rvProducts.setAdapter(madapter);
        madapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        getActivity().setTitle("");
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Anchor Fasteners");

        }
        if (getActivity() instanceof ProductActivity) {
            ((ProductActivity) Objects.requireNonNull(getActivity())).getSupportActionBar().setTitle("Anchor Fasteners");

        }
        super.onDestroyView();
        unbinder1.unbind();


    }

    @Override
    public void ondashboardclicked(int position) {
        ProductlineFragment productsfragment = new ProductlineFragment(title);

        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "productline").addToBackStack("").commit();

    }
}
