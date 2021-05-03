

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
   </head>
   <body>
        <jsp:include page="../includes/adminNav.jsp"/>
        <div class='container'>

         <h3>Welcome, Update The Book Details</h3>
         <form:form method="POST"
            action="/admin/book/update/${book.id}" modelAttribute="book">
            <form:hidden path="id" />

            <div class="form-group row">
               <form:label path="title" class="col-sm-1 col-form-label">Title</form:label>
               <form:input class="form-control col-sm-11" path="title" placeholder="Enter Title"/>
               <form:errors path="title" class="error offset-sm-1"/>
            </div>

            <div class="form-group row">
               <form:label path="title" class="col-sm-1 col-form-label">Writer</form:label>
               <form:input class="form-control col-sm-11" path="writer" placeholder="Enter Writer"/>
               <form:errors path="writer" class="error offset-sm-1"/>
            </div>

            <div class="form-group row">
               <form:label path="description" class="col-sm-1 col-form-label">Description:</form:label>
               <form:textarea class="form-control col-sm-11" path="description" placeholder="Enter Description"></form:textarea>
               <form:errors path="description" class="error offset-sm-1"/>
            </div>

            <div class="form-group row">
               <form:label path="image" class="col-sm-1 col-form-label">Image:</form:label>
               <form:input class="form-control col-sm-11" path="image" placeholder="Enter Image"/>
            </div>

            <hr>
            <div class="row">
               <div class="col-sm-2 offset-sm-1">
                  <input class="btn btn-primary btn-block" type="submit" value="Submit"/>
               </div>
            </div>
         </form:form>
      </div>
   </body>
</html>

