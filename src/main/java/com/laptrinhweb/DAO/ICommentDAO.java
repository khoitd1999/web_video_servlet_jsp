package com.laptrinhweb.DAO;

import java.util.List;

import com.laptrinhweb.model.CommentModel;

public interface ICommentDAO extends IGenericDAO<CommentModel>{
	List<CommentModel> findAll();
	List<CommentModel> findAllByVideo(Long idV);
	List<CommentModel> findAllByUser(Long idU);
	CommentModel findOne(Long idCom);
	Long insert(CommentModel commet);
	void delete(Long idCom);
}
