package com.movie.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.dao.MovieDao;
import com.movie.models.Movie;


public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private MovieDao movieDAO;

    public void init() {
        movieDAO = new MovieDao();
    }


    //Post method
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    
    //Get method
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                	insertMovie(request, response);
                    break;
                case "/delete":
                    deleteMovie(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMovie(request, response);
                    break;
                default:
                    listMovie(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //Display all movies
    private void listMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Movie > listMovie = movieDAO.selectAllMovies();
        request.setAttribute("listMovie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie-list.jsp");
        dispatcher.forward(request, response);
    }

    //Display new movie form
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie-form.jsp");
        dispatcher.forward(request, response);
    }

    //Display edit form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie existingMovie = movieDAO.selectMovie(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("movie-form.jsp");
        request.setAttribute("movie", existingMovie);
        dispatcher.forward(request, response);

    }
    
    //Insert movie
    private void insertMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
	    String name = request.getParameter("name");
	    String director = request.getParameter("director");
	    String releasedate = request.getParameter("releasedate");
	   	String casts =  request.getParameter("casts");
	   	String genre = request.getParameter("genre");
	   	String poster = request.getParameter("poster");
	   	String duration = request.getParameter("duration");
	   	String trailerlink = request.getParameter("trailerlink");
	   	int category = Integer.parseInt(request.getParameter("category"));
        
        Movie movie = new Movie( name,  director,  releasedate,  casts,  genre,  poster, duration,  trailerlink,  category);
        
        movieDAO.insertMovie(movie);
        response.sendRedirect("list");
    }

    //Update record
    private void updateMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	String name = request.getParameter("name");
	    String director = request.getParameter("director");
	    String releasedate = request.getParameter("releasedate");
	   	String casts =  request.getParameter("casts");
	   	String genre = request.getParameter("genre");
	   	String poster = request.getParameter("poster");
	   	String duration = request.getParameter("duration");
	   	String trailerlink = request.getParameter("trailerlink");
	   	int category = Integer.parseInt(request.getParameter("category"));
        
        Movie movie = new Movie(id, name,  director,  releasedate,  casts,  genre,  poster, duration,  trailerlink,  category);
        
        movieDAO.updateMovie(movie);
        response.sendRedirect("list");
    }

    //Delete movie
    private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        movieDAO.deleteMovie(id);
        response.sendRedirect("list");

    }

}
