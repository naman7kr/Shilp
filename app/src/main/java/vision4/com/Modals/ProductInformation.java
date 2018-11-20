package vision4.com.Modals;

public class ProductInformation {
    private String p_name;
    private float p_price;
    private String p_desc;
    private float p_rat;
    private int p_rat_no;
    private String seller_contact_no;
    private String type;
    private String seller_name;
    private String seller_email;
    private int qty;

    public String getType() {
        return type;
    }

    public String getSeller_contact_no() {
        return seller_contact_no;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public String getP_name() {
        return p_name;
    }

    public float getP_price() {
        return p_price;
    }

    public int getQty() {
        return qty;
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



    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public void setP_rat(float p_rat) {
        this.p_rat = p_rat;
    }

    public void setP_rat_no(int p_rat_no) {
        this.p_rat_no = p_rat_no;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setSeller_contact_no(String seller_contact_no) {
        this.seller_contact_no = seller_contact_no;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public void setP_price(float p_price) {
        this.p_price = p_price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
