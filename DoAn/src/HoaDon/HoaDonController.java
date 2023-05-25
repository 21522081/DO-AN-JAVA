/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HoaDon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class HoaDonController {

    String maKH, ngayDen, ngayDi, loaiPhong;
    String tenKH, totolBill, tenDV, giaDV, giaPhong, thue, ngaylap;
    public Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/qlks?useSSL=false";
    String username = "root";
    String password = "123456";

    return DriverManager.getConnection(url, username, password);
    }
    
    public void xuatThongTin(String soPhong){
        String sql = "SELECT * FROM PHONG JOIN CT_PDKY ON PHONG.MAPHONG=CT_PDKY.MAP JOIN KHACH_HANG ON KHACH_HANG.MAKH=CT_PDKY.MAKH join dvsudung on dvsudung.MaP = phong.maPhong JOIN DICHVU ON DICHVU.MADV = DVSUDUNG.MADV JOIN HOA_DON ON HOA_DON.MAKH = KHACH_HANG.MAKH JOIN CHITIET_HD ON CHITIET_HD.MAHD = HOA_DON.MAHD WHERE Maphong = ?";
        try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, soPhong);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            this.maKH = rs.getString("MaKH");
            this.ngayDen = rs.getString("Ngayden");
            this.ngayDi = rs.getString("Ngaydi");
            this.loaiPhong = rs.getString("Tenphong");
            this.tenKH = rs.getString("tenKH");
            this.tenDV = rs.getString("TenDV");
            this.giaDV = rs.getString("GiaDV");
             this.giaPhong =rs.getString("TienPhong");
            this.thue =rs.getString("thue");
            this.ngaylap= rs.getString("ngaylap");
            float total = Float.parseFloat(this.giaDV)+ Float.parseFloat(this.giaPhong)+Float.parseFloat(this.giaPhong)* Float.parseFloat(this.thue);
            this.totolBill =String.valueOf(total);

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        String sql1 =" SELECT * FROM CT_PDKY JOIN KHACH_HANG ON CT_PDKY.MAKH = KHACH_HANG.MAKH JOIN HOA_DON ON HOA_DON.MAKH = KHACH_HANG.MAKH JOIN CHITIET_HD ON CHITIET_HD.MAHD = HOA_DON.MAHD WHERE CT_PDKY.MAP =?";
        try (Connection conn = getConnection();
         PreparedStatement stmt1 = conn.prepareStatement(sql)) {
        stmt1.setString(1, soPhong);
        ResultSet rs1 = stmt1.executeQuery();
        if (rs1.next()){

        //    this.giaDV = rs1.getString("CHITIET_HD.TienDV");
           

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
    public void xuatBill(){
        
    }
    public String getMaKH() {
        return maKH;
    }

    public String getNgayDen() {
        return ngayDen;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getTotolBill() {
        return totolBill;
    }

    public String getTenDV() {
        return tenDV;
    }

    public String getGiaDV() {
        return giaDV;
    }

    public String getGiaPhong() {
        return giaPhong;
    }

    public String getThue() {
        return thue;
    }

    public String getNgaylap() {
        return ngaylap;
    }
    
    
    
    
}
