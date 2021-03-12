/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Ketquathidau;
import Helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class KetQuaThiDauDao {
            public boolean insert(Ketquathidau kq)
        throws Exception{
            String sql ="INSERT INTO [dbo].[ketquathidau] ([Matran],[Trandau],[Ngay],[Gio],[TiSo])" +"VALUES (?,?,?,?,?)";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,kq.getMaTran());
                 pstmt.setString(2,kq.getTranDau());
                 pstmt.setString(3,kq.getNgay());
                 pstmt.setString(4,kq.getGio());
                 pstmt.setString(5,kq.getTiSo());

                 return pstmt.executeUpdate()>0;
                 }        
}
    public boolean update(Ketquathidau kq)
        throws Exception{
            String sql ="UPDATE [dbo].[ketquathidau]" +
" SET [Trandau] = ?,[Ngay] = ?,[Gio] = ? ,[TiSo] = ?"+" WHERE [Matran] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(5,kq.getMaTran());
                 pstmt.setString(1,kq.getTranDau());
                 pstmt.setString(2,kq.getNgay());
                 pstmt.setString(3,kq.getGio());
                 pstmt.setString(4,kq.getTiSo());

                 return pstmt.executeUpdate()>0;
                 }        
}
        public boolean deleteByMaTran(String maTran)
        throws Exception{
            String sql ="DELETE FROM [dbo].[ketquathidau]"+" WHERE [Matran] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,maTran);
                 return pstmt.executeUpdate()>0;
                 }        
}
        public Ketquathidau findByMaTran(String maTran)
        throws Exception{
            String sql ="SELECT * FROM [dbo].[ketquathidau] WHERE [Matran] = ?";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,maTran);
                 try(ResultSet rs = pstmt.executeQuery();){
                     if(rs.next()){
                         Ketquathidau lt = createKetquathidau(rs);
                         return lt;
                     }
                 }
        return null;
        }            
}

    private Ketquathidau createKetquathidau(final ResultSet rs) throws SQLException {
        Ketquathidau kq = new Ketquathidau();
        kq.setMaTran(rs.getString("matran"));
        kq.setTranDau(rs.getString("trandau"));
        kq.setNgay(rs.getString("ngay"));
        kq.setGio(rs.getString("gio"));
        kq.setTiSo(rs.getString("tiso"));
        return kq;
    }
    public List<Ketquathidau> findAllKetQuaThiDau() throws Exception {
        String sql = "SELECT * FROM [dbo].[ketquathidau]";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
            try(ResultSet rs = pstmt.executeQuery();){
                List<Ketquathidau> list = new ArrayList<>();
                while (rs.next()){
                         Ketquathidau lt = createKetquathidau(rs);
                         list.add(lt);
                }
            return list;
            }
        }
   }
}
