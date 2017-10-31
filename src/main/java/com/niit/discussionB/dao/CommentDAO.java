package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.BlogComment;



public interface CommentDAO
{
	
	public boolean addBlogComment(BlogComment blogComment);

	public boolean deleteComment(int id);
	
	public List<BlogComment> getBlogComments(String blog_id);
}