package com.a7z.sevenzgame.entity.vo;

import java.util.List;

/**
 * @author lq
 * @create 2020/3/12-22:30
 */
public class GameCommit {
    private String name;
    private String company;
    private String price;
    private float discount;
    private String tag;
    private String describe;
    private List<String> imgList;
    private String videourl;
    private int net;
    private String system;
    private String cpu;
    private String gpu;
    private String ram;
    private String rom;
    private String directx;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getDirectx() {
        return directx;
    }

    public void setDirectx(String directx) {
        this.directx = directx;
    }

    @Override
    public String toString() {
        return "GameCommit{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price='" + price + '\'' +
                ", discount=" + discount +
                ", tag='" + tag + '\'' +
                ", describe='" + describe + '\'' +
                ", imgList=" + imgList +
                ", videourl='" + videourl + '\'' +
                ", net=" + net +
                ", system='" + system + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", directx='" + directx + '\'' +
                '}';
    }
}
