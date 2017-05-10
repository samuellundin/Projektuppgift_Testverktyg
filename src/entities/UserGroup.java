package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josef on 5/9/2017.
 */

@Entity
@Table
public class UserGroup implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int role;

    @OneToMany
    private List<User> users;

    public void UserGroup() {
        ArrayList userList = new ArrayList();

        userList.add(1,firstName);
        userList.add(2,lastName);
        userList.add(3,email);
        userList.add(4,password);
        userList.add(5,role);
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }
}
