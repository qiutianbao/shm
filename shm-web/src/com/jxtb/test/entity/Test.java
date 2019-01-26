package com.jxtb.test.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cbd_test")
public class Test implements Serializable {

    @Id
    @Column(name = "id",length = 32)
    private String id;

    @Column(name = "userName",length = 100)
    private String userName;

    @Column(name = "userPsw",length = 100)
    private String userPsw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }
}

