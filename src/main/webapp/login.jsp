<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- Log in  Form -->
        <section class="login">
            <div class="container-login">
                <div class="login-content">
                    <div class="login-image">
                        <figure><img src="assets/img/login-image.jpg" alt="sing up image"></figure>
                        <a href="register" class="login-image-link a-login">You don't have an account?</a>
                    </div>

                    <div class="login-form">
                        <h2 class="form-title h2-style">Log in</h2>
                        <form method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_name" id="your_name" placeholder="Your Name"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password"/>
                            </div>
                            <c:if test="${errorMessage != null}">
                                <p>${errorMessage}</p>
                            </c:if>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="login" id="login" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                        <div class="social-login">
                            <a href="getOTP" class="login-image-link a-login" style="font-size: 15px;">Forget your password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    
    <!-- JS -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>

  </main><!-- End #main -->

  <%@ include file="assets/includes/footer.jsp" %>