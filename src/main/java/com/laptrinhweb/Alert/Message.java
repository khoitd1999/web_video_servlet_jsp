package com.laptrinhweb.Alert;

public class Message {
	private String message;
	
	public Message(String message) {
		if(message.equals("login_invalid")) {
			this.message = "Username or password wrong";
		}else if(message.equals("not_permission")) {
			this.message = "NOT permission";
		}else if(message.equals("insert_fail"))
			this.message = "Thêm không thành công";
		else if(message.equals("insert_success"))
			this.message = "Thêm thành công";
		else if(message.equals("edit_fail"))
			this.message = "Sửa không thành công";
		else if(message.equals("edit_success"))
			this.message = "Sửa thành công";
		else if(message.equals("delete_fail"))
			this.message = "Xóa không thành công";
		else if(message.equals("delete_success"))
			this.message = "Xóa thành công";
		else if(message.equals("not_login"))
			this.message = "Cần đăng nhập tài khoản để bình luận";
		else if(message.equals("not_comment"))
			this.message = "Không thể comment được";
		else if(message.equals("lack_of_info"))
			this.message = "Điền thiếu thông tin";
		else if(message.equals("not_equal"))
			this.message = "Nhập lại mật khẩu sai";
		else if(message.equals("not_account"))
			this.message = "Lỗi đăng kí hoặc đã có tài khoản trên.Mời đăng kí lại";
		else if(message.equals("register_OK"))
			this.message = "Đăng kí thành công";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
