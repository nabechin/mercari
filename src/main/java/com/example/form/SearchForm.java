package com.example.form;

public class SearchForm {

    private Integer daiCategoryId;
    private Integer chuCategoryId;
    private Integer syoCategoryId;
    private String nameAll;
    private String itemKeyword;
    private String brand;
    private Integer page;

    private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getDaiCategoryId() {
		return daiCategoryId;
	}

	public void setDaiCategoryId(Integer daiCategoryId) {
		this.daiCategoryId = daiCategoryId;
	}

	public Integer getChuCategoryId() {
		return chuCategoryId;
	}

	public void setChuCategoryId(Integer chuCategoryId) {
		this.chuCategoryId = chuCategoryId;
	}

	public Integer getSyoCategoryId() {
		return syoCategoryId;
	}

	public void setSyoCategoryId(Integer syoCategoryId) {
		this.syoCategoryId = syoCategoryId;
	}

	public String getNameAll() {
		return nameAll;
	}

	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}

	public String getItemKeyword() {
		return itemKeyword;
	}

	public void setItemKeyword(String itemKeyword) {
		this.itemKeyword = itemKeyword;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

}
