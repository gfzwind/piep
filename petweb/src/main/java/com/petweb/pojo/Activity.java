package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/25
 */
public class Activity {
    private int vid;
    private String vtitle;
    private String vdetail;
    private String vphoto;
    private String vtime;
    private String uid;

    public Activity() {
    }

    public Activity(String vtitle, String vdetail, String vphoto, String vtime, String uid) {
        this.vtitle = vtitle;
        this.vdetail = vdetail;
        this.vphoto = vphoto;
        this.vtime = vtime;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "vid=" + vid +
                ", vtitle='" + vtitle + '\'' +
                ", vdetail='" + vdetail + '\'' +
                ", vphoto='" + vphoto + '\'' +
                ", vtime='" + vtime + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Activity activity = (Activity) o;
        return vid == activity.vid &&
                Objects.equals(vtitle, activity.vtitle) &&
                Objects.equals(vdetail, activity.vdetail) &&
                Objects.equals(vphoto, activity.vphoto) &&
                Objects.equals(vtime, activity.vtime) &&
                Objects.equals(uid, activity.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vid, vtitle, vdetail, vphoto, vtime, uid);
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getVtitle() {
        return vtitle;
    }

    public void setVtitle(String vtitle) {
        this.vtitle = vtitle;
    }

    public String getVdetail() {
        return vdetail;
    }

    public void setVdetail(String vdetail) {
        this.vdetail = vdetail;
    }

    public String getVphoto() {
        return vphoto;
    }

    public void setVphoto(String vphoto) {
        this.vphoto = vphoto;
    }

    public String getVtime() {
        return vtime;
    }

    public void setVtime(String vtime) {
        this.vtime = vtime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
