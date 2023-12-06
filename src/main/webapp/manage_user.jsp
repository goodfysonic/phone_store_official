<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <th>User ID</th>
                        <th>Full Name</th>
                        <th>Phone number</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Note</th>
                    </tr>
                    <c:forEach items="${listUser}" var="item">
                    <tr class="table-user">
                        <th><input type="number" class="form-control" value="${item.id}" readonly></th>
                        <th><input type="text" class="form-control" value="${item.fullName}" readonly name="fullName"></th>
                        <th><input type="text" class="form-control" value="${item.phone}" readonly name="phone"></th>
                        <th><input type="email" class="form-control" value="${item.email}" readonly name="email"></th>
                        <th><input type="text" class="form-control" value="${item.address}" readonly name="address"></th>
                        <th>
                            <button class="edit-button mb-2" action="edit" type="button" id="edit-button">Edit</button>
                            <form action="manage-user" method="POST">
                                <input type="hidden" value="${item.id}" name="userId">
                                <input class="save-button form-submit mb-2" action="save" type="submit" style="display: none; margin-top: 0;" id="save-button-edit" value="Save Changes">
                            </form>
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