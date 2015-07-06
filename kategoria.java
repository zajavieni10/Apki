
package com.agh.filmy.model;

public class kategoria {
    private int kategoriaId;
    private String opis;
    
    public kategoria(){
        this.kategoriaId=0;
        this.opis="";
    }
    public kategoria(int kategoriaId, String opis){
        this.kategoriaId=kategoriaId;
        this.opis=opis;
    }
    public int getKategoriaId(){
        return kategoriaId;
    }
    public void setKategoriaId(int kategoriaId){
        this.kategoriaId=kategoriaId;
    }
    
    public String getOpis(){
        return opis;
    }
    public void setOpis(String opis){
        this.opis=opis;
    }
}
