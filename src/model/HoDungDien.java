/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tuananh
 */
public class HoDungDien {
    private int maHoDungDien;
    private DongHo dongHo;
    private KhachHang khachHang;
    private LoaiHopDong loaiHopDong;
    private String diaChi;
    private String phuong;
    private String quan;
    private String thanhPho;
    private long chiSoKhoiTao;

    
    public HoDungDien(int maHoDungDien, DongHo dongHo, KhachHang khachHang, LoaiHopDong loaiHopDong, String diaChi, String phuong, String quan, String thanhPho, long chiSoKhoiTao) {
        this.maHoDungDien = maHoDungDien;
        this.dongHo = dongHo;
        this.khachHang = khachHang;
        this.loaiHopDong = loaiHopDong;
        this.diaChi = diaChi;
        this.phuong = phuong;
        this.quan = quan;
        this.thanhPho = thanhPho;
        this.chiSoKhoiTao = chiSoKhoiTao;
    }

    public int getMaHoDungDien() {
        return maHoDungDien;
    }

    public void setMaHoDungDien(int maHoDungDien) {
        this.maHoDungDien = maHoDungDien;
    }

    public DongHo getDongHo() {
        return dongHo;
    }

    public void setDongHo(DongHo dongHo) {
        this.dongHo = dongHo;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public LoaiHopDong getLoaiHopDong() {
        return loaiHopDong;
    }

    public void setLoaiHopDong(LoaiHopDong loaiHopDong) {
        this.loaiHopDong = loaiHopDong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public long getChiSoKhoiTao() {
        return chiSoKhoiTao;
    }

    public void setChiSoKhoiTao(long chiSoKhoiTao) {
        this.chiSoKhoiTao = chiSoKhoiTao;
    }
    
    
}
