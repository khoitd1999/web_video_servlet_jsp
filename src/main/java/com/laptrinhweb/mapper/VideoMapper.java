package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.VideosModel;

public class VideoMapper implements RowMapper<VideosModel>{

	public VideosModel mapper(ResultSet rs) {
		VideosModel video = new VideosModel();
		try {
			video.setIdV(rs.getLong("idV"));
			video.setTitle(rs.getString("title"));
			video.setContent(rs.getString("content"));
			video.setShortdescription(rs.getString("shortdescription"));
			video.setCreatedDate(rs.getDate("createdDate"));
			video.setCreatedBy(rs.getString("createdBy"));
			video.setIdCate(rs.getLong("idCate"));
			video.setThumbnail(rs.getString("thumbnail"));
			return video;
		} catch (SQLException e) {
			return null;
		}
	}

}
