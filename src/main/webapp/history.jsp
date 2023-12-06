<%@include file="common/taglib.jsp" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

<main id="main">
<%@ include file="assets/includes/breadcrumbs.jsp" %>
    <!-- ======= History ======= -->
    <section class="checkout mt-5" id="checkout">
      <div class="container">
        <div class="checkout-title"><h2>History</h2></div>
        <div class="checkout-inner">
            <h2>User ID (${sessionScope.loggedAccount.id})</h2>
            <p>Full name: ${sessionScope.loggedAccount.fullName}
            <br>Email: ${sessionScope.loggedAccount.email}</p>
            <table class="checkout-table">
                <tr class="table-title">
                    <th>ID</th>
                    <th>Shopping Cart ID</th>
                    <th>Purchased Date</th>
                    <th>Total pay</th>
                    <th>Delivery Address</th>
                    <th>Payment method</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="item" items="${listInvoice}">
                    <tr class="table-product">
                        <th>${item.id}</th>
                        <th>${item.shoppingCartId}</th>
                        <th><fmt:formatDate type = "both" value = "${item.purchasedDate}" /></th>
                        <th><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.totalPay}" /> VND</th>
                        <th>${item.deliveryAddress}</th>
                        <th>${item.paymentMethod}</th>
                        <th>${item.status}</th>
                    </tr>
                </c:forEach>
            </table>
        </div> 
      </div>
    </section>
    
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<%@ include file="assets/includes/footer.jsp" %>