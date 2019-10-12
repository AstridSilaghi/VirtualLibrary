package com.project.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.*;


@Controller
public class SearchController extends ControllerBasic{

	static String bookTitle;
	
 
	public static String getBookTitle() {
		return bookTitle;
	}

	public static void setBookTitle(String bookTitle) {
		SearchController.bookTitle = bookTitle;
	}


	@RequestMapping("/searchBook")
	public ModelAndView searchTitle(@RequestParam("title") String title)
	{
		ModelAndView mv = new ModelAndView();
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		
		mv.setViewName("searchBookResult");
		mv.addObject("username", logedInUser.getUserName());
		
		System.out.println("in search controller: user = " + logedInUser.getUserName());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
			
			st = conn.createStatement();
			String sql = new String("select * from reservedbooks where title=\'" + title + "\'");
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				 Boolean isReserved = Boolean.valueOf(rs.getBoolean("isReserved"));
				 mv.addObject("title", title);
				 searchTitle(title);
				 mv.addObject("author", rs.getString("author"));
				 mv.addObject("status", "lala");
				 
				 if(isReserved == Boolean.FALSE)
				 {
					 mv.addObject("status", "is free");
				 }
				 else
				 {
					 mv.addObject("status", "is reserved for the moment");
				 }
			}
			
		} catch (Exception e) {
			System.out.println(e);
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
