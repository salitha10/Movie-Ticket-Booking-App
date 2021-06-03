<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Movie Mania</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand">MOVIE MANIA </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Movie</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${movie != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${movie == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${movie != null}">
                                    Edit Movie
                                </c:if>
                                <c:if test="${movie == null}">
                                    Add New Movie
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${movie != null}">
                            <input type="hidden" name="id" value="<c:out value='${movie.id}' />"  class="form-control" name="id" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Name</label> <input type="text" value="<c:out value='${movie.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Director</label> <input type="text" value="<c:out value='${movie.director}' />" class="form-control" name="director" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Release Date</label> <input type="date" value="<c:out value='${movie.releasedate}' />" class="form-control" name="releasedate" required="required">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Casts</label> <input type="text" value="<c:out value='${movie.casts}' />" class="form-control" name="casts" required="required">
                        </fieldset>
                    
                         <fieldset class="form-group">
                            <label>Genre</label> <input type="text" value="<c:out value='${movie.genre}' />" class="form-control" name="genre" required="required">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Duration</label> <input type="text" value="<c:out value='${movie.duration}' />" class="form-control" name="duration" required="required">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Trailer Link</label> <input type="text" value="<c:out value='${movie.trailerlink}' />" class="form-control" name="trailerlink" required="required">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Category</label> <input type="number" min="0" value="<c:out value='${movie.category}' />" class="form-control" name="category" required="required">
                        </fieldset>


                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>