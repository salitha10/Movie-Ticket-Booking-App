package com.movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movie.models.Movie;

public class MovieDao {

	//JDBC data
	private String jdbcURL = "jdbc:mysql://localhost:3306/movieticketapp?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    
    //Queries
     private static final String INSERT_MOVIE_SQL = "INSERT INTO movies" + "  (name,  director, releasedate, casts, genre, poster,"
     		+ "duration, trailerlink, category) VALUES " +
            " (?, ?, ?,?, ?, ?,?, ?, ?);";

     private static final String SELECT_MOVIE_BY_ID = "select * from movies where id =?";
     private static final String SELECT_ALL_MOVIES = "select * from movies";
     private static final String DELETE_MOVIE_SQL = "delete from movies where id = ?;";
     private static final String UPDATE_MOVIE_SQL = "update movies set name = ?,director= ?, releasedate =?, casts = ?, genre= ?, poster =?, duration =?, trailerlink = ?, category= ? where id = ?;";

     //Constructor
     public MovieDao(){}
     
     
     //Establish connection
      Connection getConnection() {
         Connection connection = null;
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
         } catch (SQLException e) { 
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
         return connection;
     }
     
     
     //Add Movie
     public void insertMovie(Movie movie) throws SQLException {
    	 
         System.out.println(INSERT_MOVIE_SQL);
         
         // try-with-resource statement will auto close the connection.
         try (Connection connection = getConnection(); 
        		 
        	 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_SQL)) {
             preparedStatement.setString(1, movie.getName());
             preparedStatement.setString(2, movie.getDirector());
             preparedStatement.setString(3, movie.getReleasedate());
             preparedStatement.setString(4, movie.getCasts());
             preparedStatement.setString(5, movie.getGenre());
             preparedStatement.setString(6, movie.getPoster());
             preparedStatement.setString(7, movie.getDuration());
             preparedStatement.setString(8, movie.getTrailerlink());
             preparedStatement.setInt(9, movie.getCategory());
             
             System.out.println(preparedStatement);
             preparedStatement.executeUpdate();
             
         } catch (SQLException e) {
             printSQLException(e);
         }
     }
     
     //Get specific movie
     public Movie selectMovie(int id) {
         Movie movie = null;
         
         // Establishing a Connection
         try (Connection connection = getConnection();
        		 
             // Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID);) {
             preparedStatement.setInt(1, id);
             System.out.println(preparedStatement);
             
             // Execute the query or update query
             ResultSet rs = preparedStatement.executeQuery();

             // Process the ResultSet object.
             while (rs.next()) {
            	 
                 String name = rs.getString("name");
                 String director = rs.getString("director");
             	 String releasedate = rs.getString("releasedate");
            	 String casts =  rs.getString("casts");
            	 String genre = rs.getString("genre");
            	 String poster = rs.getString("poster");
            	 String duration = rs.getString("duration");
            	 String trailerlink = rs.getString("trailerlink");
            	 int category = rs.getInt("category");
                 
                 movie = new Movie(id, name,  director,  releasedate,  casts,  genre,  poster, duration,  trailerlink,  category);
             }
             
         } catch (SQLException e) {
             printSQLException(e);
         }
         return movie;
     }

     
     //Get all movies
     public List < Movie > selectAllMovies() {

    	 //List to store data
         List < Movie > movies = new ArrayList < > ();
         
         // Establishing a Connection
         try (Connection connection = getConnection();

             // Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);) {
             System.out.println(preparedStatement);
             
             // Step 3: Execute the query or update query
             ResultSet rs = preparedStatement.executeQuery();

             // Process the ResultSet object.
             while (rs.next()) {
            	 
            	 int id = rs.getInt("id");
            	 String name = rs.getString("name");
                 String director = rs.getString("director");
             	 String releasedate = rs.getString("releasedate");
            	 String casts =  rs.getString("casts");
            	 String genre = rs.getString("genre");
            	 String poster = rs.getString("poster");
            	 String duration = rs.getString("duration");
            	 String trailerlink = rs.getString("trailerlink");
            	 int category = rs.getInt("category");
                 
            	 movies.add( new Movie(id, name,  director,  releasedate,  casts,  genre,  poster, duration,  trailerlink,  category));
             }
             
         } catch (SQLException e) {
             printSQLException(e);
         }
         return movies;
     }

     //Delete record
     public boolean deleteMovie(int id) throws SQLException {
         boolean rowDeleted;
         try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE_SQL);) {
             statement.setInt(1, id);
             rowDeleted = statement.executeUpdate() > 0;
         }
         return rowDeleted;
     }

     
     //Update Movie
     public boolean updateMovie(Movie movie) throws SQLException {
         boolean rowUpdated;
         try (Connection connection = getConnection(); 
        		 
        	  PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE_SQL);) {
        	 
        	  preparedStatement.setString(1, movie.getName());
              preparedStatement.setString(2, movie.getDirector());
              preparedStatement.setString(3, movie.getReleasedate());
              preparedStatement.setString(4, movie.getCasts());
              preparedStatement.setString(5, movie.getGenre());
              preparedStatement.setString(6, movie.getPoster());
              preparedStatement.setString(7, movie.getDuration());
              preparedStatement.setString(8, movie.getTrailerlink());
              preparedStatement.setInt(9, movie.getCategory());
              preparedStatement.setInt(10, movie.getId());
              System.out.println("ID: " + movie.getId());

             rowUpdated = preparedStatement.executeUpdate() > 0;
         }
         return rowUpdated;
     }

     //Print exception messages
     private void printSQLException(SQLException ex) {
         for (Throwable e: ex) {
             if (e instanceof SQLException) {
                 e.printStackTrace(System.err);
                 System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                 System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                 System.err.println("Message: " + e.getMessage());
                 Throwable t = ex.getCause();
                 while (t != null) {
                     System.out.println("Cause: " + t);
                     t = t.getCause();
                 }
             }
         }
     }
}
