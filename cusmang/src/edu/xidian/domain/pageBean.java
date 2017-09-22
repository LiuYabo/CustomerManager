package edu.xidian.domain;

import java.util.List;

public class pageBean {

	private List list;
	private int totalRecord;
	private int pageSize;
	private int totalPage;
	private int currentPage;
	private int previousPage;
	private int nextPage;
//	private int[] pagebar = new int[this.totalPage];
	
	
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return this.totalPage;
	}
	public void setTotalPage() {
		this.totalPage = (int) Math.ceil((double)totalRecord/(double)pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPreviousPage() {
		if (currentPage > 1) {
			return currentPage-1;
		} else {
			return currentPage;
		}
	}
	
	public int getNextPage() {
		System.out.println(this.totalPage+"total");
		System.out.println(this.currentPage+"cur");
		if (this.currentPage == this.totalPage) {
			return currentPage;
		} else {
			return currentPage + 1;
		}

	}
	
	
	/*public void setPagebar() {
		for (int i = 0; i < pagebar.length; i++) {
			this.pagebar[i] = i + 1;
		}
	}
	public int[] getPagebar() {
		return this.pagebar;
	}*/
	
}
