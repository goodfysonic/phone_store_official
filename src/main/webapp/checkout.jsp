<%@include file="common/taglib.jsp" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

<main id="main">
<%@ include file="assets/includes/breadcrumbs.jsp" %>

    <!-- ======= Checkout ======= -->
    <section class="checkout mt-5" id="checkout">
      <div class="container">
        <div class="checkout-title"><h2>Checkout Details</h2></div>
        <div class="checkout-inner">
            <h2>User ID (${shoppingCart.accountId.id})</h2>
            <p>Full name: ${shoppingCart.accountId.fullName}
            <br>Email: ${shoppingCart.accountId.email}
            <br>Cart ID: ${shoppingCart.id}
            <br>Checkout information</p>
            <table class="checkout-table">
                <tr class="table-title">
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Color</th>
                    <th>Display</th>
                    <th>Capacity</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <c:forEach items="${shoppingCart.cardItemList}" var="item">
                    <tr class="table-product">
                        <th>${item.productId.id}</th>
                        <th>${item.productId.title}</th>
                        <th>${item.productId.brandName}</th>
                        <th>${item.productId.color}</th>
                        <th>${item.productId.display}</th>
                        <th>${item.productId.capacity}</th>
                        <th>${item.quantity}</th>
                        <th><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.productId.price}" /> VND</th>
                    </tr>
                </c:forEach>
            </table>
        </div> 
      </div>
    </section>
    
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<%@ include file="assets/includes/footer.jsp" %>