package com.niit.discussionB.restControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.discussionB.dao.ForumDAO;
import com.niit.discussionB.model.Forum;
import com.niit.discussionB.model.JoinForum;
import com.niit.discussionB.util.Date_Time;


@RestController
public class ForumController 
{

	private static final Logger log = LoggerFactory.getLogger(ForumController.class);
	
	@Autowired
	private ForumDAO forumDAO;
	
	@Autowired
	private Forum forum;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping("/addForum")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum)
	{
		if(session.getAttribute("username")==null)
		{
			log.info("NOT LOGGED IN");
			return null;
		}
		else
		{
			log.info("Add forum");
			forum.setUsername(session.getAttribute("username").toString());
			Date_Time dt = new Date_Time();
			forum.setDate_time(dt.getDateTime());
			forum.setStatus('P');
			boolean value = forumDAO.addForum(forum);
			if(value)
			{
				forum.setErrorCode("200");
				forum.setErrorMessage("Forum added");
			}
			else
			{
				forum.setErrorCode("404");
				forum.setErrorMessage("Forum not added");
				log.error("Add Forum error");
				return null;
			}
			log.info("Add forum success");
			return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		}
	}
	
	@PostMapping("/updateForum")
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum)
	{
		if(session.getAttribute("username")==null)
		{
			log.info("NOT LOGGED IN");
			return null;
		}
		else
		{
			log.info("Updating Forum");
			boolean value = forumDAO.updateForum(forum);
			if(value)
			{
				forum.setErrorCode("200");
				forum.setErrorMessage("Forum updated");
			}
			else
			{
				forum.setErrorCode("404");
				forum.setErrorMessage("Forum not updated");
				log.error("Updating Forum Error");
				return null;
			}
			log.info("Update Forum Success");
			return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		}	
	}
	
	@GetMapping("/deleteForum-{id}")
	public ResponseEntity<Forum> deleteForum(@PathVariable ("id") int id)
	{
		if(session.getAttribute("username")==null)
		{
			log.info("NOT LOGGED IN");
			return null;
		}
		else
		{
			boolean value = forumDAO.deleteForum(id);
			if(value)
			{
				forum = new Forum();
				forum.setErrorCode("200");
				forum.setErrorMessage("Forum Deleted");
			}
			else
			{
				log.error("Delete Forum error");
				return null;
			}
			log.info("Forum has been deleted");
			return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getForum-{id}")
	public ResponseEntity<Forum> getForum(@PathVariable ("id") int id)
	{
		if(session.getAttribute("username")==null)
		{
			log.info("NOT LOGGED IN");
			return null;
		}
		else
		{
			forum = forumDAO.getForum(id);
			if(forum==null)
			{
				log.error("Forum not found");
				return null;
			}
			else
			{
				log.info("Forum has been found");
				return new ResponseEntity<Forum>(forum, HttpStatus.OK);
			}
		}
	}
	@GetMapping("/joinForum-{id}")
	public ResponseEntity<Forum> joinForum(@PathVariable ("id") int id)
	{
		System.out.println("Form Controller I back End"+id);
		if(session.getAttribute("username")==null)
		{
			System.out.println("No Current Session..");
			log.info("NOT LOGGED IN");
			return null;
		}
		else
		{
			forum = forumDAO.getForum(id);
			String partti=(String)session.getAttribute("username");
			if(forum==null)
			{
				log.error("Forum not found");
				return null;
			}
			else
			{
				log.info("Forum has been found");
				JoinForum jf=new JoinForum();
				jf.setForum_id(id);
				jf.setForum_title(forum.getForum_id());
				jf.setForum_desc(forum.getDescription());
				jf.setParticipate_id(partti);
				jf.setUsername(forum.getUsername());
				jf.setStatus("P");
				forumDAO.joinForum(jf);
				return new ResponseEntity<Forum>(forum, HttpStatus.OK);
			}
		}
	}
	
	@GetMapping("/viewMyForums")
	public ResponseEntity<List<Forum>> getMyForums()
	{
		if(session.getAttribute("username")==null)
		{
			log.info("NOT LOGGED IN");
			return null;
		}
		else
		{
			String username = session.getAttribute("username").toString();
			List<Forum> list = forumDAO.getUserForums(username);
			if(list.isEmpty() || list == null)
			{
				log.error("No Forums Found");
				return null;
			}
			else
			{
				log.info("Forums have been retrieved");
				return new ResponseEntity<List<Forum>>(list, HttpStatus.OK);
			}
		}
	}

	
	@GetMapping("/viewApprovedForums")
	public ResponseEntity<List<Forum>> getApprovedForums()
	{
		List<Forum> list = forumDAO.approvedForums();
		if(list.isEmpty() || list == null)
		{
			log.error("No Approved Forums Found");
			return null;
		}
		else
		{
			log.info("Forums have been retrieved");
			return new ResponseEntity<List<Forum>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewAllForums")
	public ResponseEntity<List<Forum>> getAllForums()
	{
		System.out.println("__________________In Get All Forums____________");
		List<Forum> list = forumDAO.getForumList();
		if(list.isEmpty() || list == null)
		{
			log.error("No Forums Found");
			return null;
		}
		else
		{
			log.info("Forums list retrieved");
			return new ResponseEntity<List<Forum>>(list, HttpStatus.OK);
		}
	}
	@GetMapping("/viewAllJoinForums")
	public ResponseEntity<List<JoinForum>> getAllJoinForums()
	{
		System.out.println("__________________In Get All Join Forums____________");
		List<JoinForum> list = forumDAO.getJoinForumList();
		if(list.isEmpty() || list == null)
		{
			log.error("No Forums Found");
			return null;
		}
		else
		{
			log.info("Forums list retrieved");
			return new ResponseEntity<List<JoinForum>>(list, HttpStatus.OK);
		}
	}
}
