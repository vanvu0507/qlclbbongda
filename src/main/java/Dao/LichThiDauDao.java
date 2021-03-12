/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Cauthu;
import Entities.Lichthidau;
import Helper.DatabaseHelper;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author Admin
 */
public class LichThiDauDao {
        public boolean insert(Lichthidau lt)
        throws Exception{
            String sql ="INSERT INTO [dbo].[Lichthidau] ([Matran],[Trandau],[Ngay],[Gio],[SVD])" +"VALUES (?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,lt.getMatran());
                 pstmt.setString(2,lt.getTrandau());
                 pstmt.setString(3,lt.getNgay());
                 pstmt.setString(4,lt.getGio());
                 pstmt.setString(5,lt.getSVD());

                 return pstmt.executeUpdate()>0;
                 }        
}
    public boolean update(Lichthidau lt)
        throws Exception{
            String sql ="UPDATE [dbo].[Lichthidau]" +
" SET [Trandau] = ? ,[Ngay] = ? ,[Gio] = ? ,[SVD] = ? "+" WHERE [Matran] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(5,lt.getMatran());
                 pstmt.setString(1,lt.getTrandau());
                 pstmt.setString(2,lt.getNgay());
                 pstmt.setString(3,lt.getGio());
                 pstmt.setString(4,lt.getSVD());

                 return pstmt.executeUpdate()>0;
                 }        
}
        public boolean deleteByMaTran(String maTran)
        throws Exception{
            String sql ="DELETE FROM [dbo].[Lichthidau]"+" WHERE [Matran] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,maTran);
                 return pstmt.executeUpdate()>0;
                 }        
}
        public Lichthidau findByMaTran(String maTran)
        throws Exception{
            String sql ="SELECT * FROM [dbo].[Lichthidau] WHERE [Matran] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,maTran);
                 try(ResultSet rs = pstmt.executeQuery();){
                     if(rs.next()){
                         Lichthidau lt = createLichthidau(rs);
                         return lt;
                     }
                 }
        return null;
        }            
}

    private Lichthidau createLichthidau(final ResultSet rs) throws SQLException {
        Lichthidau lt = new Lichthidau();
        lt.setMatran(rs.getString("matran"));
        lt.setTrandau(rs.getString("trandau"));
        lt.setNgay(rs.getString("ngay"));
        lt.setGio(rs.getString("gio"));
        lt.setSVD(rs.getString("svd"));
        return lt;
    }
    public List<Lichthidau> findAllLichThiDau() throws Exception {
        String sql = "SELECT * FROM [dbo].[Lichthidau]";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Lichthidau> list = new ArrayList<>();
                while (rs.next()){
                         Lichthidau lt = createLichthidau(rs);
                         list.add(lt);
                }
            return list;
            }
        }
   }
}

