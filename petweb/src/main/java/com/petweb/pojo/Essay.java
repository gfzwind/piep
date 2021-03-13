package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/17
 */
public class Essay {
    private int eid;
    private String uid;
    private int eeid;
    private String edetail;
    private int elike;
    private String etitle;
    private String eimg;

    public Essay() {
    }

    public Essay(String uid, String etitle, String edetail, String eimg) {
        this.uid = uid;
        this.edetail = edetail;
        this.etitle = etitle;
        this.eimg = eimg;
    }

    public Essay(String uid, int eeid, String edetail) {
        this.uid = uid;
        this.eeid = eeid;
        this.edetail = edetail;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "eid=" + eid +
                ", uid='" + uid + '\'' +
                ", eeid=" + eeid +
                ", edetail='" + edetail + '\'' +
                ", elike=" + elike +
                ", etitle='" + etitle + '\'' +
                ", eimg='" + eimg + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Essay essay = (Essay) o;
        return eid == essay.eid &&
                eeid == essay.eeid &&
                elike == essay.elike &&
                Objects.equals(uid, essay.uid) &&
                Objects.equals(edetail, essay.edetail) &&
                Objects.equals(etitle, essay.etitle) &&
                Objects.equals(eimg, essay.eimg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eid, uid, eeid, edetail, elike, etitle, eimg);
    }

    public Essay(int eid, String uid, int eeid, String edetail, int elike, String etitle, String eimg) {
        this.eid = eid;
        this.uid = uid;
        this.eeid = eeid;
        this.edetail = edetail;
        this.elike = elike;
        this.etitle = etitle;
        this.eimg = eimg;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getEeid() {
        return eeid;
    }

    public void setEeid(int eeid) {
        this.eeid = eeid;
    }

    public String getEdetail() {
        return edetail;
    }

    public void setEdetail(String edetail) {
        this.edetail = edetail;
    }

    public int getElike() {
        return elike;
    }

    public void setElike(int elike) {
        this.elike = elike;
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }

    public String getEimg() {
        return eimg;
    }

    public void setEimg(String eimg) {
        this.eimg = eimg;
    }
}
