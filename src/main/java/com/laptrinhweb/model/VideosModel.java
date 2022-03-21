package com.laptrinhweb.model;

public class VideosModel extends AbstractModel<VideosModel>{
	private Long idV;
	private String title;
	private String content;
	private String shortdescription;
	private Long idCate;
	private String thumbnail;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public Long getIdCate() {
		return idCate;
	}
	public void setIdCate(Long idCate) {
		this.idCate = idCate;
	}
	public Long getIdV() {
		return idV;
	}
	public void setIdV(Long idV) {
		this.idV = idV;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
