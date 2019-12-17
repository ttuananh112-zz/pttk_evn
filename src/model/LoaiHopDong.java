/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tuananh
 */
public class LoaiHopDong {
    private int maLoaiHopDong;
    private String tenHopDong;
    private ArrayList<BangGia> listBangGia;

    public LoaiHopDong(int maLoaiHopDong, String tenHopDong, ArrayList<BangGia> listBangGia) {
        this.maLoaiHopDong = maLoaiHopDong;
        this.tenHopDong = tenHopDong;
        this.listBangGia = listBangGia;
    }

    public int getMaLoaiHopDong() {
        return maLoaiHopDong;
    }

    public void setMaLoaiHopDong(int maLoaiHopDong) {
        this.maLoaiHopDong = maLoaiHopDong;
    }

    public String getTenHopDong() {
        return tenHopDong;
    }

    public void setTenHopDong(String tenHopDong) {
        this.tenHopDong = tenHopDong;
    }

    public ArrayList<BangGia> getListBangGia() {
        return listBangGia;
    }

    public void setListBangGia(ArrayList<BangGia> listBangGia) {
        this.listBangGia = listBangGia;
    }
    
    public String toString(){
        return maLoaiHopDong + " " + tenHopDong;
    }
}
