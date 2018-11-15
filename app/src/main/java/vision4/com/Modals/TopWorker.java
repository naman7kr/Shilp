package vision4.com.Modals;
/*
 * Created by sanay
 * on 16/11/2018
 */


/*
    Modal class for the top Workers on the feeds fragment
    contains:
    empty Constructor
    complete constructor
    getters and setters of all variables
*/

public class TopWorker {
    String name,email,phone;

    public TopWorker() {
    }

    public TopWorker(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
