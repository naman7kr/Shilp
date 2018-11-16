package vision4.com.Modals;

import android.widget.ImageView;

public class HireCraftManModal {

    String name,category;
    ImageView imageView;

    public HireCraftManModal(String name,String category,ImageView imageView)
    {
        this.category=category;
        this.name=name;
        this.imageView=imageView;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public ImageView getImageView() {
        return imageView;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
