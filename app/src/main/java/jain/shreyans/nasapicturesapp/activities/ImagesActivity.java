package jain.shreyans.nasapicturesapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import jain.shreyans.nasapicturesapp.R;
import jain.shreyans.nasapicturesapp.repository.ImageRepository;

import android.os.Bundle;


public class ImagesActivity extends AppCompatActivity {


    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
    }
}
