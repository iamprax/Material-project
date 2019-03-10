package in.prax.tamalproject.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.prax.tamalproject.BuyerProductsPojo;
import in.prax.tamalproject.OnDashboardclicklistener;
import in.prax.tamalproject.R;
import in.prax.tamalproject.view.MyTextView;


/**
 * Created by  on 12/01/18.
 */

public class DashboardAdapter extends RecyclerView.Adapter

{
    private static final int PHOTO_ANIMATION_DELAY = 600;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    private int mLastPosition;
    boolean farmer = false;
    private String username;
    private String User_type;
    private Typeface mTypeface;
    private LayoutInflater inflater;
    int images[] = {R.drawable.home1, R.drawable.home2, R.drawable.home3};

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


        if (position == 0) {
            return 2;
        } else if (position < mProductlist.size()) {
            return 0;
        }
        if (position <= mProductlist.size()) {
            return 1;
        }

        return -1;
    }

    public DashboardAdapter(ArrayList<BuyerProductsPojo> mProductlist, Context mContext) {
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
                    view = inflater.inflate(R.layout.adapt_dashboard_list_view, null);
                    ViewHolder viewHolder = new ViewHolder(view);
                    return viewHolder;
                case 1:
                    view = inflater.inflate(R.layout.adapt_dashboard_last_view, null);
                    lastViewHolder viewHolder1 = new lastViewHolder(view);
                    return viewHolder1;
                case 2:
                    view = inflater.inflate(R.layout.adapt_toolbar, null);
                    sliderViewholder viewHolder2 = new sliderViewholder(view);
                    return viewHolder2;
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position < mProductlist.size()) {

            if (position == 0) {
                for (int i = 0; i < images.length; i++) {
                    //  This will create dynamic image view and add them to ViewFlipper
                    ImageView image = new ImageView(mContext);
                    image.setBackgroundResource(images[i]);
                    ((sliderViewholder) holder).viewFlipper.addView(image);
                }

                ((sliderViewholder) holder).viewFlipper.setAutoStart(true);
                ((sliderViewholder) holder).viewFlipper.setFlipInterval(3000);
            } else {
                mLastPosition = holder.getAdapterPosition();

                ((ViewHolder) holder).carddash.setOnClickListener(v -> onDashboardclicklistener.ondashboardclicked(position));
                Log.e("onBindViewHolder: ", position + "color");
                ((ViewHolder) holder).txtDashValue.setText(mProductlist.get(position).getProductname());
                ((ViewHolder) holder).txtDashType.setImageResource(mProductlist.get(position).getId());
//                Glide.with(mContext).load(mContext.getResources().getIdentifier(mProductlist.get(position).getImageid(), "drawable", mContext.getPackageName())).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(((ViewHolder) holder).txtDashType);

            }

        }
    }


    @Override
    public int getItemCount() {
        return mProductlist == null ? 0 : mProductlist.size() + 1;
    }

    public void setLockedAnimations(boolean lockedAnimations) {
        boolean lockedAnimations1 = lockedAnimations;
    }

    public interface OnOfferSelected {
        void EditOffer(String Id);

        void Remove(String Id);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtDashType)
        AppCompatImageView txtDashType;
        @BindView(R.id.txtDashValue)
        MyTextView txtDashValue;
        @BindView(R.id.carddash)
        CardView carddash;

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


    private class sliderViewholder extends RecyclerView.ViewHolder {
        ViewFlipper viewFlipper;
        SliderAdapter myCustomPagerAdapter;

        public sliderViewholder(View view) {
            super(view);
            viewFlipper = itemView.findViewById(R.id.vpBanner);
            myCustomPagerAdapter = new SliderAdapter(mContext, images);

        }
    }
}


