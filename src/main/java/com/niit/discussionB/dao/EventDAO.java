package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.Event;


public interface EventDAO
{
	public boolean addEvent(Event event);
	
	public boolean deleteEvent(int id);
	
	public Event getEvent(int id);
	
	public List<Event> listEvent();
	
}
