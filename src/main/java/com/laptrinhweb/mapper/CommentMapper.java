package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.CommentModel;

public class CommentMapper implements RowMapper<CommentModel>{

	public CommentModel mapper(ResultSet rs) {
		CommentModel comment = new CommentModel();
		try {
			comment.setIdCom(rs.getLong("idCom"));
			comment.setIdV(rs.getLong("idV"));
			comment.setIdU(rs.getLong("idU"));
			comment.setContent(rs.getString("content"));
			comment.setCreatedDate(rs.getDate("createdDate"));
			comment.setCreatedBy(rs.getString("createdBy"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment;
	}

}
