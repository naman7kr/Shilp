package vision4.com.Modals;
/*
 * Created by sanay
 * on 16/11/2018
 */

/*
    Modal class for the top categories on the feeds fragment
    contains:
    empty Constructor
    complete constructor
    getters and setters of all variables
*/

public class Topcategories {

    int imageRes;
    String name;

    public Topcategories() {
    }

    public Topcategories(int imageRes, String name) {
        this.imageRes = imageRes;
        this.name = name;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
