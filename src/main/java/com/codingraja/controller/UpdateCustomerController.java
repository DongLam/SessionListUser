package com.codingraja.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Model.Customer;

@WebServlet("/customer/update")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCustomerController() {
		// Do Nothing
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custId = request.getParameter("custId");

		if (custId == "" || custId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			int id = Integer.parseInt(custId);
			Customer customer = new Customer();
			HttpSession session = request.getSession();
			List<Customer> listUser = (List<Customer>) session.getAttribute("customerList");
			if (listUser == null) {
				listUser = new ArrayList<>();
			}
			if (id >= 0 && id <= listUser.size()) {
				customer = listUser.get(id);
			}
			request.setAttribute("customer", customer);
			session.setAttribute("customer", customer);

			request.getRequestDispatcher("/").forward(request, response);
		}
	}
}
