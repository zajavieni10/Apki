
package com.agh.filmy.model;

public class film {
    private int filmId;
    private String tytul;
    private String rok;
    private String rezyser;
    private String link;
    private kategoria kategoria;
    
    public film(){
        this.filmId=0;
        this.tytul="";
        this.rok="";
        this.rezyser="";
        this.link="";
        this.kategoria=new kategoria();
    }
    public film(String tytul, String rok, String rezyser, String link, String kategoria){
        this.filmId=0;
        this.tytul=tytul;
        this.rok=rok;
        this.rezyser=rezyser;
        this.link=link;
        this.kategoria=new kategoria(Integer.parseInt(kategoria),"");        
    }
    public int getFilmId(){
        return filmId;
    }
    public void setFilmId(int filmId){
        this.filmId=filmId;
    }
    public String getTytul(){
        return tytul;
    }
    public void setTytul(String tytul){
        this.tytul=tytul;
    }
    
    public String getRok(){
        return rok;
    }
    public void setRok(String rok){
        this.rok=rok;
    }
    
    public String getRezyser(){
        return rezyser;
    }
    public void setRezyser(String rezyser){
        this.rezyser=rezyser;
    }
    
    public String getLink(){
        return link;
    }
    public void setLink(String link){
        this.link=link;
    }
    
    public kategoria getKategoria(){
        return kategoria;
    }
    public void setKategoria(kategoria kategoria){
        this.kategoria=kategoria;
    }
    @Override
    public String toString() {
        return tytul+" (" + rok+") "+rezyser+" <a href=\""+link+"\">link do FilmWeb</a> kategoria: "+kategoria.getKategoriaId()+" ("+kategoria.getOpis()+")";
    }
}
