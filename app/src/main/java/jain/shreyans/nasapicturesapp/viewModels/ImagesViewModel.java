package jain.shreyans.nasapicturesapp.viewModels;

import java.util.List;

import androidx.lifecycle.ViewModel;
import jain.shreyans.nasapicturesapp.repository.ImageRepository;

public class ImagesViewModel extends ViewModel {
   public List<String> mImageUrls;

    public List<String> getmImageUrls() {
       mImageUrls = ImageRepository.getInstance().getImageUrl();
        return mImageUrls;
    }
}
