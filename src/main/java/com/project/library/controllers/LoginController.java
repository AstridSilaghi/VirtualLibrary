package com.project.library.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends ControllerBasic {

	Connection conn = null;
	String url = new String("jdbc:mysql://localhost:3306/users");
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String user, @RequestParam("password") String password) throws SQLException
	{
		ModelAndView mv = new ModelAndView();
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			st = conn.createStatement();
			String sql = new String("select * from registeredusers where username='" + user + "' and password='" + password + "'");
			
			rs = null;
			rs = st.executeQuery(sql);
			
			if(rs.next())
			{
				mv.setViewName("homePage");
				mv.setStatus(HttpStatus.OK);
				logedInUser = LogedInUser.getInstance();
				LogedInUser.setUserName(user);
				mv.addObject("username", LogedInUser.getUserName());
			}
			else
			{
				mv.setViewName("loginPageError");
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
