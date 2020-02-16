package jain.shreyans.nasapicturesapp.viewModels;

import java.util.List;

import androidx.lifecycle.ViewModel;
import jain.shreyans.nasapicturesapp.repository.ImageRepository;

public class ImagesViewModel extends ViewModel {
    private List<String> imageUrls;
    private List<String> hDImageUrls;
    private List<String> dates;
    private List<String> titles;
    private List<String> copyrights;
    private List<String> serviceVersions;
    private List<String> explanations;

    public List<String> getImageUrls() {

        imageUrls = ImageRepository.getInstance().getImageUrl();
        return imageUrls;
    }

    public List<String> gethDImageUrls() {
        hDImageUrls = ImageRepository.getInstance().getHDImageUrl();
        return hDImageUrls;
    }

    public List<String> getTitles() {
        titles = ImageRepository.getInstance().getTitle();
        return titles;
    }

    public List<String> getCopyrights() {
        copyrights = ImageRepository.getInstance().getCopyright();
        return copyrights;
    }

    public List<String> getDates() {
        dates = ImageRepository.getInstance().getDate();
        return dates;
    }

    public List<String> getExplanations() {
        explanations = ImageRepository.getInstance().getExplanation();
        return explanations;
    }

    public List<String> getServiceVersions() {
        serviceVersions = ImageRepository.getInstance().getServiceVersion();
        return serviceVersions;
    }


}
