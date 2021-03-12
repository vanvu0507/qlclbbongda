/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cauthu;
import Entities.NguoiDung;
import Helper.DatabaseHelper;
import java.util.List;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Admin
 */
public class CauThuDao {
        public boolean insert(Cauthu ct)
        throws Exception{
            String sql ="INSERT INTO [dbo].[Cauthu]([Macauthu],[Ten],[Vitri],[Soao],[Chieucao],[Cannang],[Namsinh],[Hinh])"+
                    " values(?,?,?,?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,ct.getMacauthu());
                 pstmt.setString(2,ct.getTen());
                 pstmt.setString(3,ct.getViTri());
                 pstmt.setString(4,ct.getSoAo());
                 pstmt.setString(5,ct.getChieuCao());
                 pstmt.setString(6,ct.getCanNang());
                 pstmt.setString(7,ct.getNamSinh());

                 if(ct.getHinh() != null){
                     Blob hinh = new SerialBlob(ct.getHinh());
                     pstmt.setBlob(8, hinh);
                 }else{
                     Blob hinh = null;
                     pstmt.setBlob(8, hinh);
                 }
                 return pstmt.executeUpdate()>0;
                 }        
}
    public boolean update(Cauthu ct)
        throws Exception{
            String sql ="UPDATE [dbo].[Cauthu] SET [Ten] = ?,[Vitri] = ?,[Soao] = ?,[Chieucao] = ?,[Cannang] = ?,[Namsinh] = ?,[Hinh] = ?"+
                    " WHERE [Macauthu] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(8,ct.getMacauthu());
                 pstmt.setString(1,ct.getTen());
                 pstmt.setString(2,ct.getViTri());
                 pstmt.setString(3,ct.getSoAo());
                 pstmt.setString(4,ct.getChieuCao());
                 pstmt.setString(5,ct.getCanNang());
                 pstmt.setString(6,ct.getNamSinh());


                 if(ct.getHinh() != null){
                     Blob hinh = new SerialBlob(ct.getHinh());
                     pstmt.setBlob(7, hinh);
                 }else{
                     Blob hinh = null;
                     pstmt.setBlob(7, hinh);
                 }
                 return pstmt.executeUpdate()>0;
                 }        
}
        public boolean delete(String maCauThu)
        throws Exception{
            String sql ="DELETE FROM [dbo].[Cauthu]"+" WHERE [Macauthu] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,maCauThu);
                 return pstmt.executeUpdate()>0;
                 }        
}
        public Cauthu findById(String maCauThu)
        throws Exception{
            String sql ="SELECT * FROM [dbo].[Cauthu] WHERE [Macauthu] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,maCauThu);
                 try(ResultSet rs = pstmt.executeQuery();){
                     if(rs.next()){
                         Cauthu ct = createCauthu(rs);
                         return ct;
                     }
                 }
        return null;
        }            
}

    private Cauthu createCauthu(final ResultSet rs) throws SQLException {
        Cauthu ct = new Cauthu();
        ct.setMacauthu(rs.getString("macauthu"));
        ct.setTen(rs.getString("ten"));
        ct.setViTri(rs.getString("vitri"));
        ct.setSoAo(rs.getString("soao"));
        ct.setChieuCao(rs.getString("chieucao"));
        ct.setCanNang(rs.getString("cannang"));
        ct.setNamSinh(rs.getString("namsinh"));
        Blob blob = rs.getBlob("hinh");
        if(blob != null)
            ct.setHinh(blob.getBytes(1, (int) blob.length()));
        return ct;
    }
    public List<Cauthu> findAll() throws Exception {
        String sql = "SELECT * FROM [dbo].[Cauthu]";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Cauthu> list = new ArrayList<>();
                while (rs.next()){
                         Cauthu ct = createCauthu(rs);
                         list.add(ct);
                }
            return list;
            }
        }
   }
}
    


