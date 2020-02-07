package jain.shreyans.nasapicturesapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jain.shreyans.nasapicturesapp.R;

public class ImageGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mImageUrls ;

    public ImageGridAdapter(Context context, List<String> imageUrls){
         mContext = context;
         mImageUrls = imageUrls;

    }

    @Override
    public int getCount() {
        return mImageUrls.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
           imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        Glide.with(mContext)
                .load(mImageUrls.get(i))
                .placeholder(R.drawable.ic_image_place_holder) // image resource as a placeholder before Glide starts loading the image.
                .error(R.drawable.ic_broken_image) // image resource as an error placeholder when Glide is unable to load the image.
                .fallback(R.drawable.ic_no_image) // fallback image resource when the url can be null
                .into(imageView); // Set the ImageView as the target.
        return imageView;
    }
}
