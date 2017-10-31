package com.niit.discussionB.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_JoinForum")
@Component
public class JoinForum extends BaseDomain 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int join_id;
	private String username;
	private int forum_id;
	private String forum_title;
	@Lob
	private String forum_desc;
    private String participate_id;
    private String status;
	public int getJoin_id() {
		return join_id;
	}
	public void setJoin_id(int join_id) {
		this.join_id = join_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getForum_id() {
		return forum_id;
	}
	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_title() {
		return forum_title;
	}
	public void setForum_title(String forum_title) {
		this.forum_title = forum_title;
	}
	public String getForum_desc() {
		return forum_desc;
	}
	public void setForum_desc(String forum_desc) {
		this.forum_desc = forum_desc;
	}
	public String getParticipate_id() {
		return participate_id;
	}
	public void setParticipate_id(String participate_id) {
		this.participate_id = participate_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    

}
