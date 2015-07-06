package com.agh.filmy.controller;

import com.agh.filmy.dao.FilmDao;
import com.agh.filmy.dao.KategoriaDao;
import com.agh.filmy.model.film;
import com.agh.filmy.model.kategoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FilmController", urlPatterns = {"/FilmController"})
public class FilmController extends HttpServlet {
    private static final long serialVersionUID= 1L;
    private static String INSERT_OR_EDIT = "/film.jsp";
    private static String LIST_FILM = "/listFilm.jsp";
    private static String WYLOSOWANY_FILM = "/wylosowanyFilm.jsp";
    private FilmDao dao;
    public FilmController() {
        super();
        dao= new FilmDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forward="";
        String action= request.getParameter("action");
        if(action.equalsIgnoreCase("delete")){
            int filmId= Integer.parseInt(request.getParameter("filmId"));
            dao.deleteFilm(filmId);
            forward= LIST_FILM;
            request.setAttribute("filmy", dao.getAllFilms());
        } else if(action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            film film = dao.getFilmById(filmId);
            request.setAttribute("film", film);
        }else if(action.equalsIgnoreCase("listFilm")) {
            forward = LIST_FILM;
            request.setAttribute("filmy", dao.getAllFilms());
        }else if(action.equalsIgnoreCase("losuj")){
            forward = WYLOSOWANY_FILM;
            request.setAttribute("film", dao.getLosowyFilm(Integer.parseInt(request.getParameter("kategoria"))));
            request.setAttribute("kategoria", request.getParameter("kategoria"));
        }else {
            forward = INSERT_OR_EDIT;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        film film = new film();
        film.setTytul(request.getParameter("tytul"));
        film.setRezyser(request.getParameter("rezyser"));
        film.setRok(request.getParameter("rok"));
        film.setLink(request.getParameter("link"));
        KategoriaDao KDao= new KategoriaDao();
        kategoria kategoria=KDao.getKategoriaById(Integer.parseInt(request.getParameter("kategoria_id")));
        film.setKategoria(kategoria);
        
        String filmid = request.getParameter("filmId");
        if (filmid == null || filmid.isEmpty()) {
            dao.addFilm(film);
        } else {
            film.setFilmId(Integer.parseInt(filmid));
            dao.updateFilm(film);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_FILM);
        request.setAttribute("filmy", dao.getAllFilms());
        view.forward(request, response);
    }
    
}
