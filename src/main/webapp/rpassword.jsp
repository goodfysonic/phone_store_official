<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- ======= Reset Password ======= -->
    <section class="rpassword my-5" id="fpassword">
      <div class="rpassword-surround">
        <div class="rpassword-title grid-card"><h2>Reset your password</h2></div>
        <div class="rpassword-inner">
            <p class="text-center mb-3">Please enter your new password</p>
            <form method="POST" class="reset-p-form" id="reset-p-form" action="change-forgot-password">
                <h4 class="reset-title-r">New password</h4>
                <div class="form-group">
                    <label for="email"><i class="zmdi zmdi-email"></i></label>
                    <input type="password" name="password" id="password" placeholder="New password"/>
                </div>
                <h4 class="reset-title-cr pt-4">Confirm new password</h4>
                <div class="form-group">
                    <label for="re-password"><i class="zmdi zmdi-lock-outline"></i></label>
                    <input type="password" name="re_password" id="re_password" placeholder="Confirm new password"/>
                </div>
                <c:if test ="${errorMessage != null}">
                    <p>Error: ${errorMessage}</p>
                </c:if>
                <div class="form-group form-button text-center">
                    <input type="submit" name="reset-p" id="reset-p" class="form-submit" value="Reset Password"/>
                </div>
            </form>
        </div>
      </div>
    </section>

  </main><!-- End #main -->
  <script>
      document.getElementById('reset-p').addEventListener('click', function(event) {
        var pass = document.getElementById('password').value;
        var rePass = document.getElementById('re_password').value;
        if (pass !== rePass) {
            alert("Passwords do not match.");
            event.preventDefault(); // Prevent form submission
        }
    });

  </script>
  <%@ include file="assets/includes/footer.jsp" %>