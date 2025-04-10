package com.example.recyclerview;

public class ModelMakanan {
    private String NamaMakanan;
    private String HargaMakanan;
    private int GambarMakanan;

    public ModelMakanan(String namaMakanan, String hargaMakanan, int gambarMakanan) {
        this.NamaMakanan = namaMakanan;
        this.HargaMakanan = hargaMakanan;
        this.GambarMakanan = gambarMakanan;
    }

    public String getNamaMakanan() {
        return NamaMakanan;
    }

    public String getHargaMakanan() {
        return HargaMakanan;
    }
    public int getGambarMakanan() {
        return GambarMakanan;
    }

}
