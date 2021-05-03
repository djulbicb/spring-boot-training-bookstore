<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   </head>
   <body>
      <jsp:include page="../includes/adminNav.jsp"/>
      <div class='container'>
         <h1>Books <a href="book/create" class="btn btn-primary">Create new book</a></h1>

         <table class="table table-sm">
            <thead>
               <tr>
                  <th scope="col">#</th>
                  <th scope="col">Title</th>
                  <th scope="col">Writer</th>
                  <th scope="col">View</th>
                  <th scope="col">Update</th>
                  <th scope="col">Delete</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${books}" var="book" varStatus="loop">
                  <tr>
                     <th scope="row">${loop.index+1}</th>
                     <td>${book.title}</td>
                     <td>${book.writer}</td>
                     <form method="GET">
                        <td><button formaction="book/view/${book.id}" type="submit" class="btn btn-block btn-info">View</button></td>
                        <td><button formaction="book/update/${book.id}" type="submit" class="btn btn-block btn-info">Update</button></td>
                        <td>
                           <button type="button"  class="btn btn-block btn-outline-danger" data-whatever="${book.id}" data-toggle="modal" data-target="#exampleModal">
                                Delete
                           </button>
                        </td>
                     </form>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>

      <!-- Modal -->
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                  </button>
               </div>
               <div class="modal-body">
                  <p></p>
               </div>
               <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <form method="POST" action="book/delete/${bookId_script}">
                     <button type="submit" class="btn btn-block btn-outline-danger" data-whatever="${book.id}" data-toggle="modal" data-target="#exampleModal">
                          Delete
                     </button>
                  </form>
               </div>
            </div>
         </div>
      </div>

      <script>
         $('#exampleModal').on('show.bs.modal', function (event) {
           var button = $(event.relatedTarget) // Button that triggered the modal
           var recipient = button.data('whatever') // Extract info from data-* attributes
           var modal = $(this)
           modal.find('.modal-title').text('New message to ' + recipient)
           modal.find('.modal-body p').text(recipient)
           modal.find('.modal-footer form').attr('action', '/admin/book/delete/' + recipient);
         })
      </script>

      </div>
   </body>
</html>

