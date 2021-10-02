<%-- 
    Document   : table
    Created on : 24/09/2021, 12:56:31
    Author     : walter
--%>

<%@page import="gt.com.walterkstro.model.Customer"%>
<%@page import="gt.com.walterkstro.operations.Operations"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone</th>
                <th scope="col">Balance</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${listado}">
                <tr>
                    <td>${customer.getCustomerID()}</td>
                    <td>${customer.getCustomerFirstName()}</td>
                    <td>${customer.getCustomerLastName()}</td>
                    <td>${customer.getCustomerEmail()}</td>
                    <td class="text-end">${customer.getCustomerPhone()}</td>
                    <td class="text-end">${customer.formatBalance()}</td>
                    <td><a href="${pageContext.request.contextPath}/Controller?action=find&id=${customer.getCustomerID()}" class="btn btn-primary btn-sm"><i class="bi bi-pencil-square"></i></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>