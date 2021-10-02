<%-- 
    Document   : modal
    Created on : 24/09/2021, 12:25:22
    Author     : walter
--%>

<!-- Modal -->
<div class="modal fade" id="new-customer" tabindex="-1" aria-labelledby="New customer" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form method="POST" action="${pageContext.request.contextPath}/Controller?action=insert" id="form__register" class="was-validated">
                    <div class="mb-3">
                        <label for="first-name" class="col-form-label">First Name:</label>
                        <input type="text" class="form-control" id="first-name" name="first_name" required>
                    </div>
                    <div class="mb-3">
                        <label for="last-name" class="col-form-label">Last Name:</label>
                        <input type="text" class="form-control" id="last-name" name="last_name" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="col-form-label">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="col-form-label">Phone:</label>
                        <input type="number" class="form-control" id="phone" name="phone" required>
                    </div>
                    <div class="mb-3">
                        <label for="balance" class="col-form-label">Balance:</label>
                        <input type="number" class="form-control" id="balance" name="balance" required step="any">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="btn__cancel" data-bs-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="btn__register">Register</button>
            </div>
        </div>
    </div>
</div>
