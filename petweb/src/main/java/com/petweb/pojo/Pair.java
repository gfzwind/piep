package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/4/17
 */
public class Pair {
    private int pid;
    private String ppublisher;
    private String preceiver;
    private int ppet;
    private int pstate;
    private String pdetail;

    public Pair(String ppublisher, int ppet, String pdetail) {
        this.ppublisher = ppublisher;
        this.ppet = ppet;
        this.pdetail = pdetail;
    }

    public Pair(String ppublisher, String preceiver, int ppet) {
        this.ppublisher = ppublisher;
        this.preceiver = preceiver;
        this.ppet = ppet;
    }

    @Override
    public String toString() {
        return "pair{" +
                "pid=" + pid +
                ", ppublisher='" + ppublisher + '\'' +
                ", preceiver='" + preceiver + '\'' +
                ", ppet=" + ppet +
                ", pstate=" + pstate +
                ", pdetail='" + pdetail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return pid == pair.pid &&
                ppet == pair.ppet &&
                pstate == pair.pstate &&
                Objects.equals(ppublisher, pair.ppublisher) &&
                Objects.equals(preceiver, pair.preceiver) &&
                Objects.equals(pdetail, pair.pdetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, ppublisher, preceiver, ppet, pstate, pdetail);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPpublisher() {
        return ppublisher;
    }

    public void setPpublisher(String ppublisher) {
        this.ppublisher = ppublisher;
    }

    public String getPreceiver() {
        return preceiver;
    }

    public void setPreceiver(String preceiver) {
        this.preceiver = preceiver;
    }

    public int getPpet() {
        return ppet;
    }

    public void setPpet(int ppet) {
        this.ppet = ppet;
    }

    public int getPstate() {
        return pstate;
    }

    public void setPstate(int pstate) {
        this.pstate = pstate;
    }

    public String getPdetail() {
        return pdetail;
    }

    public void setPdetail(String pdetail) {
        this.pdetail = pdetail;
    }

    public Pair(int pid, String ppublisher, String preceiver, int ppet, int pstate, String pdetail) {
        this.pid = pid;
        this.ppublisher = ppublisher;
        this.preceiver = preceiver;
        this.ppet = ppet;
        this.pstate = pstate;
        this.pdetail = pdetail;
    }

    public Pair() {
    }
}
