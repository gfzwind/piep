package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/17
 */
public class Pet {
    private int pid;
    private String uid;
    private String pname;
    private String pbirthday;
    private String phealth;
    private String pbreed;
    private String pdetail;
    private String pphoto;

    public Pet() {
    }

    public Pet(String uid, String pname, String pbirthday, String phealth, String pbreed, String pdetail, String pphoto) {
        this.uid = uid;
        this.pname = pname;
        this.pbirthday = pbirthday;
        this.phealth = phealth;
        this.pbreed = pbreed;
        this.pdetail = pdetail;
        this.pphoto = pphoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pet pet = (Pet) o;
        return pid == pet.pid &&
                Objects.equals(uid, pet.uid) &&
                Objects.equals(pname, pet.pname) &&
                Objects.equals(pbirthday, pet.pbirthday) &&
                Objects.equals(phealth, pet.phealth) &&
                Objects.equals(pbreed, pet.pbreed) &&
                Objects.equals(pdetail, pet.pdetail) &&
                Objects.equals(pphoto, pet.pphoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, uid, pname, pbirthday, phealth, pbreed, pdetail, pphoto);
    }

    @Override
    public String toString() {
        return "pet{" +
                "pid=" + pid +
                ", uid='" + uid + '\'' +
                ", pname='" + pname + '\'' +
                ", pbirthday='" + pbirthday + '\'' +
                ", phealth='" + phealth + '\'' +
                ", pbreed='" + pbreed + '\'' +
                ", pdetail='" + pdetail + '\'' +
                ", pphoto='" + pphoto + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPbirthday() {
        return pbirthday;
    }

    public void setPbirthday(String pbirthday) {
        this.pbirthday = pbirthday;
    }

    public String getPhealth() {
        return phealth;
    }

    public void setPhealth(String phealth) {
        this.phealth = phealth;
    }

    public String getPbreed() {
        return pbreed;
    }

    public void setPbreed(String pbreed) {
        this.pbreed = pbreed;
    }

    public String getPdetail() {
        return pdetail;
    }

    public void setPdetail(String pdetail) {
        this.pdetail = pdetail;
    }

    public String getPphoto() {
        return pphoto;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }

    public Pet(int pid, String uid, String pname, String pbirthday, String phealth, String pbreed, String pdetail, String pphoto) {
        this.pid = pid;
        this.uid = uid;
        this.pname = pname;
        this.pbirthday = pbirthday;
        this.phealth = phealth;
        this.pbreed = pbreed;
        this.pdetail = pdetail;
        this.pphoto = pphoto;
    }
}
