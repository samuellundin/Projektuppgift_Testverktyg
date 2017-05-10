package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by josef on 5/9/2017.
 */

@Entity
@Table
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userGroupId;
    private String user;


    @OneToMany(targetEntity = User.class)
    private List userList;


    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGrouId(int userGroupId) { //Primary Key
        this.userGroupId = userGroupId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }
}

