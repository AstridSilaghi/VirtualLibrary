package com.project.library.controllers;

public class LogedInUser {

	static LogedInUser logedInUser = null;
	private String userName = null; 
	
	private LogedInUser() {};
	
	public static LogedInUser getInstance() 
	{	
		System.out.println("get instance 1");
		if  (logedInUser == null)
		{
			synchronized (LogedInUser.class) {
				logedInUser = new LogedInUser();
			}
		}
		
		return logedInUser;
	}
	public static String getUserName()
	{
		return logedInUser.userName;
	}


	public static void setUserName(String userName) {
		if(logedInUser != null)
		{
			logedInUser.userName = userName;
		}
	}
}
