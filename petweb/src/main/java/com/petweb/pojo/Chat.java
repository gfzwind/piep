package com.petweb.pojo;

import java.util.Objects;

/**
 * Create By yushe on 2020/5/24
 */
public class Chat {
    private int chid;
    private String chpub;
    private String chrec;
    private String chtime;
    private String chdetail;
    private int chstate;

    @Override
    public String toString() {
        return "Chat{" +
                "chid=" + chid +
                ", chpub='" + chpub + '\'' +
                ", chrec='" + chrec + '\'' +
                ", chtime='" + chtime + '\'' +
                ", chdetail='" + chdetail + '\'' +
                ", chstate=" + chstate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Chat chat = (Chat) o;
        return chid == chat.chid &&
                chstate == chat.chstate &&
                Objects.equals(chpub, chat.chpub) &&
                Objects.equals(chrec, chat.chrec) &&
                Objects.equals(chtime, chat.chtime) &&
                Objects.equals(chdetail, chat.chdetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chid, chpub, chrec, chtime, chdetail, chstate);
    }

    public int getChid() {
        return chid;
    }

    public void setChid(int chid) {
        this.chid = chid;
    }

    public String getChpub() {
        return chpub;
    }

    public void setChpub(String chpub) {
        this.chpub = chpub;
    }

    public String getChrec() {
        return chrec;
    }

    public void setChrec(String chrec) {
        this.chrec = chrec;
    }

    public String getChtime() {
        return chtime;
    }

    public void setChtime(String chtime) {
        this.chtime = chtime;
    }

    public String getChdetail() {
        return chdetail;
    }

    public void setChdetail(String chdetail) {
        this.chdetail = chdetail;
    }

    public int getChstate() {
        return chstate;
    }

    public void setChstate(int chstate) {
        this.chstate = chstate;
    }

    public Chat(String chpub, String chrec, String chtime, String chdetail, int chstate) {
        this.chpub = chpub;
        this.chrec = chrec;
        this.chtime = chtime;
        this.chdetail = chdetail;
        this.chstate = chstate;
    }

    public Chat() {
    }
}
