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
public class DongHo {
    private int maDongHo;
    private long chiSoHienTai;

    public DongHo(int maDongHo, long chiSoHienTai) {
        this.maDongHo = maDongHo;
        this.chiSoHienTai = chiSoHienTai;
    }

    public int getMaDongHo() {
        return maDongHo;
    }

    public void setMaDongHo(int maDongHo) {
        this.maDongHo = maDongHo;
    }

    public long getChiSoHienTai() {
        return chiSoHienTai;
    }

    public void setChiSoHienTai(long chiSoHienTai) {
        this.chiSoHienTai = chiSoHienTai;
    }
    
    
}
