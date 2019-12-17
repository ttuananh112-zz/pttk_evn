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
public class NhanVien extends Nguoi{
    private int maNhanVien;

    public NhanVien(int maNhanVien, String ten, String cmtnd, String diaChi, String sdt, String email) {
        super(ten, cmtnd, diaChi, sdt, email);
        this.maNhanVien = maNhanVien;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

}
