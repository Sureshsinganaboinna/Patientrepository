package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class TracingUserActionsService {
	
	
	
	
	public void addPageVisit(HttpSession session, String pageName)
	{
		
		 @SuppressWarnings("unchecked")
		List<String>  pageVisites =( List<String>  ) session.getAttribute("pageVisitese");
		 
		
		if(pageVisites == null)
		{
			pageVisites = new ArrayList<>();
			session.setAttribute("pageVisitese", pageVisites);
		}
		pageVisites.add(pageName);
		
	}
	
	
	public List<String> getPageVisits(HttpSession session)
	{
		
		@SuppressWarnings("unchecked")
		List<String>  pageVisites =( List<String>  ) session.getAttribute("pageVisitese");
		
		return (pageVisites!=null) ? pageVisites : new ArrayList<>();
		
	}

}
