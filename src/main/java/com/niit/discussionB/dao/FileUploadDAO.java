package com.niit.discussionB.dao;

import com.niit.discussionB.model.FileUpload;

public interface FileUploadDAO 
{
	public void save(FileUpload fileUpload, String username);
	public FileUpload getFile(String username);
}