package in.prax.tamalproject.Fragment.product;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.prax.tamalproject.Activity.RegisterActivity;
import in.prax.tamalproject.Fragment.ShippingFragment;
import in.prax.tamalproject.Fragment.ShoppingCartFragment;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;

@SuppressLint("ValidFragment")
public class ProductlineFragment extends Fragment implements OnDashboardclicklistener {

    View view;
    RecyclerView rvProducts;
    SwipeRefreshLayout refreshproducts;
    Unbinder unbinder;
    SwipeRefreshLayout refreshDashboard;
    @BindView(R.id.vpBanner)
    ViewFlipper vpBanner;
    @BindView(R.id.homecardSearch)
    CardView homecardSearch;
    @BindView(R.id.techdata)
    AppCompatImageView techdata;
    @BindView(R.id.features)
    AppCompatImageView features;
    @BindView(R.id.application)
    AppCompatImageView application;
    Unbinder unbinder1;
    @BindView(R.id.documents)
    AppCompatImageView documents;
    @BindView(R.id.relatedproducts)
    AppCompatImageView relatedproducts;
    @BindView(R.id.consult1)
    AppCompatImageView consult1;
    @BindView(R.id.consult2)
    AppCompatImageView consult2;
    @BindView(R.id.psp1)
    AppCompatImageView psp1;
    @BindView(R.id.psp2)
    AppCompatImageView psp2;
    @BindView(R.id.btnloginproductline)
    AppCompatButton btnloginproductline;
    @BindView(R.id.btnBuyNow)
    AppCompatButton btnBuyNow;
    @BindView(R.id.btnAddtocart)
    AppCompatButton btnAddtocart;
    private LinearLayoutManager manager;
    private final int[] color = {R.color.GRAPEFRUIT, R.color.bittersweet, R.color.Sunflower, R.color.grass, R.color.mint, R.color.lavender, R.color.pinkrose, R.color.grey_light};
    String title;
    int images[] = {R.drawable.anchord_image, R.drawable.anchord_image, R.drawable.anchord_image};

    @SuppressLint("ValidFragment")
    public ProductlineFragment(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_product_line, container, false);
        unbinder1 = ButterKnife.bind(this, view);

        final Dialog login = new Dialog(Objects.requireNonNull(getActivity()));
// Set GUI of login screen
        login.setContentView(R.layout.login_dialog);
        login.setTitle("Login to Pulse 7");
        btnloginproductline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.show();

            }
        });
        btnBuyNow.setOnClickListener(v -> login.show());
// Init button of login GUI
        Button btnLogin = (Button) login.findViewById(R.id.btnLogin);
        Button btnCancel = (Button) login.findViewById(R.id.btnCancel);

// Attached listener for login GUI button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "Login Sucessfull", Toast.LENGTH_LONG).show();

                ShippingFragment productsfragment = new ShippingFragment();

                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "productdetail").addToBackStack("").commit();
                login.dismiss();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                login.dismiss();
                Intent intent=new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
            }
        });
btnAddtocart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        ShoppingCartFragment productsfragment = new ShoppingCartFragment();

        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().add(R.id.productcontainer, productsfragment, "productdetail").addToBackStack("").commit();
        login.dismiss();
    }
});
// Make dialog box visible.
        for (int i = 0; i < images.length; i++) {
            //  This will create dynamic image view and add them to ViewFlipper
            ImageView image = new ImageView(getActivity());
            image.setBackgroundResource(images[i]);
            vpBanner.addView(image);
        }
        vpBanner.setAutoStart(true);
        vpBanner.setFlipInterval(3000);

        Glide.with(getActivity()).load(getResources().getIdentifier("techdataproductline", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(techdata);
        Glide.with(getActivity()).load(getResources().getIdentifier("featuresproductline", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(features);
        Glide.with(getActivity()).load(getResources().getIdentifier("applicationproductline", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(application);
        Glide.with(getActivity()).load(getResources().getIdentifier("documents", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(documents);
        Glide.with(getActivity()).load(getResources().getIdentifier("relatedproducts", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(relatedproducts);
        Glide.with(getActivity()).load(getResources().getIdentifier("consult1", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(consult1);
        Glide.with(getActivity()).load(getResources().getIdentifier("consult2", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(consult2);
        Glide.with(getActivity()).load(getResources().getIdentifier("psp1", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(psp1);
        Glide.with(getActivity()).load(getResources().getIdentifier("psp2", "drawable", getActivity().getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(psp2);
//        Glide.with(getActivity()).load(getResources().getDrawable(R.drawable.featuresproductline)).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(features);
//        Glide.with(getActivity()).load(getResources().getDrawable(R.drawable.applicationproductline)).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(application);
        getActivity().setTitle(title);
        return view;
    }

    @Override
    public void onDestroyView() {
        getActivity().setTitle("Anchor Rods and Elements");
        super.onDestroyView();
        unbinder1.unbind();


    }

    @Override
    public void ondashboardclicked(int position) {

    }
}
