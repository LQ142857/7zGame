package com.a7z.sevenzgame.entity.po;

/**
 * @author lq
 * @create 2020/3/12-22:14
 */
public class Games {
    private int gid;
    private String name;
    private String company;
    private String price;
    private float discount;
    private String pubdate;
    private String cover;
    private String grade;
    private String state;
    private String describes;
    private String videourl;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescribe() {
        return describes;
    }

    public void setDescribes(String describe) {
        this.describes = describe;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    @Override
    public String toString() {
        return "Games{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price='" + price + '\'' +
                ", discount=" + discount +
                ", pubdate='" + pubdate + '\'' +
                ", cover='" + cover + '\'' +
                ", grade='" + grade + '\'' +
                ", state='" + state + '\'' +
                ", describe='" + describes + '\'' +
                ", videourl='" + videourl + '\'' +
                '}';
    }
}
