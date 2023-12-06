<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- ======= Reset Password ======= -->
    <!--<section class="otpcheck my-5" id="otpcheck">
      <div class="otpcheck-surround">
        <div class="otpcheck-title grid-card"><h2>Reset your password</h2></div>
        <div class="otpcheck-inner">
            <p>Your code was sent to you via email</p>
            <div class="otp-field mb-4">
              <input type="number" maxlength="1"/>
              <input type="number" maxlength="1" disabled />
              <input type="number" maxlength="1" disabled />
              <input type="number" maxlength="1" disabled />
              <input type="number" maxlength="1" disabled />
              <input type="number" maxlength="1" disabled />
            </div>

            <button class="btn btn-primary mb-3">
              Verify
            </button>

            <p class="resend text-muted mb-0">
              Didn't receive code? <a href="">Request again</a>
            </p>
        </div>
      </div>
    </section>-->
    
    <div class="row justify-content-center">
      <div class="col-12 col-md-6 col-lg-4" style="min-width: 500px;">
        <div class="card bg-white mb-5 mt-5 border-0" style="box-shadow: 0 12px 15px rgba(0, 0, 0, 0.02);">
          <div class="card-body p-5 text-center">
            <h4>Verify</h4>
            <p>Your code was sent to you via email</p>
            <form action="check-otp" method="POST">
                <div class="otp-field mb-4">
                  <input type="number" maxlength="1" class="px-0" name="number1"/>
                  <input type="number" maxlength="1" class="px-0" disabled name="number2"/>
                  <input type="number" maxlength="1" class="px-0" disabled name="number3"/>
                  <input type="number" maxlength="1" class="px-0" disabled name="number4"/>
                  <input type="number" maxlength="1" class="px-0" disabled name="number5"/>
                  <input type="number" maxlength="1" class="px-0" disabled name="number6"/>
                </div>
                <c:if test ="${errorForgot != null}">
                    <p>Error: ${errorForgot}</p>
                </c:if>
                <input class="btn btn-primary mb-3 otp-button" type="submit" value="Verify"/>
            </form>
<!--            <a href=""><button class="btn btn-primary mb-3 otp-button">Verify</button></a>-->

            <p class="resend text-muted mb-0">
              Didn't receive code? <a href="">Request again</a>
            </p>
          </div>
        </div>
      </div>
    </div>

  </main><!-- End #main -->
  <script>
      const otp = document.querySelectorAll(".otp-field > input");
    const button = document.querySelector(".btn");

    window.addEventListener("load", () => otp[0].focus());

    otp[0].addEventListener("paste", function(event) {
      event.preventDefault();

      const pastedValue = (event.clipboardData || window.clipboardData).getData(
        "text"
      );
      const otpLength = otp.length;

      for (let i = 0; i < otpLength; i++) {
        if (i < pastedValue.length) {
          otp[i].value = pastedValue[i];
          otp[i].removeAttribute("disabled");
          otp[i].focus();
        } else {
          otp[i].value = ""; // Clear any remaining otp
          otp[i].focus();
        }
      }
    });

    otp.forEach((input, index1) => {
      input.addEventListener("keyup", (e) => {
        const currentInput = input;
        const nextInput = input.nextElementSibling;
        const prevInput = input.previousElementSibling;

        if (currentInput.value.length > 1) {
          currentInput.value = "";
          return;
        }

        if (
          nextInput &&
          nextInput.hasAttribute("disabled") &&
          currentInput.value !== ""
        ) {
          nextInput.removeAttribute("disabled");
          nextInput.focus();
        }

        if (e.key === "Backspace") {
          otp.forEach((input, index2) => {
            if (index1 <= index2 && prevInput) {
              input.setAttribute("disabled", true);
              input.value = "";
              prevInput.focus();
            }
          });
        }

        button.classList.remove("active");
        button.setAttribute("disabled", "disabled");

        const inputsNo = otp.length;
        if (!otp[inputsNo - 1].disabled && otp[inputsNo - 1].value !== "") {
          button.classList.add("active");
          button.removeAttribute("disabled");

          return;
        }
      });
    });
  </script>
  <%@ include file="assets/includes/footer.jsp" %>