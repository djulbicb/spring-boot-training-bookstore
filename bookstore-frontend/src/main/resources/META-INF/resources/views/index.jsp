

<%@ taglib prefix="ex" uri="http://bojan.jstldomain"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <script>
          .carousel-inner>.item {
              -webkit-transition: 0s !important;
              -o-transition: 0s !important;
              transition: 0s !important;
          }
      </script>
   </head>
    <body>
        <div class="container">
            <h1>Books shop</h1>
            <strong>Hello from index page ${bojan}</strong>
            <ex:Hello message = "This is custom tag" />

            <div id="carouselExampleIndicators" class="carousel slide mb-3" data-ride="carousel">
              <ol class="carousel-indicators">
                <c:forEach var="item" items="${caruselConfig.items}" varStatus="loop">
                    <li data-target="#carouselExampleIndicators" data-slide-to="${loop.index}" class=""></li>
                </c:forEach>
              </ol>
              <div class="carousel-inner">
                <c:forEach var="item" items="${caruselConfig.items}" varStatus="loop">
                  <div class="carousel-item ${item.active ? 'active' : ''}">
                    <img class="d-block w-100" width="800" height="400" src='${item.url}'>
                  </div>
                </c:forEach>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>

           <div class="row g-2">
             <c:forEach items="${books}" var="book" varStatus="loop">
                  <div class="col-3">
                        <div class="card mb-2">
                          <img src="${book.image}" class="card-img-top" alt="...">
                          <div class="card-body">
                            <h5 class="card-title">${book.title}</h5>
                            <p class="card-text">${book.writer}</p>
                            <a href="#" class="btn btn-primary">Read a book...</a>
                          </div>
                        </div>
                    </div>
            </c:forEach>
          </div>
       </div>

    </body>
</html>

