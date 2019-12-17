/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.KhachHang;

/**
 *
 * @author tuananh
 */
public class KhachHangDAO {
    private Connection connection;

    public KhachHangDAO(Connection connection) {
        this.connection = connection;
    }
    public KhachHang getKhachHang(int maKhachHang){
        KhachHang khachHang = null;
        try {
            PreparedStatement stmt;
            ResultSet rs;
            stmt = connection.prepareStatement("SELECT * FROM tblKhachHang"
                    + " WHERE maKhachHang=?");
            stmt.setInt(1, maKhachHang);
            rs = stmt.executeQuery();
            rs.next();
            String ng_ten = rs.getString(2);
            String ng_cmtnd = rs.getString(3);
            String ng_diaChi = rs.getString(4);
            String ng_sdt = rs.getString(5);
            String ng_email = rs.getString(6);

            khachHang = new KhachHang(maKhachHang, ng_ten, ng_cmtnd, ng_diaChi, ng_sdt, ng_email);
        } catch (Exception e) {
        }
        return khachHang;
    }
}
