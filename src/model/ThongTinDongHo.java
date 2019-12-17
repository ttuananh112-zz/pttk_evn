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
public class ThongTinDongHo {
    private int maThongTinDongHo;
    private DongHo dongHo;
    private long chiSoCu;
    private long chiSoMoi;
    private String ngay;

    public ThongTinDongHo(int maThongTinDongHo, DongHo dongHo, long chiSoCu, long chiSoMoi, String ngay) {
        this.maThongTinDongHo = maThongTinDongHo;
        this.dongHo = dongHo;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.ngay = ngay;
    }

    public int getMaThongTinDongHo() {
        return maThongTinDongHo;
    }

    public void setMaThongTinDongHo(int maThongTinDongHo) {
        this.maThongTinDongHo = maThongTinDongHo;
    }
    
    public DongHo getDongHo() {
        return dongHo;
    }

    public void setDongHo(DongHo dongHo) {
        this.dongHo = dongHo;
    }

    public long getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(long chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public long getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(long chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
    
    
}
