<%@include file="common/taglib.jsp" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- ======= Manage Users ======= -->
    <section class="manauser mt-5" id="manauser">
      <div class="container">
        <div class="manauser-title"><h2>Manage Users</h2></div>
        <form method="POST" id="manauser-form" class="manauser-form">
            <div class="manauser-inner">
                <table class="manauser-table">
                    <tr class="table-title">
                        <th>ID</th>
                        <th>Shopping Cart ID</th>
                        <th>Account ID</th>
                        <th>Purchased Date</th>
                        <th>Total Pay</th>
                        <th>Delivery Address</th>
                        <th>Payment Method</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="item" items="${listHistory}">
                    <tr class="table-user">
                        <th>${item.id}</th>
                        <th>${item.shoppingCartId}</th>
                        <th>${item.accountId}</th>
                        <th><fmt:formatDate type = "both" value = "${item.purchasedDate}" /></th>
                        <th><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${item.totalPay}" /> VND</th>
                        <th>${item.deliveryAddress}</th>
                        <th>${item.paymentMethod}</th>
                        <th>${item.status}</th>
                    </tr>
                    </c:forEach>
                    <!--<c:forEach var="item" items="${Cart}">
                        <tr class="table-product">
                            <th><input type="number" class="form-control" value="${item.id}" readonly></th>
                            <th><input type="text" class="form-control" value="${item.orderDate}" readonly></th>
                            <th><input type="text" class="form-control" value="${item.LineItem.Product.title}" readonly></th>
                            <th><input type="text" class="form-control" value="${item.LineItem.Product.capacity}" readonly></th>
                            <th><input type="text" class="form-control" value="${item.LineItem.Product.display}" readonly></th>
                            <th><input type="email" class="form-control" value="${item.LineItem.Product.quantity}" readonly></th>
                            <th><input type="text" class="form-control" value="${item.LineItem.Product.price}" readonly></th>
                            <th><input type="text" class="form-control" value="${item.status}" readonly></th>
                            <th>
                                <button class="edit-button mb-2" action="edit" type="button" id="edit-button">Edit</button>
                                <input class="save-button form-submit mb-2" action="save" type="submit" style="display: none; margin-top: 0;" id="save-button-edit" value="Save Changes">
                                <button class="delete-button" action="delete" type="button" id="delete-button">Delete</button>
                            </th>
                        </tr>
                    </c:forEach>-->
                </table>
            </div>
          </form>
      </div>
    </section>
  </main><!-- End #main -->
  <script>
    var buttons = {
        edit: {
            button: document.querySelectorAll('.edit-button'),
            saveButton: document.querySelectorAll('.save-button'),
        },
        delete: {
            button: document.querySelectorAll('.delete-button'),
        },
    };

    var inputs = document.querySelectorAll('#manauser-form input');
    var table = document.querySelector('.manauser-table');

    buttons.edit.button.forEach((editButton, index) => {
        editButton.addEventListener('click', function() {
            var parentRow = this.parentNode.parentNode;
            var allInputs = parentRow.querySelectorAll('input');
            allInputs.forEach((input, inputIndex) => {
                if (inputIndex !== 0) {
                    input.removeAttribute('readonly');
                }
            });
            buttons.edit.saveButton[index].style.display = 'inline-block';
            editButton.style.display = 'none';
        });
    });

    buttons.delete.button.forEach((deleteButton, index) => {
        deleteButton.addEventListener('click', function() {
            var parentRow = this.parentNode.parentNode;
            parentRow.remove();
        });
    });

    buttons.edit.saveButton.forEach((saveButton, index) => {
        saveButton.addEventListener('click', function(event) {
            event.preventDefault();
            var parentRow = this.parentNode.parentNode;
            var allInputs = parentRow.querySelectorAll('input');
            allInputs.forEach(input => input.setAttribute('readonly', true));
            buttons.edit.button[index].style.display = 'inline-block';
            saveButton.style.display = 'none';
        });
    });

  </script>
  <%@ include file="assets/includes/footer.jsp" %>