/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.NguoiDung;
import Helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class NguoiDungDao {
    public NguoiDung checkLogin(String tenDangNhap, String matKhau)
        throws Exception{
        String sql ="SELECT [TenDangNhap],[MatKhau],[Vaitro]"+"FROM [dbo].[NguoiDUng]"+
                " WHERE [TenDangNhap] = ? AND [MatKhau] = ? ";
        try(
                Connection con = DatabaseHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ){
                 pstmt.setString(1,tenDangNhap);
                 pstmt.setString(2,matKhau);
                 
                 try(ResultSet rs = pstmt.executeQuery();){
                    if(rs.next()){
                        NguoiDung nd = new NguoiDung();
                        nd.setTenDangNhap(tenDangNhap);
                        nd.setVaiTro(rs.getString("Vaitro"));
                        return nd;
                    }
                 }
        }
        return null;
}
}
