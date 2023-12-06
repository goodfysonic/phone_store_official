<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- ======= Forget Password ======= -->
    <section class="fpassword my-5" id="fpassword">
      <div class="fpassword-surround">
        <div class="fpassword-title grid-card"><h2>Reset your password</h2></div>
        <div class="fpassword-inner">
            <p class="text-center mb-3">If the account exists, we'll email you instructions to reset the password.</p>
            <form method="POST" class="forget-p-form" id="forget-p-form" action="getOTP">
                <h4 class="reset-title">Your Email:</h4>
                <div class="form-group">
                    <label for="email"><i class="zmdi zmdi-email"></i></label>
                    <input type="email" name="email" id="email" placeholder="Your Email"/>
                </div>
                <c:if test ="${message != null}">
                    <p>Error: ${message}</p>
                </c:if>
                <div class="form-group form-button text-center">
                    <input type="submit" name="forget-p" id="forget-p" class="form-submit" value="Reset Password"/>
                </div>
            </form>
        </div>
      </div>
    </section>

  </main><!-- End #main -->

  <%@ include file="assets/includes/footer.jsp" %>