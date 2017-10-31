package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.JobApplied;



public interface JobAppliedDAO 
{
	
	public boolean applyNew(JobApplied jobApplied);
	
	public List<JobApplied> listByUser(String username);
	
	public List<JobApplied> listByCompany();
	
}
