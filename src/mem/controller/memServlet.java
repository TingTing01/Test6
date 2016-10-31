package mem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mem.model.memDAO;
import mem.model.memDAO_interface;
import mem.model.memVO;

@WebServlet("/mem")
public class memServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req ,HttpServletResponse resp ) 
	throws ServletException,IOException{
		doPost(req,resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		Map<String, String> errorMsgs =new HashMap<>();
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("error", errorMsgs);
		String action=req.getParameter("method");
//----------------------------------------------insert---------------
		if("newMember".equals(action)){
		
			String name = req.getParameter("m_name");
			String account =req.getParameter("m_account");		
			String pwsd =req.getParameter("m_pwsd");		

//		if(!errorMsgs.isEmpty()){
//			
//		}
		memDAO_interface dao =new memDAO();
		memVO memvo= new memVO();
		memvo.setMem_name(name);
		memvo.setMem_account(account);
		memvo.setMem_password(pwsd);
		dao.insert(memvo);
		
		
		}
//------------------------------------update------------
		
		
		
		
		
		
		
	}
	
	
}
