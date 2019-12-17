/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import model.DongHo;
import model.HoDungDien;
import model.HoaDon;
import model.LoaiHopDong;
import model.NhanVien;
import model.ThongTinDongHo;

/**
 *
 * @author tuananh
 */
public class HoaDonDAO {
    private Connection connection;

    public HoaDonDAO(Connection connection) {
        this.connection = connection;
    }
    
    public HoaDon insertHoaDon(HoDungDien hoDungDien, NhanVien nhanVien, ThongTinDongHo thongTinDongHo){
        HoaDon hoaDon;
        try {
//            Statement stmt = connection.createStatement();
            PreparedStatement stmt;
            ResultSet rs;
            
            int maHoDungDien = hoDungDien.getMaHoDungDien();
            int maNhanVien = nhanVien.getMaNhanVien();
            
            // date creating invoice
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String ngayTaoHoaDon = simpleDateFormat.format(new Date());
            
            int maThongTinDongHo = thongTinDongHo.getMaThongTinDongHo();
            
            // init false for daThanhToan
            boolean daThanhToan = false;
            
            // create object hoaDon
            hoaDon = new HoaDon(-1, nhanVien, hoDungDien, ngayTaoHoaDon, thongTinDongHo);
            
            // insert new record into tblHoaDon
            stmt = connection.prepareStatement("INSERT INTO tblHoaDon(maNhanVien, "
                    + "maHoDungDien, maThongTinDongHo, ngayTaoHoaDon, tongSoDienSuDung, "
                    + "tienChuaVAT, thueVAT, tongTien, daThanhToan) "
                    + "VALUES (?, ?, ?, ?, ?, ? ,? ,? ,?)");
            
            stmt.setInt(1, maNhanVien);
            stmt.setInt(2, maHoDungDien);
            stmt.setInt(3, maThongTinDongHo);
            stmt.setString(4, ngayTaoHoaDon);
            stmt.setLong(5, hoaDon.getTongSoDienSuDung());
            stmt.setLong(6, hoaDon.getTienChuaVAT());
            stmt.setLong(7, hoaDon.getThueVAT());
            stmt.setLong(8, hoaDon.getTongTien());
            stmt.setBoolean(9, daThanhToan);
            stmt.execute();
            
            return hoaDon;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

