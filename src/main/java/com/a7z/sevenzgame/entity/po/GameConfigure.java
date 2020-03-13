package com.a7z.sevenzgame.entity.po;

/**
 * @author lq
 * @create 2020/3/12-22:20
 */
public class GameConfigure {
    private String gid;
    private String system;
    private String cpu;
    private String gpu;
    private String ram;
    private String rom;
    private int net;
    private String directx;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
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

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public String getDirectx() {
        return directx;
    }

    public void setDirectx(String directx) {
        this.directx = directx;
    }

    @Override
    public String toString() {
        return "GameConfigure{" +
                "gid='" + gid + '\'' +
                ", system='" + system + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", net=" + net +
                ", directx='" + directx + '\'' +
                '}';
    }
}
