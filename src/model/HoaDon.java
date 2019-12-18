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
public class HoaDon {

    private int maHoaDon;
    private NhanVien nhanVien;
    private HoDungDien hoDungDien;
    private String ngayTaoHoaDon;
    private ThongTinDongHo thongTinDongHo;

    private long tongSoDienSuDung;
    private long tienChuaVAT;
    private long thueVAT;
    private long tongTien;

    private int[] level = new int[]{0, 50, 100, 200, 300, 400};

    public HoaDon(int maHoaDon, NhanVien nhanVien, HoDungDien hoDungDien, String ngayTaoHoaDon, ThongTinDongHo thongTinDongHo) {
        this.maHoaDon = maHoaDon;
        this.nhanVien = nhanVien;
        this.hoDungDien = hoDungDien;
        this.ngayTaoHoaDon = ngayTaoHoaDon;
        this.thongTinDongHo = thongTinDongHo;

        this.tongSoDienSuDung = thongTinDongHo.getChiSoMoi() - thongTinDongHo.getChiSoCu();
        this.tienChuaVAT = calculateAmount();
        this.thueVAT = (long) (this.tienChuaVAT * 0.1);
        this.tongTien = this.tienChuaVAT + this.thueVAT;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public HoDungDien getHoDungDien() {
        return hoDungDien;
    }

    public void setHoDungDien(HoDungDien hoDungDien) {
        this.hoDungDien = hoDungDien;
    }

    public String getNgayTaoHoaDon() {
        return ngayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(String ngayTaoHoaDon) {
        this.ngayTaoHoaDon = ngayTaoHoaDon;
    }

    public ThongTinDongHo getThongTinDongHo() {
        return thongTinDongHo;
    }

    public void setThongTinDongHo(ThongTinDongHo thongTinDongHo) {
        this.thongTinDongHo = thongTinDongHo;
    }

    public long getTongSoDienSuDung() {
        return tongSoDienSuDung;
    }

    public void setTongSoDienSuDung(long tongSoDienSuDung) {
        this.tongSoDienSuDung = tongSoDienSuDung;
    }

    public long getTienChuaVAT() {
        return tienChuaVAT;
    }

    public void setTienChuaVAT(long tienChuaVAT) {
        this.tienChuaVAT = tienChuaVAT;
    }

    public long getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(long thueVAT) {
        this.thueVAT = thueVAT;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    private long calculateAmount() {
        long total = 0;
        int iter;
        long soDien_left = 0;
        ArrayList<BangGia> listBangGia = hoDungDien.getLoaiHopDong().getListBangGia();
        
        for(iter=0; iter<level.length; iter++){
            if(this.tongSoDienSuDung <= level[iter])
                break;
        }
        
        // left amount of soDien
        soDien_left = this.tongSoDienSuDung - level[iter-1];
        
        for(int i=1; i<iter; i++){
            total += (level[i]-level[i-1]) * listBangGia.get(i-1).getMucGia();
        }
        total += soDien_left * listBangGia.get(iter-1).getMucGia();
        
        return total;
    }

}
