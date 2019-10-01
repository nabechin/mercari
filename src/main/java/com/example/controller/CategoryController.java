package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.CategoryForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@Autowired
	private ItemService itemService;

	@ModelAttribute
	public CategoryForm setUpForm() {
		return new CategoryForm();
	}

	@RequestMapping("/findChildCategory")
	public String findByParentId(CategoryForm form, Model model) {
		if (form.getParentId() == 0) {
			List<Category> categoryList = service.findChildCategory(form.getId());
			List<Item> itemList = itemService.findByParentId(form.getId());
			model.addAttribute("itemList", itemList);
			model.addAttribute("childCategoryList", categoryList);
		} else if (form.getGrandchildParentId() == 0) {
			List<Category> categoryList = service.findGrandChild(form.getId(), form.getParentId());
			model.addAttribute("grandChildCategoryList", categoryList);
		} else if (form.getGrandchildParentId() != 0 && form.getParentId() != 0 && form.getGrandchildParentId() != 0) {
			System.out.println(form);
		}
		List<Category> categoryList1 = service.findParentCategory();
		model.addAttribute("categoryList", categoryList1);
		List<Category> categoryList2 = service.findChildCategory(form.getId());
		model.addAttribute("childCategoryList", categoryList2);
		List<Category> categoryList3 = service.findGrandChild(form.getId(), form.getParentId());
		model.addAttribute("grandChildCategoryList", categoryList3);
		return "list";

	}
}
