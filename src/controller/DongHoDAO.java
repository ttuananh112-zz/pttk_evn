/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.DongHo;

/**
 *
 * @author tuananh
 */
public class DongHoDAO {
    private Connection connection;

    public DongHoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean updateChiSoHienTai(int maDongHo, long chiSoMoi){
        try {
            // update new clock's value
            PreparedStatement stmt;
            stmt= connection.prepareStatement("UPDATE tblDongHo SET chiSoHienTai=? "
                    + "WHERE maDongHo=?");
            stmt.setLong(1, chiSoMoi);
            stmt.setInt(2,maDongHo);
            stmt.execute();
            
            System.out.println("update tblDongHo chiSoHienTai");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public DongHo getDongHo(int maDongHo){
        DongHo dongHo = null;

        try {
            PreparedStatement stmt;
            ResultSet rs;

            // get current clock's value
            stmt = connection.prepareStatement("SELECT * FROM tblDongHo "
                    + "WHERE maDongHo=?");
            stmt.setInt(1, maDongHo);
            rs = stmt.executeQuery();
            rs.next();
            
            long chiSoHienTai = rs.getLong(2);
            dongHo = new DongHo(maDongHo, chiSoHienTai);

        } catch (Exception e) {
        }
        return dongHo;
    }
    
}
