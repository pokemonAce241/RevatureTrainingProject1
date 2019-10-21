package dev.jason.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.jason.controller.userController;


public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MasterServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch(uri){
		
		case "/Project1WebApp/loginUser.do" : {userController.loginUser(request, response);} break;
		case "/Project1WebApp/getAllReimbursements.do" : {userController.getAllReimbursements(request, response);} break;
		case "/Project1WebApp/addReimbursement.do" : {userController.addReimbursement(request, response);} break;
		case "/Project1WebApp/getAllReimbursementsSortedByCost.do" : {userController.getAllReimbursementsSortedByCost(request, response);} break;
		case "/Project1WebApp/getAllReimbursementsSortedByStatus.do" : {userController.getAllReimbursementsSortedByStatus(request, response);} break;
		case "/Project1WebApp/getPendingReimbursement.do" : {userController.getPendingReimbursement(request, response);} break;
		case "/Project1WebApp/updateReimbursement.do" : {userController.updateReimbursement(request, response);} break;
		
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
