package in.prax.tamalproject.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.prax.tamalproject.BuyerProductsPojo;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;

public class ProductDetailAdapter extends RecyclerView.Adapter

{
    private static final int PHOTO_ANIMATION_DELAY = 600;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    private int mLastPosition;
    boolean farmer = false;
    private String username;
    private String User_type;
    private Typeface mTypeface;
    private LayoutInflater inflater;

    private int previousPosition = 0;
    OnDashboardclicklistener onDashboardclicklistener;

    public void setOnDashboardclicklistener(OnDashboardclicklistener onDashboardclicklistener) {
        this.onDashboardclicklistener = onDashboardclicklistener;
    }

    int[] color = {R.color.GRAPEFRUIT, R.color.bittersweet, R.color.Sunflower, R.color.grass, R.color.mint, R.color.lavender, R.color.pinkrose, R.color.grey_light};
    private final ArrayList<BuyerProductsPojo> mProductlist;
    private final Context mContext;
    private int weight;
    private int lastAnimatedItem = -1;

    @Override
    public int getItemViewType(int position) {

        if (position < mProductlist.size()) {
            return 0;
        }
        if (position <= mProductlist.size()) {
            return 1;
        }

        return -1;
    }

    public ProductDetailAdapter(ArrayList<BuyerProductsPojo> mProductlist, Context mContext) {
        this.mProductlist = mProductlist;
        inflater = LayoutInflater.from(mContext);

        this.mContext = mContext;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mTypeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/Roboto_Regular.ttf");


        View view;
        if (viewType != -1) {
            switch (viewType) {
                case 0:
                    view = inflater.inflate(R.layout.adapt_product_detail_list_view, null);
                    ProductDetailAdapter.ViewHolder viewHolder = new ProductDetailAdapter.ViewHolder(view);
                    return viewHolder;
                case 1:
                    view = inflater.inflate(R.layout.adapt_dashboard_last_view, null);
                    ProductDetailAdapter.lastViewHolder viewHolder1 = new ProductDetailAdapter.lastViewHolder(view);
                    return viewHolder1;
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position < mProductlist.size()) {
            mLastPosition = holder.getAdapterPosition();

            ((ProductDetailAdapter.ViewHolder) holder).cardProduct.setOnClickListener(v -> onDashboardclicklistener.ondashboardclicked(position));
            Log.e("onBindViewHolder: ", position + "color");
            ((ProductDetailAdapter.ViewHolder) holder).txtProducts.setText(mProductlist.get(position).getProductname());
            Glide.with(mContext).load(mContext.getResources().getIdentifier(mProductlist.get(position).getImageid(), "drawable", mContext.getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(((ProductDetailAdapter.ViewHolder) holder).imgProduct);
        }
    }


    @Override
    public int getItemCount() {
        return mProductlist == null ? 0 : mProductlist.size();
    }

    public void setLockedAnimations(boolean lockedAnimations) {
        boolean lockedAnimations1 = lockedAnimations;
    }

    public interface OnOfferSelected {
        void EditOffer(String Id);

        void Remove(String Id);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgProduct)
        AppCompatImageView imgProduct;
        @BindView(R.id.ccardproducts)
        CardView cardProduct;
        @BindView(R.id.txtProducts)
        AppCompatTextView txtProducts;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public class lastViewHolder extends RecyclerView.ViewHolder {

        public lastViewHolder(View itemView) {
            super(itemView);


        }
    }

    private void showToast(String results) {
        Toast.makeText(mContext, results, Toast.LENGTH_SHORT).show();
    }


}


