package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/17
 */
public class User {
    private String uid;
    private String uname;
    private String upassword;
    private String usex;
    private String uphoto;
    private long uphone;
    private long uintegral;
    private long ucredit;

    @Override
    public String toString() {
        return "user{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", usex='" + usex + '\'' +
                ", uphoto='" + uphoto + '\'' +
                ", uphone=" + uphone +
                ", uintegral=" + uintegral +
                ", ucredit=" + ucredit +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return uphone == user.uphone &&
                uintegral == user.uintegral &&
                ucredit == user.ucredit &&
                Objects.equals(uid, user.uid) &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(upassword, user.upassword) &&
                Objects.equals(usex, user.usex) &&
                Objects.equals(uphoto, user.uphoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, upassword, usex, uphoto, uphone, uintegral, ucredit);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUphoto() {
        return uphoto;
    }

    public void setUphoto(String uphoto) {
        this.uphoto = uphoto;
    }

    public long getUphone() {
        return uphone;
    }

    public void setUphone(long uphone) {
        this.uphone = uphone;
    }

    public long getUintegral() {
        return uintegral;
    }

    public void setUintegral(long uintegral) {
        this.uintegral = uintegral;
    }

    public long getUcredit() {
        return ucredit;
    }

    public void setUcredit(long ucredit) {
        this.ucredit = ucredit;
    }

    public User(String uid, String uname, String upassword, String usex, String uphoto, long uphone, long uintegral, long ucredit) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.usex = usex;
        this.uphoto = uphoto;
        this.uphone = uphone;
        this.uintegral = uintegral;
        this.ucredit = ucredit;
    }

    public User() {
    }
}
