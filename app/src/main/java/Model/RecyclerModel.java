package Model;

import java.util.Random;

/**
 * Created by Pranay on 14-01-2017.
 */

public class RecyclerModel {
    private Integer image;
    private String name;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return String.valueOf(new Random().nextInt(10));
    }

    public void setName(String name) {
        this.name = name;
    }
}
