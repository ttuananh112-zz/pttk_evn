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
public class KhachHang extends Nguoi{
    private int maKhachHang;

    public KhachHang(int maKhachHang, String ten, String cmtnd, String diaChi, String sdt, String email) {
        super(ten, cmtnd, diaChi, sdt, email);
        this.maKhachHang = maKhachHang;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    @Override
    public String toString(){
        return (this.maKhachHang +" "+ this.getTen() +" "+ this.getCmtnd() +" "+ this.getDiaChi() +" "+ this.getSdt()+" "+ this.getEmail());
    }
}
