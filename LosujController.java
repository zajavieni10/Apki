
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

@WebServlet(name = "LosujController", urlPatterns = {"/LosujController"})
public class LosujController extends HttpServlet {
    private static final long serialVersionUID= 1L;
    private static String LIST_KATEGORIE = "/listKategorie.jsp";
    private KategoriaDao dao;
    public LosujController() {
        super();
        dao= new KategoriaDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String forward="";
        String action= request.getParameter("action");
        if(action.equalsIgnoreCase("listkategorie")){
            forward= LIST_KATEGORIE;
            request.setAttribute("kategorie", dao.getAllKategorie());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //view.forward(request, response);
    }
}
