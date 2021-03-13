package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/17
 */
public class Mission {
    private int mid;
    private String mpublisher;
    private String mreceiver;
    private String mtitle;
    private String mdetail;
    private int mstate;
    private String mdeadline;

    public Mission() {
    }

    public Mission(String mpublisher, String mtitle, String mdetail, String mdeadline) {
        this.mpublisher = mpublisher;
        this.mtitle = mtitle;
        this.mdetail = mdetail;
        this.mdeadline = mdeadline;
    }

    public Mission(int mid, String mreceiver) {
        this.mid = mid;
        this.mreceiver = mreceiver;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "mid=" + mid +
                ", mpublisher='" + mpublisher + '\'' +
                ", mreceiver='" + mreceiver + '\'' +
                ", mtitle='" + mtitle + '\'' +
                ", mdetail='" + mdetail + '\'' +
                ", mstate=" + mstate +
                ", mdeadline='" + mdeadline + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Mission mission = (Mission) o;
        return mid == mission.mid &&
                mstate == mission.mstate &&
                Objects.equals(mpublisher, mission.mpublisher) &&
                Objects.equals(mreceiver, mission.mreceiver) &&
                Objects.equals(mtitle, mission.mtitle) &&
                Objects.equals(mdetail, mission.mdetail) &&
                Objects.equals(mdeadline, mission.mdeadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mid, mpublisher, mreceiver, mtitle, mdetail, mstate, mdeadline);
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMpublisher() {
        return mpublisher;
    }

    public void setMpublisher(String mpublisher) {
        this.mpublisher = mpublisher;
    }

    public String getMreceiver() {
        return mreceiver;
    }

    public void setMreceiver(String mreceiver) {
        this.mreceiver = mreceiver;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMdetail() {
        return mdetail;
    }

    public void setMdetail(String mdetail) {
        this.mdetail = mdetail;
    }

    public int getMstate() {
        return mstate;
    }

    public void setMstate(int mstate) {
        this.mstate = mstate;
    }

    public String getMdeadline() {
        return mdeadline;
    }

    public void setMdeadline(String mdeadline) {
        this.mdeadline = mdeadline;
    }

    public Mission(int mid, String mpublisher, String mreceiver, String mtitle, String mdetail, int mstate, String mdeadline) {
        this.mid = mid;
        this.mpublisher = mpublisher;
        this.mreceiver = mreceiver;
        this.mtitle = mtitle;
        this.mdetail = mdetail;
        this.mstate = mstate;
        this.mdeadline = mdeadline;
    }
}
