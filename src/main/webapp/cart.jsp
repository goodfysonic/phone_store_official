<%@include file="common/taglib.jsp" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>
  
  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- Cart Form -->
    <section class="shopping-cart background">
	<div class="container">
            <div class="block-heading">
		<h2>Shopping Cart</h2>
            </div>
            <div class="content">
	 	<div class="row">
                    <div class="col-12 col-lg-8">
	 		<div class="items">
                            <c:forEach items="${sessionScope.cart}" var ="item" >
                            <div class="product">
				<div class="row">
                                    <div class="col-3">
					<img class="ps-3 img-fluid image" src="${item.value.productId.thumbnail}">
                                    </div>
                                    <div class="col-8">
					<div class="info d-flex">
                                            <div class="product-data">
                                                <div class="product-name" style="width: 180px;">
                                                    <a href="#">${item.value.productId.title}</a>
                                                    <div class="product-info mt-0">
                                                        <div>Brand: <span class="value">${item.value.productId.brandName}</span></div>
                                                        <div>Display: <span class="value">${item.value.productId.display}</span></div>
                                                        <div>Capacity: <span class="value">${item.value.productId.capacity}</span></div> 
                                                        <div>Color: <span class="value">${item.value.productId.color}</span></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="quantity d-flex">
                                                <label for="quantity"><b>Quantity:</b></label>
                                                <c:if test="${item.value.quantity > 1}">
                                                    <a id="decrease" class="decrease-button" aria-label="Decrease" href="add-to-cart?productId=${item.value.productId.id}&check=5">
                                                        <i class="bi bi-dash"></i>
                                                    </a>
                                                </c:if>
                                                <input id="quantity" type="number" value ="${item.value.quantity}" min="1" class="form-control quantity-input mt-4" readonly>
                                                <a id="increase" class="increase-button" aria-label="Increase" href="add-to-cart?productId=${item.value.productId.id}&check=4">
                                                    <i class="bi bi-plus-lg"></i>
                                                </a>
                                            </div>
                                            <div class="text-center price" style="width: 124px;">
                                                <span><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.value.quantity * item.value.productId.price}" /> VND</span>
                                            </div>
                                            <div class="trash">
                                                <form action="remove-cart-item" method="POST">
                                                    <input type="hidden" value="${item.key}" name="itemKey"/>
                                                    <input type="submit" value="Remove" id="erase" class="erase-button" aria-label="Erase"/>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
				</div>
                            </div>
                            </c:forEach>
                          
			</div>
                    </div>
                    <div class="col-12 col-lg-4">
                        <div class="summary">
                            <h3>Summary</h3>
                            <div class="summary-item"><span class="text">Subtotal</span><span class="price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.totalPay}" /> VND</span></div>
                            <div class="summary-item"><span class="text">Shipping</span><span class="price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "10000" /> VND</span></div>
                            <div class="summary-item pt-2"><span class="text">Total</span><span class="price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sessionScope.totalPay + 10000}" /> VND</span></div>
                            <div class="summary-item pt-2">
                                <span class="text">Payment</span>
                                <div class="grid-container">
                                    <div class="grid-card">
                                        <img src="assets/img/cod.png" alt="cash on delivery"/>
                                    </div>
                                </div>
                            </div>
                            <form action="check-out" method="POST">
                                <div class="summary-item pt-2">
                                    <span class="text">Delivery Address</span><span class="price"><input type="text" name="deliveryAddress"/></span>
                                </div>
                                <input type="hidden" value="10000" name="shippingCost"/>
                                <input type="submit" class="btn btn-primary btn-lg w-100" value="Checkout">
                            </form>
			</div>
                    </div>
		</div> 
            </div>
	</div>
    </section>

  </main><!-- End #main -->
  <!-- ======= Footer ======= -->
  <%@ include file="assets/includes/footer.jsp" %>