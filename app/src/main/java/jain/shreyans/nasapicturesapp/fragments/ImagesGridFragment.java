package jain.shreyans.nasapicturesapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.listeners.OnImageChangeListener;
import com.stfalcon.imageviewer.loader.ImageLoader;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import jain.shreyans.nasapicturesapp.R;
import jain.shreyans.nasapicturesapp.adapters.ImageGridAdapter;
import jain.shreyans.nasapicturesapp.viewModels.ImagesViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesGridFragment extends Fragment {


    public ImagesGridFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_images_grid, container, false);

        final ImagesViewModel imagesViewModel = ViewModelProviders.of(this).get(ImagesViewModel.class);
        GridView imageGridView = (GridView) view.findViewById(R.id.image_grid);
        imageGridView.setAdapter(new ImageGridAdapter(getContext(), imagesViewModel.getImageUrls()));
        imageGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final View overlayView = View.inflate(getContext(), R.layout.overlay_image, null);
                TextView title = overlayView.findViewById(R.id.title);
                title.setText(imagesViewModel.getTitles().get(position));
                TextView copyright = overlayView.findViewById(R.id.copyright);
                copyright.setText(imagesViewModel.getCopyrights().get(position));
                TextView date = overlayView.findViewById(R.id.date);
                date.setText(imagesViewModel.getDates().get(position));
                TextView serviceVersion = overlayView.findViewById(R.id.service_version);
                serviceVersion.setText(imagesViewModel.getServiceVersions().get(position));
                TextView explanation = overlayView.findViewById(R.id.explanation);
                explanation.setText(imagesViewModel.getExplanations().get(position));
                final StfalconImageViewer imageViewer =
                        new StfalconImageViewer.Builder<>(getContext(), imagesViewModel.gethDImageUrls(), new ImageLoader<String>() {
                            @Override
                            public void loadImage(final ImageView imageView, String image) {
                                Glide.with(getContext())
                                        .load(image)
                                        .placeholder(R.drawable.ic_image_place_holder) // image resource as a placeholder before Glide starts loading the image.
                                        .error(R.drawable.ic_broken_image) // image resource as an error placeholder when Glide is unable to load the image.
                                        .fallback(R.drawable.ic_no_image) // fallback image resource when the url can be null
                                        .into(imageView);// Set the ImageView as the target.

                            }
                        }).withStartPosition(position)
                                .withImageChangeListener(new OnImageChangeListener() {
                                    @Override
                                    public void onImageChange(int position) {
                                        TextView title = overlayView.findViewById(R.id.title);
                                        title.setText(imagesViewModel.getTitles().get(position));
                                        TextView copyright = overlayView.findViewById(R.id.copyright);
                                        copyright.setText(imagesViewModel.getCopyrights().get(position));
                                        TextView date = overlayView.findViewById(R.id.date);
                                        date.setText(imagesViewModel.getDates().get(position));
                                        TextView serviceVersion = overlayView.findViewById(R.id.service_version);
                                        serviceVersion.setText(imagesViewModel.getServiceVersions().get(position));
                                        TextView explanation = overlayView.findViewById(R.id.explanation);
                                        explanation.setText(imagesViewModel.getExplanations().get(position));
                                    }
                                })
                                .withOverlayView(overlayView)
                                .withBackgroundColorResource(R.color.white)
                                .show();
            }
        });
        return view;
    }

}
