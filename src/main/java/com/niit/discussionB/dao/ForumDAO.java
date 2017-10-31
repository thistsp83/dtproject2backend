package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.Forum;
import com.niit.discussionB.model.JoinForum;



public interface ForumDAO
{

	public boolean addForum(Forum forum);
	
	public boolean joinForum(JoinForum forum);
	
	public boolean deleteForum(int id);
	
	public boolean updateForum(Forum forum);
	
	public Forum getForum(int id);
	
	public List<Forum> getUserForums(String username);
	
	public List<Forum> getForumList();
	
	public List<Forum> approvedForums();

	public List<JoinForum> getJoinForumList();
}
