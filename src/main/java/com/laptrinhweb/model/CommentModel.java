package com.laptrinhweb.model;

public class CommentModel extends AbstractModel<CommentModel>{
	private  Long idCom;
	private Long idU;
	private Long idV;
	private String content;
	private String username;
	private String title;
	public Long getIdU() {
		return idU;
	}
	public void setIdU(Long idU) {
		this.idU = idU;
	}
	public Long getIdV() {
		return idV;
	}
	public void setIdV(Long idV) {
		this.idV = idV;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getIdCom() {
		return idCom;
	}
	public void setIdCom(Long idCom) {
		this.idCom = idCom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
