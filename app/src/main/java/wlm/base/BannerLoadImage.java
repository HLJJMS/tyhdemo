package wlm.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

import wlm.tyhkj.R;

public class BannerLoadImage extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        RequestOptions options = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE).placeholder(R.drawable.bd_logo);
        Glide.with(context).load(path).apply(options).into(imageView);
    }
}
