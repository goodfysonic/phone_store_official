<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="assets/includes/header.jsp" %>
<%@ include file="assets/includes/header-bar.jsp" %>

  <main id="main">
    <%@ include file="assets/includes/breadcrumbs.jsp" %>
    
    <!-- ======= Manage Users ======= -->
    <section class="manauser mt-5" id="manauser">
      <div class="container">
        <div class="manauser-title"><h2>Manage Products</h2></div>
        <form method="POST" id="manauser-form" class="manauser-form">
            <div class="manauser-inner">
                <div class="manauser-button d-flex justify-content-end pt-4">
                    <a href="add-new-product" target="_blank"><button class="add-button" action="add" type="button" id="add-button">Add Product</button></a>
                </div>
                <table class="manauser-table">
                    <tr class="table-title">
                        <th>Product ID</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Brand</th>
                        <th>Capacity</th>
                        <th>Display</th>
                        <th>Color</th>
                        <th>Sold</th>
                        <th>Stock</th>
                        <th>Price</th>
                        <th>Note</th>
                    </tr>
                    <c:forEach items="${listProduct}" var="item">
                    <tr class="table-user">
                        <th><input type="number" class="form-control" value="${item.id}" readonly></th>
                        <th><img class="w-50 img-fluid image" src="${item.thumbnail}"></th>
                        <th><input type="text" class="form-control" value="${item.title}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.brandName}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.capacity}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.display}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.color}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.sold}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.stock}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.price}" readonly></th>
                        <th>
                            <button class="edit-button mb-2" action="edit" type="button" id="edit-button">Edit</button>
                            <input class="save-button form-submit mb-2" action="save" type="submit" style="display: none; margin-top: 0;" id="save-button-edit" value="Save Changes">
                            <button class="delete-button" action="delete" type="button" id="delete-button">Delete</button>
                        </th>
                    </tr>
                    </c:forEach>
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