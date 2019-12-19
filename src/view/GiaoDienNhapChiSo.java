/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DongHoDAO;
import controller.HoDungDienDAO;
import controller.HoaDonDAO;
import controller.ThongTinDongHoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.DongHo;
import model.HoDungDien;
import model.HoaDon;
import model.NhanVien;
import model.ThongTinDongHo;
import org.jdatepicker.DateModel;

/**
 *
 * @author Tran Tuan Anh
 */
public class GiaoDienNhapChiSo extends javax.swing.JFrame {
    
    private NhanVien nhanVien;
    
    private DongHoDAO dongHoDAO;
    private ThongTinDongHoDAO thongTinDongHoDAO;
    private HoDungDienDAO hoDungDienDAO;
    private HoaDonDAO hoaDonDAO;

    /**
     * Creates new form GiaoDienNhapChiSo
     */
    public GiaoDienNhapChiSo(Connection connection, NhanVien nhanVien) {
        initComponents();
        tfMaDongHo.requestFocus();
        
        this.nhanVien = nhanVien;
            
        dongHoDAO = new DongHoDAO(connection);
        thongTinDongHoDAO = new ThongTinDongHoDAO(connection);
        hoDungDienDAO = new HoDungDienDAO(connection);
        hoaDonDAO = new HoaDonDAO(connection);
        
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnXacNhanClick();
            }
        });
        
        btnQuayLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnQuayLaiClick();
            }
        });

        jDatePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickDatePicker();
            }
        });
    }
    
    public void btnXacNhanClick(){
        int maDongHo;
        long chiSoMoi;
        DongHo dongHo;
        HoDungDien hoDungDien;
        ThongTinDongHo thongTinDongHo;
        
        // check Date
        if(tfDate.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Chọn ngày nhập chỉ số", 
                "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        if(tfMaDongHo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Mã đồng hồ không được để trống", 
                "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        if(tfChiSoDongHo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Chỉ số đồng hồ không được để trống", 
                "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        //check maDongHo
        try {
            maDongHo = Integer.valueOf(tfMaDongHo.getText());

            if(maDongHo <= 0){
                JOptionPane.showMessageDialog(null, "Mã đồng hồ phải > 0", 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
                return;
            }

        } catch (NumberFormatException num_e) {
            JOptionPane.showMessageDialog(null, "Mã đồng hồ phải là số tự nhiên", 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        //check chiSoMoi
        try {
            chiSoMoi = Long.valueOf(tfChiSoDongHo.getText());

            if(chiSoMoi <= 0){
                JOptionPane.showMessageDialog(null, "Chỉ số mới phải > 0", 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
                return;
            }

        } catch (NumberFormatException num_e) {
            JOptionPane.showMessageDialog(null, "Chỉ số mới phải là số tự nhiên", 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        // check is maDongHo exist and get current chiSoHienTai's value
        dongHo = dongHoDAO.getDongHo(maDongHo);
        long dongHo_chiSoHienTai=(dongHo==null?-1:dongHo.getChiSoHienTai());

        if (dongHo_chiSoHienTai == -1){
            JOptionPane.showMessageDialog(null, "Mã đồng hồ không tồn tại", 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        // new value must be bigger than old value
        if(dongHo_chiSoHienTai >= chiSoMoi){
            JOptionPane.showMessageDialog(null, "Chỉ số mới phải lớn hơn chỉ số cũ."
                    + "\nChỉ số cũ là "+dongHo_chiSoHienTai, 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        // DongHo must be assigned to one HoDungDien
        hoDungDien = hoDungDienDAO.getHoDungDien(dongHo);
            if(hoDungDien == null){
                JOptionPane.showMessageDialog(null, "Đồng hồ chưa được đăng ký", 
                    "Cảnh báo", JOptionPane.PLAIN_MESSAGE);
            return;
            }

        // add new transaction for tblThongTinDongHo
        boolean is_thongTinDongHo_capNhatChiSo_success = 
                thongTinDongHoDAO.insertChiSo(maDongHo, dongHo_chiSoHienTai, chiSoMoi, tfDate.getText());
        // update current clock's value
        boolean is_dongHo_updateChiSoHienTai_success = 
                dongHoDAO.updateChiSoHienTai(maDongHo, chiSoMoi);

        // must be satisfied 2 above conditions
        if(is_dongHo_updateChiSoHienTai_success && 
                is_thongTinDongHo_capNhatChiSo_success){

            thongTinDongHo = thongTinDongHoDAO.getLastThongTinDongHo();

            // insert into tblHoaDon and get object hoaDon
            HoaDon hoaDon = hoaDonDAO.insertHoaDon(hoDungDien, nhanVien, thongTinDongHo);

            GiaoDienHoaDon giaoDienHoaDon = new GiaoDienHoaDon(hoaDon);
            giaoDienHoaDon.setVisible(true);
            giaoDienHoaDon.setTitle("Giao diện hóa đơn");
        }
    }
    
    public void btnQuayLaiClick(){
        dispose();
    }
    
    public void pickDatePicker(){
        DateModel model = jDatePicker.getModel();
                
        int day,month,year;
        day = model.getDay();
        month = model.getMonth();
        year = model.getYear();
        System.out.println(jDatePicker.getFormattedTextField().getText());

        tfDate.setText(day+"/"+month+"/"+year);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfMaDongHo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfChiSoDongHo = new javax.swing.JTextField();
        btnXacNhan = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();
        jDatePicker = new org.jdatepicker.JDatePicker();
        tfDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Ngày:");

        jLabel3.setText("Mã đồng hồ:");

        tfMaDongHo.requestFocus();
        tfMaDongHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMaDongHoActionPerformed(evt);
            }
        });

        jLabel4.setText("Chỉ số đồng hồ:");

        btnXacNhan.setText("Xác nhận");

        btnQuayLai.setText("Quay lại");

        tfDate.setEditable(false);
        tfDate.setBackground(new java.awt.Color(215, 215, 215));
        tfMaDongHo.requestFocus();
        tfDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXacNhan)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfMaDongHo)
                        .addComponent(tfChiSoDongHo)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDatePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfMaDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfChiSoDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnQuayLai))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfMaDongHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMaDongHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMaDongHoActionPerformed

    private void tfDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDateActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnXacNhan;
    private org.jdatepicker.JDatePicker jDatePicker;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfChiSoDongHo;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfMaDongHo;
    // End of variables declaration//GEN-END:variables
}
