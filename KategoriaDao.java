
package com.agh.filmy.dao;

import com.agh.filmy.model.film;
import com.agh.filmy.model.kategoria;
import com.agh.filmy.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class KategoriaDao {
    private Connection connection;
    public KategoriaDao(){
    connection= DbUtil.getConnection();
    }
    public void addKategoria(kategoria kategoria) {
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO ap_web_kategorie (id_kategoria, opis) VALUES (?, ?)");
            preparedStatement.setInt(1, kategoria.getKategoriaId());
            preparedStatement.setString(2, kategoria.getOpis());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateKategoria(kategoria kategoria) {
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("UPDATE ap_web_kategorie SET opis=? WHERE id_kategoria=?");
            preparedStatement.setString(1, kategoria.getOpis());
            preparedStatement.setInt(2, kategoria.getKategoriaId());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteKategoria(int id){
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM ap_web_kategorie WHERE id_kategoria=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List <kategoria> getAllKategorie() {
        List <kategoria> kategorie= new ArrayList<kategoria>();
        try{
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery("select * FROM ap_web_kategorie");
            while(rs.next()) {
                kategoria kategoria= new kategoria();
                kategoria.setKategoriaId(rs.getInt("id_kategoria"));
                kategoria.setOpis(rs.getString("opis"));
                kategorie.add(kategoria);
            }
        } catch(SQLException e) { 
            e.printStackTrace(); 
        }
        return kategorie;
    }
    public kategoria getKategoriaById(int id) {
        kategoria kategoria=new kategoria();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("select * FROM ap_web_kategorie WHERE id_kategoria=?");
            preparedStatement.setInt(1, id);
            ResultSet rs= preparedStatement.executeQuery();
            if(rs.next()) {
                kategoria.setKategoriaId(rs.getInt("id_kategoria"));
                kategoria.setOpis(rs.getString("opis"));
            }
        } catch(SQLException e) { 
            e.printStackTrace();
        }
        return kategoria;
    }
    
    
}
