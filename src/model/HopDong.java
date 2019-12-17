/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author tuananh
 */
public class HopDong {
    private int maHopDong;
    private KhachHang khachHang;
    private ArrayList<HoDungDien> listHoDungDien;
    private QuanLy quanLy;
    private Date ngayKyHopDong;

    public HopDong(int maHopDong, KhachHang khachHang, ArrayList<HoDungDien> listHoDungDien, QuanLy quanLy, Date ngayKyHopDong) {
        this.maHopDong = maHopDong;
        this.khachHang = khachHang;
        this.listHoDungDien = listHoDungDien;
        this.quanLy = quanLy;
        this.ngayKyHopDong = ngayKyHopDong;
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public ArrayList<HoDungDien> getListHoDungDien() {
        return listHoDungDien;
    }

    public void setListHoDungDien(ArrayList<HoDungDien> listHoDungDien) {
        this.listHoDungDien = listHoDungDien;
    }

    public QuanLy getQuanLy() {
        return quanLy;
    }

    public void setQuanLy(QuanLy quanLy) {
        this.quanLy = quanLy;
    }

    public Date getNgayKyHopDong() {
        return ngayKyHopDong;
    }

    public void setNgayKyHopDong(Date ngayKyHopDong) {
        this.ngayKyHopDong = ngayKyHopDong;
    }
    
    public void addHoDungDien(HoDungDien hoDungDien){
        this.listHoDungDien.add(hoDungDien);
    }
    
}
