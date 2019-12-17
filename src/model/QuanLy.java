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
public class QuanLy extends Nguoi{
    private int maQuanLy;

    public QuanLy(int maQuanLy, String ten, String cmtnd, String diaChi, String sdt, String email) {
        super(ten, cmtnd, diaChi, sdt, email);
        this.maQuanLy = maQuanLy;
    }

    public int getMaQuanLy() {
        return maQuanLy;
    }

    public void setMaQuanLy(int maQuanLy) {
        this.maQuanLy = maQuanLy;
    }
    
    
}
