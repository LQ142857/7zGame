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
                '}';
    }
}
