/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.walterkstro.controller;

import gt.com.walterkstro.model.Customer;
import gt.com.walterkstro.operations.Operations;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author walte
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action") != null ? req.getParameter("action") : "";

        switch (action) {
            case "find": {
                this.findCustomer(req, resp);
                break;
            }
            case "delete":{
                this.deleteCustomer(req, resp);
                break;
            }
            default:
                this.listCustomers(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "insert": {
                this.insertCustomer(req, resp);
                break;
            }
            case "update": {
                this.updateCustomer(req, resp);
                break;
            }
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int rowAffected = Operations.DELETE(new Customer(id));
        if (rowAffected == 1) {
            resp.sendRedirect(req.getContextPath() + "/Controller");
        }
    }
    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (validateParamsForm(req)) {
            var rowAffected = Operations.UPDATED(this.buildObjectCustomer(req));
            if (rowAffected == 1) {
                resp.sendRedirect(req.getContextPath() + "/Controller");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/Controller");
        }
    }

    private void findCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = new Customer(id);
        customer = Operations.FIND(customer);
        req.setAttribute("edit", customer);

        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/edit.jsp");
        dispatcher.forward(req, resp);

    }

    private void listCustomers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> listado = Operations.SELECT();
        String totalBalance = Operations.getTotalBalance();

        req.setAttribute("listado", listado);
        req.setAttribute("totalBalance", totalBalance);
        req.setAttribute("totalCustomers", listado.size());

        RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (validateParamsForm(req)) {
            var rowAffected = Operations.INSERT(this.buildObjectCustomer(req));
            if (rowAffected == 1) {
                resp.sendRedirect(req.getContextPath() + "/Controller");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/Controller");
        }
    }

    /*UTILITIES*/
    private Customer buildObjectCustomer(HttpServletRequest req) {
        Customer customer = null;
        Map params = req.getParameterMap();
        
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        double balance = Double.parseDouble(req.getParameter("balance"));
        
        customer = new Customer(firstName, lastName, email, phone, balance);
        
        if (params.size() == 8) {
            int id = Integer.parseInt(req.getParameter("id"));
            customer.setCustomerID(id);
        }
        return customer;
    }

    private boolean validateParamsForm(HttpServletRequest req) {
        Map params = req.getParameterMap();
        var isOkParams = true;
        if (params.size() == 6) {
            Iterator iterator = params.keySet().iterator();

            /*VALIDATE PARAMS OF FORM REGISTER AND UPDATE*/
            while (iterator.hasNext()) {
                var param = ((String[]) params.get(iterator.next()))[0].equals("");
                if (param) {
                    isOkParams = false;
                }
            }
        }
        return isOkParams;
    }

}
