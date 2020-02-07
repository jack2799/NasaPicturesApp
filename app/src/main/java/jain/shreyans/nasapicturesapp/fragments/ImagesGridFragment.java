package jain.shreyans.nasapicturesapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import jain.shreyans.nasapicturesapp.R;
import jain.shreyans.nasapicturesapp.adapters.ImageGridAdapter;
import jain.shreyans.nasapicturesapp.repository.ImageRepository;
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

        ImagesViewModel imagesViewModel = ViewModelProviders.of(this).get(ImagesViewModel.class);
        GridView gridView = (GridView) view.findViewById(R.id.image_grid);
        gridView.setAdapter(new ImageGridAdapter(getContext(),imagesViewModel.getmImageUrls()));

        return view;
    }

}
