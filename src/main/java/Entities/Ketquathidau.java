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
public class Ketquathidau {
    private String MaTran,TranDau,Ngay,Gio,TiSo;

    public Ketquathidau() {
    }

    public Ketquathidau(String MaTran, String TranDau, String Ngay, String Gio, String TiSo) {
        this.MaTran = MaTran;
        this.TranDau = TranDau;
        this.Ngay = Ngay;
        this.Gio = Gio;
        this.TiSo = TiSo;
    }

    public String getMaTran() {
        return MaTran;
    }

    public void setMaTran(String MaTran) {
        this.MaTran = MaTran;
    }

    public String getTranDau() {
        return TranDau;
    }

    public void setTranDau(String TranDau) {
        this.TranDau = TranDau;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public String getGio() {
        return Gio;
    }

    public void setGio(String Gio) {
        this.Gio = Gio;
    }

    public String getTiSo() {
        return TiSo;
    }

    public void setTiSo(String TiSo) {
        this.TiSo = TiSo;
    }
    
}
