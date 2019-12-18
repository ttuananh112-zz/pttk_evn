
import controller.BangGiaDAO;
import controller.DatabaseConnection;
import controller.DongHoDAO;
import controller.HoDungDienDAO;
import controller.HoaDonDAO;
import controller.KhachHangDAO;
import controller.LoaiHopDongDAO;
import controller.ThongTinDongHoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.TestCase;
import model.BangGia;
import model.DongHo;
import model.HoDungDien;
import model.HoaDon;
import model.KhachHang;
import model.LoaiHopDong;
import model.NhanVien;
import model.ThongTinDongHo;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuananh
 */
public class test extends TestCase{
    private DatabaseConnection dbConnection;
    private Connection connection;
    
    private DongHoDAO dongHoDAO;
    private KhachHangDAO khachHangDAO;
    private BangGiaDAO bangGiaDAO;
    private LoaiHopDongDAO loaiHopDongDAO;
    private ThongTinDongHoDAO thongTinDongHoDAO;
    private HoDungDienDAO hoDungDienDAO;
    private HoaDonDAO hoaDonDAO;
    
    public test() throws SQLException{
        dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
        connection.setAutoCommit(false);
        
        dongHoDAO = new DongHoDAO(connection);
        khachHangDAO = new KhachHangDAO(connection);
        bangGiaDAO = new BangGiaDAO(connection);
        loaiHopDongDAO = new LoaiHopDongDAO(connection);
        thongTinDongHoDAO = new ThongTinDongHoDAO(connection);
        hoDungDienDAO = new HoDungDienDAO(connection);
        hoaDonDAO = new HoaDonDAO(connection);
    }
    
    public void testNotExistDongHo(){
        int maDongHo = 100;
        
        DongHo dh = dongHoDAO.getDongHo(maDongHo);
        assertEquals(dh, null);
    }
    
    public void testExistDongHo(){
        int maDongHo = 1;
        
        DongHo dh = dongHoDAO.getDongHo(maDongHo);
        assertEquals(dh.getMaDongHo(), maDongHo);
    }
    
    public void testInsertThongTinDongHoSuccessful(){
        int maDongHo = 5;
        long chiSoCu = 0;
        long chiSoMoi = 10;
        String ngay = "18/12/2019";
        
        // get DongHo
        DongHo dh = dongHoDAO.getDongHo(maDongHo);
        ThongTinDongHo ttdh1 = new ThongTinDongHo(-1, dh, chiSoCu, chiSoMoi, ngay);
        
        // insert new record into tblThongTinDongHo
        boolean is_insertSuccess = thongTinDongHoDAO.insertChiSo(maDongHo, 
                chiSoCu, chiSoMoi, ngay);
        assertEquals(is_insertSuccess, true);
        
        // get the last record in tblThongTinDongHo in order to compare
        ThongTinDongHo ttdh2 = thongTinDongHoDAO.getLastThongTinDongHo();
        
        assertEquals(ttdh1.compareTo(ttdh2), 0);
    }
    
    public void testInsertThongTinDongHoFailed(){
        int maDongHo = 100;
        long chiSoCu = 0;
        long chiSoMoi = 10;
        String ngay = "18/12/2019";
        
        // get DongHo
        DongHo dh = dongHoDAO.getDongHo(maDongHo);
        ThongTinDongHo ttdh1 = new ThongTinDongHo(-1, dh, chiSoCu, chiSoMoi, ngay);
        
        // insert new record into tblThongTinDongHo
        boolean is_insertSuccess = thongTinDongHoDAO.insertChiSo(maDongHo, 
                chiSoCu, chiSoMoi, ngay);
        assertEquals(is_insertSuccess, false);
        
    }
    
    public void testExistKhachHang(){
        int maKhachHang = 5;
        KhachHang kh = khachHangDAO.getKhachHang(maKhachHang);
        assertEquals(kh.getMaKhachHang(), maKhachHang);
    }
    
    public void testNotExistKhachHang(){
        int maKhachHang = 100;
        KhachHang kh = khachHangDAO.getKhachHang(maKhachHang);
        assertEquals(kh, null);
    }
    
    public void testExistBangGia(){
        int maLoaiHopDong = 1;
        ArrayList<BangGia> listBangGia = bangGiaDAO.getListBangGia(maLoaiHopDong);
        assertEquals(listBangGia.isEmpty(), false);
    }
    
    public void testNotExistBangGia(){
        int maLoaiHopDong = 100;
        ArrayList<BangGia> listBangGia = bangGiaDAO.getListBangGia(maLoaiHopDong);
        assertEquals(listBangGia.isEmpty(), true);
    }
    
    public void testExistLoaiHopDong(){
        int maLoaiHopDong = 1;
        LoaiHopDong loaiHopDong = loaiHopDongDAO.getLoaiHopDong(maLoaiHopDong);
        assertEquals(loaiHopDong.getMaLoaiHopDong(), maLoaiHopDong);
    }
    
    public void testNotExistLoaiHopDong(){
        int maLoaiHopDong = 100;
        LoaiHopDong loaiHopDong = loaiHopDongDAO.getLoaiHopDong(maLoaiHopDong);
        assertEquals(loaiHopDong, null);
    }
    
    public void testExistHoDungDien(){
        int maDongHo = 1;
        DongHo dh = new DongHo(maDongHo, 10);
        
        HoDungDien hdd = hoDungDienDAO.getHoDungDien(dh);
        assertEquals(hdd.getDongHo().getMaDongHo(), maDongHo);
    }
    
    public void testNotExistHoDungDien(){
        int maDongHo = 100;
        DongHo dh = new DongHo(maDongHo, 10);
        
        HoDungDien hdd = hoDungDienDAO.getHoDungDien(dh);
        assertEquals(hdd, null);
    }
    
    public void testInsertHoaDon(){
        DongHo dongHo = dongHoDAO.getDongHo(1);
        HoDungDien hoDungDien = hoDungDienDAO.getHoDungDien(dongHo);
        KhachHang khachHang = hoDungDien.getKhachHang();
        LoaiHopDong loaiHopDong = hoDungDien.getLoaiHopDong();
        
        int maHoDungDien = hoDungDien.getMaHoDungDien();
        String diaChi = hoDungDien.getDiaChi();
        String phuong = hoDungDien.getPhuong();
        String quan = hoDungDien.getQuan();
        String thanhPho = hoDungDien.getThanhPho();
                
        hoDungDien = new HoDungDien(maHoDungDien, dongHo, khachHang, loaiHopDong, diaChi, phuong, quan, thanhPho, 0);
        NhanVien nhanVien = new NhanVien(2, "Nguyen Van A", "1231231231", "Ha Noi", "3213213213", "vana@gmail.com");
        ThongTinDongHo thongTinDongHo = thongTinDongHoDAO.getLastThongTinDongHo();
        
        HoaDon hoaDon = hoaDonDAO.insertHoaDon(hoDungDien, nhanVien, thongTinDongHo);
        
        assertNotNull(hoaDon);
    }
}
