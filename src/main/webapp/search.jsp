<%@include file="common/taglib.jsp" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    <!-- ======= Search ======= -->
    <section class="search">
        <div class="search-bar">
            <div class="bar">
                <div class="d-flex form-inputs">
                    <form action="product" method="GET" class="d-flex">
                        <input class="form-control" type="text" placeholder="Search any product..." name="findTitle" value="${findTitle}" style="width: 850px;">
                        <input name ="indexPage" value="${indexPage}" type="hidden">
                        <input type="submit" value="Search" style="width: 160px;" class="find-button">
                    </form>
                </div>
            </div>
            <div class="cart-bar">
                <a href="cart"><span class="shop-bag"><i class='bx bxs-shopping-bag'></i></span></a>
                <div class="d-flex flex-column ms-2">
<!--                    <span class="qty">1 Product</span>-->
                    <c:choose>
                        <c:when test="${sessionScope.countProduct == 0 || sessionScope.countProduct == 1}">
                            <span class="qty">${sessionScope.countProduct} Product</span>
                        </c:when>
                        <c:otherwise>
                            <span class="qty">${sessionScope.countProduct} Products</span>
                        </c:otherwise>
                    </c:choose>
                    <span class="fw-bold"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.totalPay}" /> VND</span>
                </div>    
            </div>
        </div>
        <div class="search-element">
            <div class="search-grid-container">
            <c:forEach items="${listProduct}" var="p">
                <div class="col search-grid-card">
                    <div class="grid-img">
                        <a href="product-detail?productId=${p.id}" class="link-img">
                            <img src="${p.thumbnail}" class="img-fluid img-zoom">
                        </a>
                    </div>
                    <div class="grid-info">
                        <div type="subtitle" class="title">${p.title}</div>
                        <div class="info-describe">
                            <ul class="ps-0">
                                <li><strong>Price</strong>: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}" /> VND</li>
                                <li><strong>Brand</strong>: ${p.brandName}</li>
                                <li><strong>Display</strong>: ${p.display}</li>
                                <li><strong>Capacity</strong>: ${p.capacity}</li>
                            </ul>
                        </div>
                    </div>
                    <div class="grid-button">
                        <ul class="button-list">
                            <li>
                                <a href="add-to-cart?productId=${p.id}&check=1" class="btn-bn scrollto">Buy now</a><!-- button buy now -->
                            </li>
                            <li>
                                <!-- button add to cart -->
                                <form action="add-to-cart" method = "POST">
                                    <input type="submit" class="btn-atc scrollto" value="Add to cart">
                                    <input type="hidden" value="${p.id}" name ="productId">
                                    <input type="hidden" value="2" name ="check">
                                </form>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:forEach>
        </div>
            <div class="search-bookmarks d-flex mt-5 justify-content-center">
                <c:forEach begin="1" end="${totalPage}" var="i">
                    <form method="GET" action="product">
                        <input class="search-page" name ="indexPage" value="${i}" id="search-pg" type="hidden">
                        <input class="search-page" name ="findTitle" value="${findTitle}" id="search-pg" type="hidden">
                        <input class="search-page" type="submit" value="${i}">
                    </form>
                </c:forEach>
            </div>
        </div>
    </section>
    

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@ include file="assets/includes/footer.jsp" %>