package vision4.com.Modals;

public class CategoryModal {

    int imageURL;
    String categoryName;

    public CategoryModal() {

    }

    public CategoryModal(int imageURL, String categoryName) {
        this.imageURL = imageURL;
        this.categoryName = categoryName;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
