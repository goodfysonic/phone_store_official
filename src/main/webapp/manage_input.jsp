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
                        <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                        <span class="fw-bold">Cart</span>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="p-3 py-5 profile-info">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-end">Create a new Product</h4>
                        </div>
                        <form action="add-new-product" method = "POST"> 
                        <div class="row mt-3">
                            <div class="col-md-6 form-group">
                                <label class="labels">Product Name</label>
                                <input type="text" class="form-control" placeholder="product name" value="${productName}" name="productName">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Brand</label>
                                <input type="text" class="form-control" placeholder="brand" value="${brand}" name="brand">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Capacity</label>
                                <input type="text" class="form-control" placeholder="capacity" value="${capacity}" name="capacity">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Display</label>
                                <input type="text" class="form-control" placeholder="display" value="${display}" name="display">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Color</label>
                                <input type="text" class="form-control" placeholder="color" value="${color}" name="color">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Description</label>
                                <input type="text" class="form-control" placeholder="description" value="${description}" name="description">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Stock</label>
                                <input type="text" class="form-control" placeholder="stock" value="${stock}" name="stock">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Price</label>
                                <input type="text" class="form-control" placeholder="price" value="${price}" name="price">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Image 1</label>
                                <input type="text" class="form-control" placeholder="image 1" value="${thumbnail}" name="thumbnail">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Image 2</label>
                                <input type="text" class="form-control" placeholder="image 2" value="${subImage1}" name="subImage1">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Image 3</label>
                                <input type="text" class="form-control" placeholder="image 3" value="${subImage2}" name="subImage2">
                            </div>
                            <div class="col-md-12 form-group">
                                <label class="labels">Status</label>
                                <input type="text" class="form-control" placeholder="status" value="${status}" name="status">
                            </div>
                        </div>
                            <c:if test="${errorMessage != null}">
                                <p>${errorMessage}</p>
                            </c:if>
                            <div class="mt-5 text-center">
                                <input type="submit" class="btn btn-primary profile-button" id="edit-button" value="Edit Profile">
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