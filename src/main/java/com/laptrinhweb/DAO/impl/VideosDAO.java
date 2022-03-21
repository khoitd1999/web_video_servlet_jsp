package com.laptrinhweb.DAO.impl;

import java.util.List;

import com.laptrinhweb.DAO.IVideosDAO;
import com.laptrinhweb.mapper.VideoMapper;
import com.laptrinhweb.model.VideosModel;

public class VideosDAO extends AbstractDAO<VideosModel> implements IVideosDAO{

	public List<VideosModel> findAll() {
		String sql = "Select * from videos";
		return query(sql, new VideoMapper());
	}

	public VideosModel findOne(Long idV) {
		String sql = "select * from videos where idV = ?";
		List<VideosModel> video = query(sql, new VideoMapper(), idV);
		return video.isEmpty() ? null : video.get(0);
	}

	public List<VideosModel> findByCategory(Long idCate) {
		String sql = "select * from videos where idCate = ?";
		return query(sql, new VideoMapper(), idCate);
	}

	public Long insert(VideosModel video) {
		StringBuilder sql = new StringBuilder("insert into videos (title,content,createdDate,createdBy,idCate,shortdescription,thumbnail)");
		sql.append(" values(?,?,?,?,?,?,?)");
		return insert(sql.toString(), video.getTitle(),video.getContent(),video.getCreatedDate()
				,video.getCreatedBy(),video.getIdCate(),video.getShortdescription(),video.getThumbnail());
	}

	public void update(VideosModel updateVideo) {
		StringBuilder sql = new StringBuilder("update videos set ");
		sql.append(" title = ?, content = ?, idCate = ?, shortdescription = ?,thumbnail = ?");
		sql.append(" where idV = ?");
		update(sql.toString(), updateVideo.getTitle(),updateVideo.getContent()
				,updateVideo.getIdCate(),updateVideo.getShortdescription(),updateVideo.getThumbnail(),
				updateVideo.getIdV());
	}

	public void delete(Long idV) {
		String sql = "Delete from videos where idV = ?";
		update(sql, idV);
	}

	public List<VideosModel> findByCategoryAndNumber(Long idCate, Long offset, Long limit) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from videos where idCate = "+idCate+" limit "+offset+","+limit);
		return query(sql.toString(), new VideoMapper());
	}
}
