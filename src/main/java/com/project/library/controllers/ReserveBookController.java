package com.project.library.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.xdevapi.Result;
import com.sun.org.glassfish.gmbal.ParameterNames;

@Controller
public class ReserveBookController extends ControllerBasic{

	
	@RequestMapping("/reserveBook")
	public ModelAndView reserveBook()
	{
		ModelAndView mv = new ModelAndView();
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		
		mv.setViewName("reservedBookDetails");
		mv.addObject("username", logedInUser.getUserName());
		String title = SearchController.getBookTitle();
		System.out.println(logedInUser.getUserName() + "   " + title);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			
			st = conn.createStatement();
			String sqlUpdate = new String("update reservedbooks set isReserved=1, whoReserved=\'" 
							+ logedInUser.getUserName() + "\' where title=\'" + title + "\'");
			
			st.executeUpdate(sqlUpdate);
			
			String author = null;
			
			String sql = new String("select author from reservedbooks where title=\'" + title + "\'");
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				mv.addObject("title", title);
				mv.addObject("author", rs.getString("author"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	            if (rs != null) {
	                rs.close();
	            }

	            if (st != null) {
	                st.close();
	            }

	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
		}
		
		return mv;
	}
}
