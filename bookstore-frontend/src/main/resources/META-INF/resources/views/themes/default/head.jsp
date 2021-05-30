<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="container mb-4">

    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <c:forEach items="${carusel.caruselSlides}" var="slide" varStatus="loop">
            <li data-target="#carouselExampleIndicators" data-slide-to="${loop.index}" class="${slide.active ? 'active' : ''}"></li>
        </c:forEach>
      </ol>

    <div class="carousel-inner">
        <c:forEach items="${carusel.caruselSlides}" var="slide" varStatus="loop">

            <div class="carousel-item ${slide.active ? 'active' : ''}">
              <img class="d-block w-100" src="${slide.imageUrl}" alt="First slide">
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
</div>