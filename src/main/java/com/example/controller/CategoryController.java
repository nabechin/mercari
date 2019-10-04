package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.SearchForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private HttpSession session;

	@ModelAttribute
	public SearchForm setUpForm() {
		return new SearchForm();
	}

	@RequestMapping("/search")
	public String search(SearchForm searchForm, Model model) {

        List<Category> chuCategoryList = null;
        List<Category> syoCategoryList = null;
		// で？カテゴリーは何を返せばいい？
		//  ⇒　指定されたカテゴリの子供のカテゴリーまで検索すればOK
		if (searchForm.getDaiCategoryId() != null) {
			chuCategoryList = categoryService.findChildCategory(searchForm.getDaiCategoryId());
		}
		if (searchForm.getChuCategoryId() != null) {
			syoCategoryList = categoryService.findChildCategory(searchForm.getChuCategoryId());
		}
		// 商品
		if (searchForm.getAction().equals("item")) {
			List<Item> itemList = itemService.search(searchForm);
			session.setAttribute("itemList", itemList);
		}
		model.addAttribute("chuCategoryList", chuCategoryList);
        model.addAttribute("syoCategoryList", syoCategoryList);
		return "list";

	}
}
