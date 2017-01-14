package dummyData;

import com.customview.pranay.designlibrary.R;

import java.util.ArrayList;
import java.util.List;

import Model.RecyclerModel;

/**
 * Created by Pranay on 14-01-2017.
 */

public class DummyData {
    List<RecyclerModel> data = new ArrayList<>();

    public DummyData() {
        setImage();
    }

    private void setImage() {
        for (int i=0;i<10;i++){
            RecyclerModel model = new RecyclerModel();
            model.setImage(R.drawable.img);
            data.add(model);
        }
    }
    public RecyclerModel getData(){
        RecyclerModel model = new RecyclerModel();
        model.setImage(R.drawable.img);
        return model;
    }
    public List<RecyclerModel> getImages() {
        return data;
    }

}
