CREATE TABLE tblDongHo (
  maDongHo int(10) NOT NULL AUTO_INCREMENT, 
  chiSoMoi int(10) NOT NULL, 
  chiSoCu  int(10) NOT NULL, 
  PRIMARY KEY (maDongHo)) CHARACTER SET UTF8;
CREATE TABLE tblHoaDon (
  maHoaDon         int(10) NOT NULL AUTO_INCREMENT, 
  maNhanVien       int(10) NOT NULL, 
  maHoDungDIen     int(10) NOT NULL, 
  ngayTaoHoaDon    date NOT NULL, 
  chiSoCu          int(10) NOT NULL, 
  chiSoMoi         int(10) NOT NULL, 
  tongSoDienSuDung int(10) NOT NULL, 
  tienChuaVAT      int(10) NOT NULL, 
  thueVAT          int(10) NOT NULL, 
  tongTien         int(10) NOT NULL, 
  daThanhToan      binary(1) NOT NULL, 
  PRIMARY KEY (maHoaDon)) CHARACTER SET UTF8;
CREATE TABLE tblHoDungDien (
  maHoDungDien  int(10) NOT NULL AUTO_INCREMENT, 
  maDongHo      int(10) NOT NULL, 
  maKhachHang   int(10) NOT NULL, 
  maLoaiHopDong int(10) NOT NULL, 
  diaChi        varchar(255) NOT NULL, 
  phuong        varchar(255) NOT NULL, 
  quan          varchar(255) NOT NULL, 
  thanhPho      varchar(255) NOT NULL, 
  chiSoKhoiTao  int(10) NOT NULL, 
  PRIMARY KEY (maHoDungDien)) CHARACTER SET UTF8;
CREATE TABLE tblHopDong (
  maHopDong     int(10) NOT NULL AUTO_INCREMENT, 
  maKhachHang   int(10) NOT NULL, 
  maQuanLy      int(10) NOT NULL, 
  ngayKyHopDong date NOT NULL, 
  PRIMARY KEY (maHopDong)) CHARACTER SET UTF8;
CREATE TABLE tblKhachHang (
  maKhachHang int(10) NOT NULL, 
  ten         varchar(255) NOT NULL, 
  cmtnd       varchar(255) NOT NULL, 
  diaChi      varchar(255) NOT NULL, 
  sdt         varchar(255) NOT NULL, 
  email       varchar(255) NOT NULL, 
  PRIMARY KEY (maKhachHang)) CHARACTER SET UTF8;
CREATE TABLE tblLoaiHopDong (
  maLoaiHopDong  int(10) NOT NULL AUTO_INCREMENT, 
  tenHopDong     varchar(255) NOT NULL, 
  mucGia         int(10) NOT NULL, 
  mucBacThangGia int(10) NOT NULL, 
  PRIMARY KEY (maLoaiHopDong)) CHARACTER SET UTF8;
CREATE TABLE tblNguoi (
  id     int(10) NOT NULL AUTO_INCREMENT, 
  ten    varchar(255) NOT NULL, 
  cmtnd  varchar(255) NOT NULL, 
  diaChi varchar(255) NOT NULL, 
  sdt    varchar(255) NOT NULL, 
  email  varchar(255) NOT NULL, 
  PRIMARY KEY (id)) CHARACTER SET UTF8;
CREATE TABLE tblNhanVien (
  maNhanVien int(10) NOT NULL, 
  ten        varchar(255) NOT NULL, 
  cmtnd      varchar(255) NOT NULL, 
  diaChi     varchar(255) NOT NULL, 
  sdt        varchar(255) NOT NULL, 
  email      varchar(255) NOT NULL, 
  PRIMARY KEY (maNhanVien)) CHARACTER SET UTF8;
CREATE TABLE tblQuanLy (
  maQuanLy int(10) NOT NULL, 
  ten      varchar(255) NOT NULL, 
  cmtnd    varchar(255) NOT NULL, 
  diaChi   varchar(255) NOT NULL, 
  sdt      varchar(255) NOT NULL, 
  email    varchar(255) NOT NULL, 
  PRIMARY KEY (maQuanLy)) CHARACTER SET UTF8;
ALTER TABLE tblHopDong ADD CONSTRAINT FKtblHopDong680132 FOREIGN KEY (maQuanLy) REFERENCES tblQuanLy (maQuanLy);
ALTER TABLE tblHopDong ADD CONSTRAINT FKtblHopDong658440 FOREIGN KEY (maKhachHang) REFERENCES tblKhachHang (maKhachHang);
ALTER TABLE tblHoaDon ADD CONSTRAINT FKtblHoaDon235495 FOREIGN KEY (maHoDungDIen) REFERENCES tblHoDungDien (maHoDungDien);
ALTER TABLE tblHoDungDien ADD CONSTRAINT FKtblHoDungD688241 FOREIGN KEY (maLoaiHopDong) REFERENCES tblLoaiHopDong (maLoaiHopDong);
ALTER TABLE tblHoDungDien ADD CONSTRAINT FKtblHoDungD703772 FOREIGN KEY (maKhachHang) REFERENCES tblKhachHang (maKhachHang);
ALTER TABLE tblHoDungDien ADD CONSTRAINT FKtblHoDungD702213 FOREIGN KEY (maDongHo) REFERENCES tblDongHo (maDongHo);
ALTER TABLE tblQuanLy ADD CONSTRAINT FKtblQuanLy364867 FOREIGN KEY (maQuanLy) REFERENCES tblNguoi (id);
ALTER TABLE tblHoaDon ADD CONSTRAINT FKtblHoaDon108177 FOREIGN KEY (maNhanVien) REFERENCES tblNhanVien (maNhanVien);
ALTER TABLE tblNhanVien ADD CONSTRAINT FKtblNhanVie468004 FOREIGN KEY (maNhanVien) REFERENCES tblNguoi (id);
ALTER TABLE tblKhachHang ADD CONSTRAINT FKtblKhachHa411893 FOREIGN KEY (maKhachHang) REFERENCES tblNguoi (id);

