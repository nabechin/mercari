package com.example.form;

public class CategoryForm {

	private int id;

	private int parentId;

	private int grandchildParentId;

	private String nameAll;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameAll() {
		return nameAll;
	}

	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getGrandchildParentId() {
		return grandchildParentId;
	}

	public void setGrandchildParentId(int grandchildParentId) {
		this.grandchildParentId = grandchildParentId;
	}

}
