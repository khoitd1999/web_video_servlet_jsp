package com.laptrinhweb.DAO;

import java.util.List;

import com.laptrinhweb.model.VideosModel;

public interface IVideosDAO extends IGenericDAO<VideosModel>{
	List<VideosModel> findAll();
	VideosModel findOne(Long idV);
	List<VideosModel> findByCategory(Long idCate);
	List<VideosModel> findByCategoryAndNumber(Long idCate,Long offset,Long limit);
	Long insert(VideosModel video);
	void update(VideosModel updateVideo);
	void delete(Long idV);
}
