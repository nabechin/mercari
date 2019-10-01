package com.example.domain;

/**
 * Item情報を表すDomainクラス.
 * 
 * @author yuma.watanabe
 *
 */
public class Item {
	private Integer id;
	private String name;
	private Integer condition;
	private Integer categoryId;
	private String brand;
	private double price;
	private Integer shipping;
	private String description;
	private String bigCategory;
	private String middleCategory;
	private String smallCategory;
	private String nameAll;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getShipping() {
		return shipping;
	}

	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBigCategory() {
		return bigCategory;
	}

	public void setBigCategory(String bigCategory) {
		this.bigCategory = bigCategory;
	}

	public String getMiddleCategory() {
		return middleCategory;
	}

	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}

	public String getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}

	public String getNameAll() {
		return nameAll;
	}

	public void setNameAll(String nameAll) {
		this.nameAll = nameAll;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", condition=" + condition + ", categoryId=" + categoryId
				+ ", brand=" + brand + ", price=" + price + ", shipping=" + shipping + ", description=" + description
				+ ", bigCategory=" + bigCategory + ", middleCategory=" + middleCategory + ", smallCategory="
				+ smallCategory + ", nameAll=" + nameAll + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getCondition()=" + getCondition() + ", getCategoryId()=" + getCategoryId() + ", getBrand()="
				+ getBrand() + ", getPrice()=" + getPrice() + ", getShipping()=" + getShipping() + ", getDescription()="
				+ getDescription() + ", getBigCategory()=" + getBigCategory() + ", getMiddleCategory()="
				+ getMiddleCategory() + ", getSmallCategory()=" + getSmallCategory() + ", getNameAll()=" + getNameAll()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
