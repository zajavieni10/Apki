
package com.agh.filmy.dao;

import com.agh.filmy.model.*;
import com.agh.filmy.util.*;
import java.sql.*;
import java.util.*;

public class FilmDao {
    private Connection connection;
    public FilmDao(){
    connection= DbUtil.getConnection();
    }
    public void addFilm(film film) {
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO ap_web_filmy (tytul, rok_produkcji, id_kategoria, rezyser, link) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, film.getTytul());
            preparedStatement.setString(2, film.getRok());
            preparedStatement.setInt(3, film.getKategoria().getKategoriaId());
            preparedStatement.setString(4, film.getRezyser());
            preparedStatement.setString(5, film.getLink());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateFilm(film film) {
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE ap_web_filmy SET tytul=?, rok_produkcji=?, id_kategoria=?, rezyser=?, link=? WHERE id_film=?");
            preparedStatement.setString(1, film.getTytul());
            preparedStatement.setString(2, film.getRok());
            preparedStatement.setInt(3, film.getKategoria().getKategoriaId());
            preparedStatement.setString(4, film.getRezyser());
            preparedStatement.setString(5, film.getLink());
            preparedStatement.setInt(6, film.getFilmId());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteFilm(int id){
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM ap_web_filmy WHERE id_film=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List <film> getAllFilms() {
        List <film> filmy= new ArrayList<film>();
        try{
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery("select* from ap_web_filmy, ap_web_kategorie WHERE ap_web_filmy.id_kategoria=ap_web_kategorie.id_kategoria");
            while(rs.next()) {
                film film= new film();
                film.setFilmId(rs.getInt("id_film"));
                film.setTytul(rs.getString("tytul"));
                film.setRok(rs.getString("rok_produkcji"));
                film.setRezyser(rs.getString("rezyser"));
                film.setLink(rs.getString("link"));
                film.setKategoria(new kategoria(rs.getInt("id_kategoria"),rs.getString("opis")));
                filmy.add(film);
            }
        } catch(SQLException e) { 
            e.printStackTrace(); 
        }
        return filmy;
    }
    public film getFilmById(int id_film) {
        film film=new film();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("select* from ap_web_filmy, ap_web_kategorie WHERE ap_web_filmy.id_kategoria=ap_web_kategorie.id_kategoria AND id_film=?");
            preparedStatement.setInt(1, id_film);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next()) {
                film.setFilmId(rs.getInt("id_film"));
                film.setTytul(rs.getString("tytul"));
                film.setRok(rs.getString("rok_produkcji"));
                film.setRezyser(rs.getString("rezyser"));
                film.setLink(rs.getString("link"));
                film.setKategoria(new kategoria(rs.getInt("id_kategoria"),rs.getString("opis")));
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return film;
    }
    public film getLosowyFilm(int id_kategoria) {
        List <film> filmy= new ArrayList<film>();
        film random=new film();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("select* from ap_web_filmy, ap_web_kategorie WHERE ap_web_filmy.id_kategoria=ap_web_kategorie.id_kategoria AND ap_web_filmy.id_kategoria=?");
            preparedStatement.setInt(1, id_kategoria);
            ResultSet rs= preparedStatement.executeQuery();
            while(rs.next()) {
                film film= new film();
                film.setFilmId(rs.getInt("id_film"));
                film.setTytul(rs.getString("tytul"));
                film.setRok(rs.getString("rok_produkcji"));
                film.setRezyser(rs.getString("rezyser"));
                film.setLink(rs.getString("link"));
                film.setKategoria(new kategoria(rs.getInt("id_kategoria"),rs.getString("opis")));
                filmy.add(film);
            }
            Random randomizer = new Random();
            random = filmy.get(randomizer.nextInt(filmy.size()));
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return random;
    }
    
    
}
