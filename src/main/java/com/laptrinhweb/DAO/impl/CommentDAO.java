package com.laptrinhweb.DAO.impl;

import java.util.List;

import com.laptrinhweb.DAO.ICommentDAO;
import com.laptrinhweb.mapper.CommentMapper;
import com.laptrinhweb.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO{

	public List<CommentModel> findAll() {
		String sql = "select * from comments";
		return query(sql, new CommentMapper());
	}

	public List<CommentModel> findAllByVideo(Long idV) {
		String sql = "select * from comments where idV = ?";
		return query(sql, new CommentMapper(), idV);
	}

	public List<CommentModel> findAllByUser(Long idU) {
		String sql = "select * from comments where idU = ?";
		return query(sql, new CommentMapper(), idU);
	}

	public CommentModel findOne(Long idCom) {
		String sql = "select * from comments where idCom = ?";
		List<CommentModel> comment = query(sql, new CommentMapper(), idCom);
		return comment.isEmpty() ? null : comment.get(0);
	}

	public Long insert(CommentModel comment) {
		StringBuilder sql = new StringBuilder("insert into comments (idV,idU,content,createdDate,createdBy)");
		sql.append(" values(?,?,?,?,?)"); 
		return insert(sql.toString(), comment.getIdV(), comment.getIdU(), comment.getContent()
				,comment.getCreatedDate(),comment.getCreatedBy());
	}

	public void delete(Long idCom) {
		String sql = "delete from comments where idCom = ?";
		update(sql, idCom);
	}

}
