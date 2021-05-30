<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<footer class="bg-light text-center text-lg-start">

  <!-- Grid container -->
  <div class="container p-4">
    <!--Grid row-->
    <div class="row">

        <c:forEach items="${footer.columns}" var="column" varStatus="loop">
          <!--Grid column-->
          <div class="col mb-4 mb-md-0">
            <h5 class="text-uppercase">${column.title}</h5>

            <ul class="list-unstyled mb-0">
                 <c:forEach items="${column.links}" var="link" varStatus="loop">
                    <li>
                     <a href="${link.url}" class="text-dark">${link.label}</a>
                   </li>
                 </c:forEach>
            </ul>
          </div>
          <!--Grid column-->
        </c:forEach>

    </div>
    <!--Grid row-->
  </div>
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2020 Copyright:
    <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
  </div>
  <!-- Copyright -->
</footer>