package vision4.com.Modals;

public class AddsModel {
    private String name;
    private String contact_no;
    private String email;
    private String short_description;
    private String long_description;
    private String date;
    private String time;
    private String title;
    private boolean type;
    private float rating;
    private int rating_no;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public boolean isType() {
        return type;
    }

    public float getRating() {
        return rating;
    }

    public int getRating_no() {
        return rating_no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setRating_no(int rating_no) {
        this.rating_no = rating_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
