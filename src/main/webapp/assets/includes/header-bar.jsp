<!-- ======= Header ======= -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="home">CONFIRM</a></h1>

      <nav id="navbar" class="navbar">
        <c:choose>
            <c:when test="${sessionScope.loggedAccount.kind == 1}">
              <ul>
                <li><a class="nav-link scrollto" href="manage-user">Manage User</a></li>
                <li><a class="nav-link scrollto" href="manage-product">Manage Product</a></li>
                <li><a class="nav-link scrollto" href="manage-invoice">Manage Cart</a></li>
                <li class="dropdown"><a href="#" id="custom-link-button"><i class="bi bi-person custom-icon"></i></a>
                  <ul>
                    <li><a href="profile">Account</a></li>
                    <li><a href="logout">Log out<i class="bi bi-box-arrow-right"></i></a></li>
                  </ul>
              </ul>
            </c:when>
            <c:otherwise>
              <ul>
                <li><a class="nav-link scrollto " href="home">Home</a></li>
                <li><a class="nav-link scrollto" href="product">Search</a></li>
                <li><a class="nav-link scrollto" href="home#services">Services</a></li>
                <li><a class="nav-link scrollto" href="home#product">Products</a></li>
                <li class="dropdown"><a href="#" id="custom-link-button"><i class="bi bi-person custom-icon"></i></a>
                  <c:choose>
                    <c:when test="${sessionScope.loggedAccount == null}">
                        <ul>
                          <li><a href="login">Login</a></li>
                          <li><a href="register">Sign up</a></li>
                        </ul>
                     </c:when>
                    <c:otherwise>
                        <ul>
                          <li><a href="profile">Account</a></li>
                          <li><a href="history">History</a></li>
                          <li><a href="logout">Log out</a><i class="bi bi-box-arrow-right"></i></li>
                        </ul>
            </c:otherwise>
              </c:choose>
            </li>
            <li>
              <a a class="nav-link" href="cart" id="custom-link-button">
                <i class="bi bi-cart custom-icon"></i>
              </a>
            </li>
            <li>
              <div class="li-info">
                  <c:choose>
                      <c:when test="${sessionScope.countProduct == 0 || sessionScope.countProduct == 1}">
                          <span class="qty">(${sessionScope.countProduct}) Product</span>
                      </c:when>
                      <c:otherwise>
                          <span class="qty">(${sessionScope.countProduct}) Products</span>
                      </c:otherwise>
                  </c:choose>
              </div>
            </li>
          </ul>
        <!--</c:otherwise>
      </c:choose>-->
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->