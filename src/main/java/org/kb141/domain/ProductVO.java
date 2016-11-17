package org.kb141.domain;

import java.util.Date;

public class ProductVO {

	private Integer pno;
	private String pname, pmaker, pimage;
	private Date regdate, updatedate;
	
	public ProductVO(String pname, String pmaker, String pimage) {
		super();
		this.pname = pname;
		this.pmaker = pmaker;
		this.pimage = pimage;
	}

	
	public ProductVO() {
		super();
	}


	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", pmaker=" + pmaker + ", pimage=" + pimage + ", regdate="
				+ regdate + ", updatedate=" + updatedate + "]";
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPmaker() {
		return pmaker;
	}

	public void setPmaker(String pmaker) {
		this.pmaker = pmaker;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	
	
	
}
