<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
          <style>
            img {
                float: left;
                margin-right: 2em;
                display: block;
            }
          </style>
    </head>
    <body>
     <jsp:include page="../includes/adminNav.jsp"/>
        <div class='container'>
            <h1>Title: ${book.title}</h1>
            <p>Writer: ${book.writer}</p>
            <p>Description:</p>
            <hr>
            <p><img src="${book.image}">${book.description}</p>

        </div>
    </body>
</html>

