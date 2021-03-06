package com.example.lenovo.e_learning.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 11/12/2018.
 */

public class SemuatugasItem {

    @SerializedName("id")
    private String id;

    @SerializedName("judul")
    private String judul;

    @SerializedName("mulai")
    private String mulai;

    @SerializedName("selesai")
    private String selesai;

    @SerializedName("makul")
    private String makul;

    @SerializedName("namadosen")
    private String dosen;

    @SerializedName("foto")
    private String foto;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getMulai() {
        return mulai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public String getSelesai() {
        return selesai;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public String getMakul() {
        return makul;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getDosen() {
        return dosen;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    @Override
    public String toString(){
        return
                "SemuatugasItem{"+
                        "id = '"+id+'\''+
                        "judul='"+judul+'\''+
                        "mulai='"+mulai+'\''+
                        "selesai='"+selesai+'\''+
                        "makul='" +makul+'\''+
                        "namadosen='"+dosen+'\''+
                        "foto='"+foto+'\''+
                        "}";
    }
}
