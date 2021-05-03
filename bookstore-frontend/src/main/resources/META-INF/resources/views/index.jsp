<%@ taglib prefix="ex" uri="http://bojan.jstldomain"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   </head>
    <body>
        <div class="container">
            <h1>Books shop</h1>
            <strong>Hello from index page ${bojan}</strong>
            <ex:Hello message = "This is custom tag" />

           <div class="row g-2">
             <c:forEach items="${books}" var="book" varStatus="loop">
                  <div class="col-3">
                        <div class="card">
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

