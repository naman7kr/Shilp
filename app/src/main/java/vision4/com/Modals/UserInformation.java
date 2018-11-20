package vision4.com.Modals;

public class UserInformation {
    private String name;
    private String email;
    private String contact_no;
    private String password;
    private String photo;
    private float hire_rating;
    private int hire_rating_no;
    private float sell_rating;
    private int sell_rating_no;
    private String uid;
    private String[] tags;
    private String pastWorks;
    private String aboutMe;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public String getPassword() {
        return password;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getPhoto() {
        return photo;
    }

    public float getHire_rating() {
        return hire_rating;
    }

    public int getHire_rating_no() {
        return hire_rating_no;
    }

    public float getSell_rating() {
        return sell_rating;
    }

    public int getSell_rating_no() {
        return sell_rating_no;
    }

    public String getUid() {
        return uid;
    }

    public String[] getTags() {
        return tags;
    }

    public String getPastWorks() {
        return pastWorks;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setHire_rating(float hire_rating) {
        this.hire_rating = hire_rating;
    }

    public void setHire_rating_no(int hire_rating_no) {
        this.hire_rating_no = hire_rating_no;
    }

    public void setSell_rating(float sell_rating) {
        this.sell_rating = sell_rating;
    }

    public void setSell_rating_no(int sell_rating_no) {
        this.sell_rating_no = sell_rating_no;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setPastWorks(String pastWorks) {
        this.pastWorks = pastWorks;
    }
}
