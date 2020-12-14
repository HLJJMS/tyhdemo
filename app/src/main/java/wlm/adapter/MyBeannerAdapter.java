package wlm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import wlm.base.BannerBean;
import wlm.tyhkj.R;

public class MyBeannerAdapter extends BannerAdapter<BannerBean, MyBeannerAdapter.ImageHolder> {

    private Context context;
    private OnClickItemListener onClickItemListener;

    public MyBeannerAdapter(List<BannerBean> datas, Context context) {
        super(datas);
        this.context = context;
    }

    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_image_title, parent, false));
    }

    @Override
    public void onBindView(ImageHolder holder, BannerBean data, int position, int size) {
        Glide.with(context).load(data.getSrc()).into(holder.imageView);
        holder.title.setText(data.title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.clickItemListener(data.getSrc());
            }
        });
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public class ImageHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.bannerTitle);
        }
    }

    public interface OnClickItemListener {
        void clickItemListener(String url);
    }
}
