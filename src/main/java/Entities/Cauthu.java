/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Admin
 */
public class Cauthu {
    private String Macauthu,Ten,ViTri,SoAo,ChieuCao,CanNang,NamSinh;
    private byte[] Hinh;

    public Cauthu() {
    }

    public Cauthu(String Macauthu, String Ten, String ViTri, String SoAo, String ChieuCao, String CanNang, String NamSinh, byte[] Hinh) {
        this.Macauthu = Macauthu;
        this.Ten = Ten;
        this.ViTri = ViTri;
        this.SoAo = SoAo;
        this.ChieuCao = ChieuCao;
        this.CanNang = CanNang;
        this.NamSinh = NamSinh;
        this.Hinh = Hinh;
    }

    public String getMacauthu() {
        return Macauthu;
    }

    public void setMacauthu(String Macauthu) {
        this.Macauthu = Macauthu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String ViTri) {
        this.ViTri = ViTri;
    }

    public String getSoAo() {
        return SoAo;
    }

    public void setSoAo(String SoAo) {
        this.SoAo = SoAo;
    }

    public String getChieuCao() {
        return ChieuCao;
    }

    public void setChieuCao(String ChieuCao) {
        this.ChieuCao = ChieuCao;
    }

    public String getCanNang() {
        return CanNang;
    }

    public void setCanNang(String CanNang) {
        this.CanNang = CanNang;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] Hinh) {
        this.Hinh = Hinh;
    }


}
