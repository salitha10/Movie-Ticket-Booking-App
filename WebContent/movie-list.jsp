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
                        <a href="#" class="navbar-brand"> MOVIE MANIA </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Movies</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Movies</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Movie</a>
                    </div>
                    <br>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Director</th>
                                <th>Release Date</th>
                                <th>Casts</th>
                                <th>Genre</th>
                                <!-- th>Poster</th>-->
                                <th>Duration</th>
                                <th>Trailer Link</th>
                                <th>Category</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="movie" items="${listMovie}">

                                <tr>
                                	<td>
                                        <c:out value="${movie.id}" />
                                    </td>
                                    
                                    <td>
                                        <c:out value="${movie.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${movie.director}" />
                                    </td>
                                    <td>
                                        <c:out value="${movie.releasedate}" />
                                    </td>
                                    <td>
                                        <c:out value="${movie.casts}" />
                                    </td>
                                     <td>
                                        <c:out value="${movie.genre}" />
                                    </td>
                                    
                                    <!-- 
                                     <td>
                                        <c:out value="${movie.poster}" />
                                    </td>
                                     -->
                                     
                                     <td>
                                        <c:out value="${movie.duration}" />
                                    </td>
                                     <td>
                                        <c:out value="${movie.trailerlink}" />
                                    </td>
                                     <td>
                                        <c:out value="${movie.category}" />
                                    </td>
                                    
                                    <td><a href="edit?id=<c:out value='${movie.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${movie.id}'/>"  onclick="if (confirm('Delete selected item?')){return true;}else{event.stopPropagation(); event.preventDefault();};">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

       </html>
        