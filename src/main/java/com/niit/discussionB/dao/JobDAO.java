package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.Job;



public interface JobDAO 
{
	
	public boolean addJob(Job job);
	
	public Job getJob(String name);
	
	public List<Job> listJobs();
	
	public boolean deleteJob(int job_id);
	
	public boolean invalidateJob(int job_id);
	
}
