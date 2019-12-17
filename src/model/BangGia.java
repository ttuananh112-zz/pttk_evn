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
public class BangGia {
    private int maBangGia;
    private int maLoaiHopDong;
    private int mucBacThangGia;
    private long mucGia;

    public BangGia(int maBangGia, int maLoaiHopDong, int mucBacThangGia, long mucGia) {
        this.maBangGia = maBangGia;
        this.maLoaiHopDong = maLoaiHopDong;
        this.mucBacThangGia = mucBacThangGia;
        this.mucGia = mucGia;
    }

    public int getMaBangGia() {
        return maBangGia;
    }

    public void setMaBangGia(int maBangGia) {
        this.maBangGia = maBangGia;
    }

    public int getMaLoaiHopDong() {
        return maLoaiHopDong;
    }

    public void setMaLoaiHopDong(int maLoaiHopDong) {
        this.maLoaiHopDong = maLoaiHopDong;
    }

    public int getMucBacThangGia() {
        return mucBacThangGia;
    }

    public void setMucBacThangGia(int mucBacThangGia) {
        this.mucBacThangGia = mucBacThangGia;
    }

    public long getMucGia() {
        return mucGia;
    }

    public void setMucGia(long mucGia) {
        this.mucGia = mucGia;
    }
    
    
}
