<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex align-items-center">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
          <h1>A phone selling website</h1>
          <h2>Quality so high, you'll wish you had more money to buy more.</h2>
          <div class="d-flex justify-content-center justify-content-lg-start">
            <c:if test="${sessionScope.loggedAccount == null}">
                <a href="login" class="btn-get-started scrollto">Get Started</a>
            </c:if>
          </div>
        </div>
        <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
          <img src="assets/img/logo.png" class="img-fluid animated" alt="">
        </div>
      </div>
    </div>

  </section><!-- End Hero -->

  <main id="main">

    <!-- ======= Clients Section ======= -->
    <section id="clients" class="clients section-bg">
      <div class="container">

        <div class="row" data-aos="zoom-in">

          <div class="col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center">
            <img src="assets/img/clients/samsung.png" class="img-fluid" alt="">
          </div>

          <div class="col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center">
            <img src="assets/img/clients/apple.png" class="img-fluid" alt="">
          </div>

          <div class="col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center">
            <img src="assets/img/clients/xiaomi.png" class="img-fluid" alt="">
          </div>

          <div class="col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center">
            <img src="assets/img/clients/oppo.png" class="img-fluid" alt="">
          </div>

          <div class="col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center">
            <img src="assets/img/clients/nokia.png" class="img-fluid" alt="">
          </div>

          <div class="col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center">
            <img src="assets/img/clients/vivo.png" class="img-fluid" alt="">
          </div>

        </div>

      </div>
    </section><!-- End Cliens Section -->

    <!-- ======= Products Section ======= -->
    <section id="product" class="product section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Products</h2>
          <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>
        </div>

        <ul id="product-flters" class="d-flex justify-content-center" data-aos="fade-up" data-aos-delay="100">
          <li data-filter="*" class="filter-active">All</li>
          <li data-filter=".filter-samsung">Samsung</li>
          <li data-filter=".filter-apple">Apple</li>
          <li data-filter=".filter-xiaomi">Xiaomi</li>
          <li data-filter=".filter-oppo">Oppo</li>
          <li data-filter=".filter-nokia">Nokia</li>
          <li data-filter=".filter-vivo">Vivo</li>
        </ul>

        <div class="row product-container" data-aos="fade-up" data-aos-delay="200">
            <c:forEach items="${listSamsung}" var="s">
                <div class="col-lg-4 col-md-6 product-item filter-samsung">
                    <div class="product-img"><img src="${s.thumbnail}" class="img-fluid" alt=""></div>
                    <div class="product-info">
                    <h4>${s.title}</h4>
                    <p>${s.brandName}</p>
                    <a href="${s.thumbnail}" data-gallery="productGallery" class="product-lightbox preview-link" title="${s.title}"><i class="bx bx-plus"></i></a>
                    <a href="product-detail?productId=${s.id}" class="details-link" title="More Details"><i class="bx bx-link"></i></a>
                  </div>
                </div>
            </c:forEach>
            <c:forEach items="${listXiaomi}" var="s">
                <div class="col-lg-4 col-md-6 product-item filter-xiaomi">
                    <div class="product-img"><img src="${s.thumbnail}" class="img-fluid" alt=""></div>
                    <div class="product-info">
                    <h4>${s.title}</h4>
                    <p>${s.brandName}</p>
                    <a href="${s.thumbnail}" data-gallery="productGallery" class="product-lightbox preview-link" title="${s.title}"><i class="bx bx-plus"></i></a>
                    <a href="product-detail?productId=${s.id}" class="details-link" title="More Details"><i class="bx bx-link"></i></a>
                  </div>
                </div>
            </c:forEach>
            <c:forEach items="${listNokia}" var="s">
                <div class="col-lg-4 col-md-6 product-item filter-nokia">
                    <div class="product-img"><img src="${s.thumbnail}" class="img-fluid" alt=""></div>
                    <div class="product-info">
                    <h4>${s.title}</h4>
                    <p>${s.brandName}</p>
                    <a href="${s.thumbnail}" data-gallery="productGallery" class="product-lightbox preview-link" title="${s.title}"><i class="bx bx-plus"></i></a>
                    <a href="product-detail?productId=${s.id}" class="details-link" title="More Details"><i class="bx bx-link"></i></a>
                  </div>
                </div>
            </c:forEach>
            <c:forEach items="${listVivo}" var="s">
                <div class="col-lg-4 col-md-6 product-item filter-vivo">
                    <div class="product-img"><img src="${s.thumbnail}" class="img-fluid" alt=""></div>
                    <div class="product-info">
                    <h4>${s.title}</h4>
                    <p>${s.brandName}</p>
                    <a href="${s.thumbnail}" data-gallery="productGallery" class="product-lightbox preview-link" title="${s.title}"><i class="bx bx-plus"></i></a>
                    <a href="product-detail?productId=${s.id}" class="details-link" title="More Details"><i class="bx bx-link"></i></a>
                  </div>
                </div>
            </c:forEach>
            <c:forEach items="${listApple}" var="s">
                <div class="col-lg-4 col-md-6 product-item filter-apple">
                    <div class="product-img"><img src="${s.thumbnail}" class="img-fluid" alt=""></div>
                    <div class="product-info">
                    <h4>${s.title}</h4>
                    <p>${s.brandName}</p>
                    <a href="${s.thumbnail}" data-gallery="productGallery" class="product-lightbox preview-link" title="${s.title}"><i class="bx bx-plus"></i></a>
                    <a href="product-detail?productId=${s.id}" class="details-link" title="More Details"><i class="bx bx-link"></i></a>
                  </div>
                </div>
            </c:forEach>
            <c:forEach items="${listOppo}" var="s">
                <div class="col-lg-4 col-md-6 product-item filter-oppo">
                    <div class="product-img"><img src="${s.thumbnail}" class="img-fluid" alt=""></div>
                    <div class="product-info">
                    <h4>${s.title}</h4>
                    <p>${s.brandName}</p>
                    <a href="${s.thumbnail}" data-gallery="productGallery" class="product-lightbox preview-link" title="${s.title}"><i class="bx bx-plus"></i></a>
                    <a href="product-detail?productId=${s.id}" class="details-link" title="More Details"><i class="bx bx-link"></i></a>
                  </div>
                </div>
            </c:forEach>
        </div>

      </div>
    </section><!-- End Products Section -->
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@ include file="assets/includes/footer.jsp" %>