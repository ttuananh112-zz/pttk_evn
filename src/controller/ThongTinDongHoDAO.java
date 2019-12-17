/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.DongHo;
import model.ThongTinDongHo;

/**
 *
 * @author tuananh
 */
public class ThongTinDongHoDAO {
    private Connection connection;
    
    public ThongTinDongHoDAO(Connection connection){
        this.connection = connection;
    }
    
    public boolean insertChiSo(int maDongHo, long chiSoCu, long chiSoMoi, String ngay){
        try {
//            Statement stmt = connection.createStatement();
            PreparedStatement stmt;
            ResultSet rs;

            // insert new value into tblThongTinDongHo
            stmt= connection.prepareStatement("INSERT INTO tblThongTinDongHo(maDongHo, "
                    + "chiSoCu, chiSoMoi, ngay) VALUES (?, ?, ?, ?)");
            stmt.setInt(1,maDongHo);
            stmt.setLong(2, chiSoCu);
            stmt.setLong(3, chiSoMoi);
            stmt.setString(4, ngay);
            stmt.execute();
            
            return true;

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ThongTinDongHo getLastThongTinDongHo(){
        ThongTinDongHo thongTinDongHo = null;
        try {
            PreparedStatement stmt;
            ResultSet rs;

            // insert new value into tblThongTinDongHo
            stmt= connection.prepareStatement("SELECT * FROM tblThongTinDongHo "
                    + "ORDER BY maThongTinDongHo DESC LIMIT 1");
            rs = stmt.executeQuery();
            rs.next();
            
            int maThongTinDongHo = rs.getInt(1);
            int maDongHo = rs.getInt(2);
            DongHo dongHo = new DongHoDAO(connection).getDongHo(maDongHo);
            long chiSoCu = rs.getLong(3);
            long chiSoMoi = rs.getLong(4);
            String ngay = rs.getString(5);
            
            thongTinDongHo = new ThongTinDongHo(maThongTinDongHo, dongHo, chiSoCu, chiSoMoi, ngay);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thongTinDongHo;
    }
}
