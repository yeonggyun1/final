package net.edupoll.kr.entity;

import java.util.Date;

public class FreeBoardVo {
	int no;
	String writer;
	String pass;
	String title;
	String content;
	Date writedate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "FreeBoardVo [no=" + no + ", writer=" + writer + ", pass=" + pass + ", title=" + title + ", content="
				+ content + ", writedate=" + writedate + "]";
	}

}
