<%-- 
    Document   : Result
    Created on : 22/09/2021, 12:08:34
    Author     : walter
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

        <title>Control Customers</title>
    </head>
    <body>
        <jsp:include page="WEB-INF/commons/header.jsp"/>
        
        <div class="container">
            <section class="row my-3 align-items-center">
                <article class="col">
                    <button class="btn btn-primary" 
                            type="button" data-bs-toggle="modal" 
                            data-bs-target="#new-customer">
                        <i class="bi bi-person-check"></i>
                        Add new customer
                    </button>
                    <%-- SHOW WINDOW MODAL--%>
                    <jsp:include page="WEB-INF/components/modal.jsp"/>
                </article>
                <article class="col d-flex justify-content-between">
                    <div class="total__balance bg-success text-center py-1 px-5 text-light fs-4 rounded">
                        <p class="my-0">Total Balance</p>
                        <p class="my-0 fw-bolder">${totalBalance}<p>
                    </div>
                    <div class="total__customers bg-success text-center py-1 px-5 text-light fs-4 rounded">
                        <p class="my-0">Total Customers</p>
                        <p class="my-0 fw-bolder">${totalCustomers}</p>
                    </div>
                </article>
            </section>
            <section class="row">
                <article class="col-12">
                    <h2>Customer List</h2>
                    <%-- SHOW WINDOW TABLE OF CUSTOMERS--%>
                    <jsp:include page="WEB-INF/components/table.jsp"/>
                </article>
            </section>
        </div>
        
        <!-- Optional JavaScript; choose one of the two! -->
        <script src="${pageContext.request.contextPath}/js/index.js"></script>
        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
        -->
    </body>
</html>