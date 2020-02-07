package jain.shreyans.nasapicturesapp.repository;

import android.content.Context;
import android.provider.ContactsContract;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import jain.shreyans.nasapicturesapp.models.ImageData;

public class ImageRepository {
    private static ImageRepository mInstance;
    private static Context mcontext;
    private List<ImageData> imageDataArray;

    public ImageRepository(Context context){
        mcontext = context;
    }

    public static void storeInstance(ImageRepository imageRepository){
        mInstance = imageRepository;
    }


    public static ImageRepository getInstance() {

        return mInstance;
    }

    public List<String> getImageUrl(){
        List<String> imageUrls = new ArrayList<>();
        for (ImageData imageData : imageDataArray) {
            imageUrls.add(imageData.url);
        }
        return imageUrls;
    }


   public void loadImageData(){
        Gson gson = new Gson();
       Type listType = new TypeToken<List<ImageData>>(){}.getType();
        imageDataArray = gson.fromJson(LoadData("data.json",mcontext), listType);

    }


    public String LoadData(String inFile, Context context) {
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;

    }

}
