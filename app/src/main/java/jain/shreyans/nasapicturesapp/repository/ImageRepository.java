package jain.shreyans.nasapicturesapp.repository;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import jain.shreyans.nasapicturesapp.appClass.App;
import jain.shreyans.nasapicturesapp.models.ImageData;

public class ImageRepository {
    private static ImageRepository instance;
    private List<ImageData> imageDataArray;


    public static ImageRepository getInstance() {
        if (instance==null) {
            instance = new ImageRepository();
            instance.loadImageData();
        }
        return instance;
    }

    public List<String> getImageUrl(){
        List<String> imageUrls = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            imageUrls.add(imageData.url);
        }
        return imageUrls;
    }

    public List<String> getHDImageUrl(){
        List<String> imageUrls = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            imageUrls.add(imageData.hdurl);
        }
        return imageUrls;
    }

    public List<String> getTitle(){
        List<String> titles = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            titles.add(imageData.title);
        }
        return titles;
    }

    public List<String> getCopyright(){
        List<String> copyrightInfo = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            copyrightInfo.add(imageData.copyright);
        }
        return copyrightInfo;
    }

    public List<String> getDate(){
        List<String> dates = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            dates.add(imageData.date);
        }
        return dates;
    }

    public List<String> getServiceVersion(){
        List<String> serviceVersions = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            serviceVersions.add(imageData.service_version);
        }
        return serviceVersions;
    }

    public List<String> getExplanation(){
        List<String> explanations = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            explanations.add(imageData.explanation);
        }
        return explanations;
    }


   public void loadImageData(){
        Gson gson = new Gson();
       Type listType = new TypeToken<List<ImageData>>(){}.getType();
        imageDataArray = gson.fromJson(LoadData("data.json", App.getAppContext()), listType);

    }


    public String LoadData(String inFile, Context context) {
        String contents = "";

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            contents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return contents;

    }

}
