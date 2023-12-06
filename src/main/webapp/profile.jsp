<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>
  
  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    <!-- ======= Profile ======= -->
    <section class="profile">
        <div class="container mt-5 mb-5 rounded">
            <div class="row">
                <div class="col-md-3 border-end">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <c:choose>
                            <c:when test="${sessionScope.loggedAccount.avatar == null || sessionScope.loggedAccount.avatar.trim().length() == 0}">
                                <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                            </c:when>
                            <c:otherwise>
                                <img class="rounded-circle mt-5" width="150px" src="${sessionScope.loggedAccount.avatar}">
                            </c:otherwise>
                        </c:choose>
                        <span class="fw-bold">${sessionScope.loggedAccount.fullName}</span>
                        <span class="text-black-50">${sessionScope.loggedAccount.email}</span>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="p-3 py-5 profile-info">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-end">Profile Settings</h4>
                        </div>
                        <form action="profile" method = "POST">    
                            <div class="row mt-2">
                                <div class="col-md-6"><label class="labels">Name</label>
                                    <input type="text" class="form-control" placeholder="first name" value="${sessionScope.loggedAccount.fullName}" name="fullName"></div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-md-12 form-group">
                                    <label class="labels">Mobile Number</label>
                                    <input type="text" class="form-control" placeholder="enter phone number" value="${sessionScope.loggedAccount.phone}" name="phone">
                                </div>
                                <div class="col-md-12 form-group">
                                    <label class="labels">Address Line</label>
                                    <input type="text" class="form-control" placeholder="enter address line" value="${sessionScope.loggedAccount.address}" name="address">
                                </div>
                                <div class="col-md-12 form-group">
                                    <label class="labels">Avatar Path</label>
                                    <input type="text" class="form-control" placeholder="enter avatar path" value="${sessionScope.loggedAccount.avatar}" name="avatar">
                                </div>
                                <div class="mt-5 text-center">
                                    <input type="submit" class="btn btn-primary profile-button" id="edit-button" value="Edit Profile">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@ include file="assets/includes/footer.jsp" %>