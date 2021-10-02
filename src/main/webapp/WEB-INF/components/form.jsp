<form method="POST" action="${pageContext.request.contextPath}/Controller?action=update" id="form__update" class="was-validated">
    <div class="mb-3">
        <input type="hidden" class="form-control" id="id" name="id" required value="${edit.getCustomerID()}">
    </div>
    <div class="mb-3">
        <label for="first-name" class="col-form-label">First Name:</label>
        <input type="text" class="form-control" id="first-name" name="first_name" required value="${edit.getCustomerFirstName()}">
    </div>
    <div class="mb-3">
        <label for="last-name" class="col-form-label">Last Name:</label>
        <input type="text" class="form-control" id="last-name" name="last_name" required value="${edit.getCustomerLastName()}">
    </div>
    <div class="mb-3">
        <label for="email" class="col-form-label">Email:</label>
        <input type="email" class="form-control" id="email" name="email" required value="${edit.getCustomerEmail()}">
    </div>
    <div class="mb-3">
        <label for="phone" class="col-form-label">Phone:</label>
        <input type="number" class="form-control" id="phone" name="phone" required value="${edit.getCustomerPhone()}">
    </div>
    <div class="mb-3">
        <label for="balance" class="col-form-label">Balance:</label>
        <input type="number" class="form-control" id="balance" name="balance" required value="${edit.getCustomerBalance()}" step="any">
    </div>
    <div class="mb-3 mt-2 d-flex justify-content-md-evenly">
        <button type="submit" class="btn btn-primary"><i class="bi bi-save"></i> Save</button>
        <a class="btn btn-danger" id="btn__delete" href="${pageContext.request.contextPath}/Controller?action=delete&id=${edit.getCustomerID()}"><i class="bi bi-trash"></i> Delete</a>
    </div>
</form>