package com.laptrinhweb.Service.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.DAO.IVideosDAO;
import com.laptrinhweb.Service.IVideoService;
import com.laptrinhweb.model.VideosModel;

public class VideoService  implements IVideoService{

	@Inject
	private IVideosDAO videosDao;
	
	public List<VideosModel> findAll() {
		return videosDao.findAll();
	}

	public List<VideosModel> findByCategory(Long idCate) {
		return videosDao.findByCategory(idCate);
	}

	public VideosModel findOne(Long idV) {
		return videosDao.findOne(idV);
	}

	public VideosModel insert(VideosModel video) {
		video.setCreatedDate(new Date(System.currentTimeMillis()));
		Long idV = videosDao.insert(video);
		return videosDao.findOne(idV);
	}

	public VideosModel update(VideosModel updateVideo) {
		videosDao.update(updateVideo);
		return videosDao.findOne(updateVideo.getIdV());
	}

	public void delete(Long[] ids) {
		for(Long id : ids) {
			videosDao.delete(id);
		}
	}

	public List<VideosModel> findByCategoryAndNumber(Long idCate, Long offset, Long limit) {
		return videosDao.findByCategoryAndNumber(idCate, offset, limit);
	}
	
}
