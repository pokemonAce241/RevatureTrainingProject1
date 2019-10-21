package dev.jason.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.jason.comparators.costSorter;
import dev.jason.comparators.statusSorter;
import dev.jason.entities.Reimbursement;
import dev.jason.entities.User;
import dev.jason.services.ReimbursementServicImpl;
import dev.jason.services.ReimbursementService;
import dev.jason.services.UserService;
import dev.jason.services.UserServiceImpl;



public class userController {
	
	private static UserService us = new UserServiceImpl();
	
	private static User currentUser = us.login("jareberry583", "usacor243");
	private static Reimbursement currentPendingReimbursement = null;
	
	public static void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		User user = us.login(username, password);
		currentUser = user;
		
		//System.out.println(user);
		
		Gson gson = new Gson();
		String json = gson.toJson(user);
		
		/*
		// when someone logs in we can store their information in a session for easy access
		HttpSession sess = request.getSession();
		sess.setAttribute("student", user);
		
		// store information on client side
		Cookie cookie = new Cookie("user",user.getUsername());
		response.addCookie(cookie);
		*/

		PrintWriter pw = response.getWriter();
		
		pw.append(json);
		
	}
	
	public static void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = 0;
		String sender = request.getParameter("sender");
		String item  = request.getParameter("item");
		double cost = Double.parseDouble(request.getParameter("cost"));
		String reason = request.getParameter("reason");
		int submitterID = currentUser.getId();
		String status = "pending";
		String managerComment = "waiting to be approved/denied";
		
		Reimbursement reimbursement = new Reimbursement(id,sender,item,cost,reason,submitterID,status,managerComment);
		
		Reimbursement check = us.addReimbursement(reimbursement);
		
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(check);

		pw.append(json);
	}
	
	public static void getPendingReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		currentPendingReimbursement = us.getPendingReimbursement();		
		PrintWriter pw = response.getWriter();	
		
		Gson gson = new Gson();
		String json = gson.toJson(currentPendingReimbursement);

		pw.append(json);
	}
	
	public static void getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Set<Reimbursement> reimbursements = us.getAllReimbursements();		
		PrintWriter pw = response.getWriter();	
		
		Gson gson = new Gson();
		String json = gson.toJson(reimbursements);

		pw.append(json);
	}
	
	
	public static void getAllReimbursementsSortedByCost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Set<Reimbursement> reimbursements = us.getAllReimbursements();
		
		List<Reimbursement> sorted = new ArrayList<>();
		for(Reimbursement r: reimbursements){
			sorted.add(r);
		}
		Collections.sort(sorted, new costSorter());
		
		PrintWriter pw = response.getWriter();	
		
		Gson gson = new Gson();
		String json = gson.toJson(sorted);

		pw.append(json);
	
	
	}
	
	public static void getAllReimbursementsSortedByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Set<Reimbursement> reimbursements = us.getAllReimbursements();
		
		List<Reimbursement> sorted = new ArrayList<>();
		for(Reimbursement r: reimbursements){
			sorted.add(r);
		}
		Collections.sort(sorted, new statusSorter());
		
		PrintWriter pw = response.getWriter();	
		
		Gson gson = new Gson();
		String json = gson.toJson(sorted);

		pw.append(json);
	
	
	}
	
	
	
	
	public static void updateReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		int id = currentPendingReimbursement.getId();
		String sender = currentPendingReimbursement.getSender();
		String item  = currentPendingReimbursement.getItem();
		double cost = currentPendingReimbursement.getCost();
		String reason = currentPendingReimbursement.getReason();
		int submitterID = currentPendingReimbursement.getSubmitterID();
		String status = request.getParameter("status");
		String managerComment = request.getParameter("managerComment");
		
		
		System.out.println(sender);
		System.out.println(item);
		System.out.println(cost);
		
		
		
		Reimbursement reimbursement = new Reimbursement(id,sender,item,cost,reason,submitterID,status,managerComment);
		
		Reimbursement check = us.updateReimbursement(reimbursement);
		
		PrintWriter pw = response.getWriter();	
		
		Gson gson = new Gson();
		String json = gson.toJson(check);

		pw.append(json);
		
	}
	
	

}
