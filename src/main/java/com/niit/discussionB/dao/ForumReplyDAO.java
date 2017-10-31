package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.ForumReply;



public interface ForumReplyDAO 
{

	public boolean addReply(ForumReply reply);
	
	public boolean deleteReply(ForumReply reply);
	
	public ForumReply getReply(int id);
	
	public List<ForumReply> getForumReply(int forum_id);
}
