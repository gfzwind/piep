package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/17
 */
public class Deal {
    private int did;
    private String dpublisher;
    private int dpet;
    private int dstate;
    private String ddetail;
    private double dprice;

    @Override
    public String toString() {
        return "Deal{" +
                "did=" + did +
                ", dpublisher='" + dpublisher + '\'' +
                ", dpet=" + dpet +
                ", dstate=" + dstate +
                ", ddetail='" + ddetail + '\'' +
                ", dprice=" + dprice +
                '}';
    }

    public Deal(String dpublisher, int dpet, double dprice) {
        this.dpublisher = dpublisher;
        this.dpet = dpet;
        this.dprice = dprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Deal deal = (Deal) o;
        return did == deal.did &&
                dpet == deal.dpet &&
                dstate == deal.dstate &&
                Double.compare(deal.dprice, dprice) == 0 &&
                Objects.equals(dpublisher, deal.dpublisher) &&
                Objects.equals(ddetail, deal.ddetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dpublisher, dpet, dstate, ddetail, dprice);
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDpublisher() {
        return dpublisher;
    }

    public void setDpublisher(String dpublisher) {
        this.dpublisher = dpublisher;
    }

    public int getDpet() {
        return dpet;
    }

    public void setDpet(int dpet) {
        this.dpet = dpet;
    }

    public int getDstate() {
        return dstate;
    }

    public void setDstate(int dstate) {
        this.dstate = dstate;
    }

    public String getDdetail() {
        return ddetail;
    }

    public void setDdetail(String ddetail) {
        this.ddetail = ddetail;
    }

    public double getDprice() {
        return dprice;
    }

    public void setDprice(double dprice) {
        this.dprice = dprice;
    }

    public Deal(int did, String dpublisher, int dpet, int dstate, String ddetail, double dprice) {
        this.did = did;
        this.dpublisher = dpublisher;
        this.dpet = dpet;
        this.dstate = dstate;
        this.ddetail = ddetail;
        this.dprice = dprice;
    }

    public Deal() {
    }
}
