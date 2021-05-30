<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container">
    <div class="container-fluid">
        <div class="row justify-content-between">
            <c:forEach items="${books}" var="book" varStatus="loop">
                <div class="block text-center">  <div class="image"><img  src="/static/image/book/book-00.png"></div>
                    <div class="info py-2 px-2">
                        <div class="row px-3">
                            <div class="cart">
                                <p class="mb-0 sm-font">ADD TO BAG</p>
                            </div>
                            <div class="order">
                                <p class="mb-0 sm-font">ORDER NOW</p>
                            </div>
                        </div>
                        <div class="text-left">
                            <h5 class="mb-0 mt-2">Hangup Trend</h5> <small class="text-muted mb-1">Men's Stylish Designed Shirt</small>
                        </div>
                        <div class="row px-3">
                            <h5>Rs.419</h5>
                            <p class="text-muted ml-2"><del>Rs.799</del></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>