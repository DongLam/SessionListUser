package com.codingraja.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Customer;

@WebServlet("/customer/register")
public class CustomerRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public CustomerRegistrationController() {
		// Do Nothing
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String custId = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String intro = request.getParameter("intro");
		String gender = request.getParameter("gender");
		List<String> hobby = Arrays.asList(request.getParameterValues("hobby"));

		Customer customer = new Customer(firstName, lastName, email, intro, gender, hobby);
		HttpSession session = request.getSession();
		List<Customer> listUser = (List<Customer>) session.getAttribute("customerList");
		if (listUser == null) {
			listUser = new ArrayList<>();
		}

		Customer customerUpdate = (Customer) session.getAttribute("customer");
		if (customerUpdate != null) {
			int id = customerUpdate.getId();
			if (listUser.size() > 0) {
				listUser.get(id).setFirstName(firstName);
				listUser.get(id).setLastName(lastName);
				listUser.get(id).setEmail(email);
				listUser.get(id).setIntro(intro);
				listUser.get(id).setGender(gender);
				listUser.get(id).setHobby(hobby);
				session.setAttribute("customerList", listUser);
				session.removeAttribute("customer");
			}
		} else {
			if (custId == null || custId == "") {
				customer.setId(listUser.size());
				listUser.add(customer);
				session.setAttribute("customerList", listUser);
			}
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
