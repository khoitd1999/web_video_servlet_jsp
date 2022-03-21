package com.laptrinhweb.Service;

import java.util.List;

import com.laptrinhweb.model.CommentModel;

public interface ICommentService {
	List<CommentModel> findAll();
	List<CommentModel> findAllByVideo(Long idV);
	List<CommentModel> findAllByUser(Long idU);
	CommentModel findOne(Long idCom);
	CommentModel insert(CommentModel comment);
	void delete(Long[] idCom);
}
