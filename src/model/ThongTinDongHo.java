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
public class ThongTinDongHo implements Comparable{
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
    
    @Override
    public int compareTo(Object o) {
        ThongTinDongHo ttdh = (ThongTinDongHo)(o);

        if (this.dongHo.getMaDongHo() == ttdh.getDongHo().getMaDongHo() &&
                this.getChiSoCu() == ttdh.getChiSoCu() &&
                this.getChiSoMoi() == ttdh.getChiSoMoi() &&
                this.getNgay().equals(ttdh.getNgay())){
            return 0;
        }
        return -1;
    }
    
    @Override
    public String toString(){
        return dongHo.getMaDongHo() + " " + chiSoCu + " " + chiSoMoi + " " + ngay;
    }
}
