package com.laptrinhweb.Service;

import java.util.List;

import com.laptrinhweb.model.VideosModel;

public interface IVideoService {
	List<VideosModel> findAll();
	List<VideosModel> findByCategory(Long idCate);
	List<VideosModel> findByCategoryAndNumber(Long idCate,Long offset,Long limit);
	VideosModel findOne(Long idV);
	VideosModel insert(VideosModel video);
	VideosModel update(VideosModel updateVideo);
	void delete(Long[] ids);
}
