<%@include file="common/taglib.jsp" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    <!-- ======= Portfolio Details Section ======= -->
    <section id="product-details" class="product-details">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="product-details-slider swiper">
              <div class="swiper-wrapper align-items-center">

                <div class="swiper-slide">
                  <img src="${product.thumbnail}" alt="">
                </div>
                  <c:if test="${product.subImage1 != null}">
                    <div class="swiper-slide">
                        <img src="${product.subImage1}" alt="">
                    </div>
                </c:if>
                <c:if test="${product.subImage2 != null}">
                    <div class="swiper-slide">
                        <img src="${product.subImage2}" alt="">
                    </div>
                </c:if>

              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="product-info">
              <h3>${product.title}</h3>
              <ul>
                <li><strong>Price</strong>: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" /> VND</li>
                <li><strong>Brand</strong>: ${product.brandName}</li>
                <li><strong>Display</strong>: ${product.display}</li>
                <li><strong>Capacity</strong>: ${product.capacity}</li>
                <!--<li><strong>Color</strong>: <a href="#">www.example.com</a></li>-->
                <li><strong>Color</strong>: <br>
                    <div class="pd-grid-container">
                        <div class="pd-grid-card" id="button-color-1">
                            <p>${product.color}</p> 
                        </div>
                    </div>
                </li>
              </ul>
              <div class="grid-button">
                <ul class="button-list">
                    <li>
                        <a href="add-to-cart?productId=${product.id}&check=1" class="btn-bn scrollto">Buy now</a><!-- button buy now -->
                    </li>
                    <!-- button add to cart -->
                    <li>
                        <!-- button add to cart -->
                        <form action="add-to-cart" method = "POST">
                            <input type="submit" class="btn-atc scrollto" value="Add to cart">
                            <input type="hidden" value="${product.id}" name ="productId">
                            <input type="hidden" value="3" name ="check">
                        </form>
                    </li>
                </ul>
              </div>
            </div>
          </div>

        </div>

      </div>
      <div class="details">
          <div class="details-title"><h2>Product Details</h2></div>
          <div class="product-description">
              <h2>${product.title}</h2>
              <ul class="ps-0">
                <li><strong>Brand</strong>: ${product.brandName}</li>
                <li><strong>Display</strong>: ${product.display}</li>
                <li><strong>Capacity</strong>: ${product.capacity}</li>
                <li><strong>Description</strong> : <p>${product.description}</p></li>
              </ul>
          </div>
      </div>
    
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@ include file="assets/includes/footer.jsp" %>