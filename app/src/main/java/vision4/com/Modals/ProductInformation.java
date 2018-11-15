package vision4.com.Modals;

public class ProductInformation {
    private String p_name;
    private String p_price;
    private String p_desc;
    private float p_rat;
    private int p_rat_no;
    private String contact_no;
    private String type;

    public String getContact_no() {
        return contact_no;
    }

    public String getType() {
        return type;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_price() {
        return p_price;
    }

    public String getP_desc() {
        return p_desc;
    }

    public float getP_rat() {
        return p_rat;
    }

    public int getP_rat_no() {
        return p_rat_no;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public void setP_rat(float p_rat) {
        this.p_rat = p_rat;
    }

    public void setP_rat_no(int p_rat_no) {
        this.p_rat_no = p_rat_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setType(String type) {
        this.type = type;
    }
}
