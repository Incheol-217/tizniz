package sec01.ex01;

import java.sql.Date;

public class MemberVO {
	private String ts_id;
	private String ts_pwd;
	private String ts_bdname;
	private String ts_bdno;
	private String ts_phone;
	
	
	public MemberVO(){
		
	}
	public MemberVO(String ts_id, String ts_pwd, String ts_bdname, String ts_bdno, String ts_phone) {
		super();
		this.ts_id = ts_id;
		this.ts_pwd = ts_pwd;
		this.ts_bdname = ts_bdname;
		this.ts_bdno = ts_bdno;
		this.ts_phone = ts_phone;
	}
	public MemberVO(String ts_id, String ts_pwd) {
		super();
		this.ts_id = ts_id;
		this.ts_pwd = ts_pwd;
		
	}


	public String getTs_id() {
		return ts_id;
	}


	public void setTs_id(String ts_id) {
		this.ts_id = ts_id;
	}


	public String getTs_pwd() {
		return ts_pwd;
	}


	public void setTs_pwd(String ts_pwd) {
		this.ts_pwd = ts_pwd;
	}


	public String getTs_bdname() {
		return ts_bdname;
	}


	public void setTs_bdname(String ts_bdname) {
		this.ts_bdname = ts_bdname;
	}


	public String getTs_bdno() {
		return ts_bdno;
	}


	public void setTs_bdno(String ts_bdno) {
		this.ts_bdno = ts_bdno;
	}


	public String getTs_phone() {
		return ts_phone;
	}


	public void setTs_phone(String ts_phone) {
		this.ts_phone = ts_phone;
	}
	
	
	
}
	
	