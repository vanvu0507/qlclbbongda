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
public class Lichthidau {
    private String Matran,Trandau,Ngay,Gio,SVD;
    
    public Lichthidau() {
    }

    public Lichthidau(String Matran, String Trandau, String Ngay, String Gio, String SVD) {
        this.Matran = Matran;
        this.Trandau = Trandau;
        this.Ngay = Ngay;
        this.Gio = Gio;
        this.SVD = SVD;
    }

    public String getMatran() {
        return Matran;
    }

    public void setMatran(String Matran) {
        this.Matran = Matran;
    }

    public String getTrandau() {
        return Trandau;
    }

    public void setTrandau(String Trandau) {
        this.Trandau = Trandau;
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

    public String getSVD() {
        return SVD;
    }

    public void setSVD(String SVD) {
        this.SVD = SVD;
    }
    
}
