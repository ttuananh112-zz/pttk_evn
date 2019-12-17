/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DongHo;
import model.HoDungDien;
import model.KhachHang;
import model.LoaiHopDong;
import model.Nguoi;

/**
 *
 * @author tuananh
 */
public class HoDungDienDAO {
    private Connection connection;

    public HoDungDienDAO(Connection connection) {
        this.connection = connection;
    }
    
    public HoDungDien getHoDungDien(DongHo dongHo){
        int maDongHo = dongHo.getMaDongHo();
        HoDungDien hoDungDien = null;
        try {
            PreparedStatement stmt;
            ResultSet rs;
            
            // get HoDungDien
            stmt = connection.prepareStatement("SELECT * FROM tblHoDungDien"
                    + " WHERE maDongHo=?");
            stmt.setInt(1, maDongHo);
            rs = stmt.executeQuery();
            rs.next();
            int maHoDungDien = rs.getInt(1);
            int maKhachHang = rs.getInt(3);
            int maLoaiHopDong = rs.getInt(4);
            String hdd_diaChi = rs.getString(5);
            String hdd_phuong = rs.getString(6);
            String hdd_quan = rs.getString(7);
            String hdd_thanhPho = rs.getString(8);
            long chiSoKhoiTao = rs.getLong(9);

            System.out.println("GET HoDungDien");
            System.out.println(maHoDungDien + " " + maKhachHang + " " + maLoaiHopDong + " " +
                    hdd_diaChi + " " + hdd_phuong + " " + hdd_quan + " " + hdd_thanhPho + " " + chiSoKhoiTao);

            // get KhachHang
            KhachHang khachHang = new KhachHangDAO(connection).getKhachHang(maKhachHang);
            System.out.println("GET KhachHang");
            System.out.println(khachHang.toString());

            // get LoaiHopDong
            LoaiHopDong loaiHopDong = new LoaiHopDongDAO(connection).getLoaiHopDong(maLoaiHopDong);
            System.out.println("GET LoaiHopDong");
            System.out.println(loaiHopDong.toString());

            hoDungDien = new HoDungDien(maHoDungDien, dongHo, khachHang, loaiHopDong, 
                    hdd_diaChi, hdd_phuong, hdd_quan, hdd_thanhPho, chiSoKhoiTao);

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return hoDungDien;
    }
}
