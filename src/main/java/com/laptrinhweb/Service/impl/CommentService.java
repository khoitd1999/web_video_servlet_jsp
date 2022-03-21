package com.laptrinhweb.Service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.DAO.ICommentDAO;
import com.laptrinhweb.Service.ICommentService;
import com.laptrinhweb.model.CommentModel;

public class CommentService implements ICommentService{
	
	@Inject
	private ICommentDAO commentDAO;
	
	public List<CommentModel> findAll() {
		return commentDAO.findAll();
	}

	public List<CommentModel> findAllByVideo(Long idV) {
		return commentDAO.findAllByVideo(idV);
	}

	public List<CommentModel> findAllByUser(Long idU) {
		return commentDAO.findAllByUser(idU);
	}

	public CommentModel findOne(Long idCom) {
		return commentDAO.findOne(idCom);
	}

	public CommentModel insert(CommentModel comment) {
		Long idCom = commentDAO.insert(comment);
		return commentDAO.findOne(idCom);
	}

	public void delete(Long[] idCom) {
		for(Long idC : idCom)
			commentDAO.delete(idC);
	}

}
