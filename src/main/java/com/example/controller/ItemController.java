package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.CategoryForm;
import com.example.form.ItemReceiveForm;
import com.example.service.CategoryService;
import com.example.service.ItemService;

/**
 * Item情報を操作するControllerクラス.
 * 
 * @author yuma.watanabe
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private HttpSession session;

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryService service;

	@ModelAttribute
	public ItemReceiveForm setUpForm() {
		return new ItemReceiveForm();
	}

	@ModelAttribute
	public CategoryForm setUpForm2() {
		return new CategoryForm();
	}

	@RequestMapping("")
	public String showItemList(Model model, Integer page) {
//		Integer nowPage = (Integer) session.getAttribute("nowPage");
//		
//		if (nextOrPre != null) {
//			nowPage = nowPage + nextOrPre;
//		}
		if (page == null) {
			page = 1;
		}
//		if (nowPage > 0) {
//			page = nowPage;
//		}

		List<Category> categoryList = categoryService.findParentCategory();
		model.addAttribute("categoryList", categoryList);
		// List<Item> itemList = null;
		List<Item> itemList = itemService.findAllByPage(page);
//		Page<Item> itemPage =  itemService.showItemPaging(page,VIEW_SIZE,itemList);
//		int totalPages=itemPage.getTotalPages();
//		model.addAttribute("totalPages",totalPages);
//		model.addAttribute("itemPage",itemPage);
//		
//		
//		List<Integer> pageNumbers = calcPageNumbers(model,itemPage);
//		List<Integer> sortNumbers = new ArrayList();
//		for(int i=1;i<=5;i++) {
//			sortNumbers.add(pageNumbers.get(i-1));
//		}
//		model.addAttribute("pageNumbers",sortNumbers);
		session.setAttribute("nowPage", page);
		model.addAttribute("itemList", itemList);
		return "list";

	}

//	private List<Integer> calcPageNumbers(Model model, Page<Item> itemPage) {
//		int totalPages = itemPage.getTotalPages();
//		List<Integer> pageNumbers = null;
//		if (totalPages > 0) {
//			pageNumbers = new ArrayList<Integer>();
//			for (int i = 1; i <= totalPages; i++) {
//				pageNumbers.add(i);
//			}
//		}
//		return pageNumbers;
//	}
	@RequestMapping("/findByCategory")
	public String findByCategory(Model model, Integer page, Integer nextOrPre, String nameAll, CategoryForm form) {
		//ページング機能
		Integer nowPage = (Integer) session.getAttribute("nowPage");
		if (nextOrPre != null) {
			nowPage = nowPage + nextOrPre;
			page = nowPage;
		}
		if (page == null) {
			page = 1;
		}
		//カテゴリー検索
//		if (form.getParentId() == 0) {
//			List<Category> categoryList = service.findChildCategory(form.getId());
//			model.addAttribute("childCategoryList", categoryList);
//		} else if (form.getGrandchildParentId() == 0) {
//			List<Category> categoryList = service.findGrandChild(form.getId(), form.getParentId());
//			model.addAttribute("grandChildCategoryList", categoryList);
//		} else if (form.getGrandchildParentId() != 0 && form.getParentId() != 0 && form.getGrandchildParentId() != 0) {
//			List<Item> itemList = itemService.findByParentId(form.getId(),form.getParentId(),form.getGrandchildParentId());
//			model.addAttribute("itemList", itemList);
//		}
//		List<Category> categoryList1 = service.findParentCategory();
//		model.addAttribute("categoryList", categoryList1);
//		List<Category> categoryList2 = service.findChildCategory(form.getId());
//		model.addAttribute("childCategoryList", categoryList2);
//		List<Category> categoryList3 = service.findGrandChild(form.getId(), form.getParentId());
//		model.addAttribute("grandChildCategoryList", categoryList3);
		
		
//		List<Item> itemList = null;
		//カテゴリー検索（商品一覧から)
		String nameAllForPaging = (String) session.getAttribute("nameAll");
		if (nameAllForPaging != null && nameAll != null) {
			List<Item> itemList = itemService.findByCategory(page, nameAll);
			//プルダウンへの反映
			Category category = new Category();
			List<Category> categoryList = new ArrayList();
			List<Category> childCategoryList = service.findChildCategory(itemList.get(0).getCategoryId());
			category.setName(itemList.get(0).getBigCategory());
			category.setId(itemList.get(0).getCategoryId());
			categoryList.add(category);
			model.addAttribute("categoryList",categoryList);
			model.addAttribute("childCategoryList", childCategoryList);
			model.addAttribute("itemList", itemList);
			session.setAttribute("nowPage", page);
			session.setAttribute("nameAll", nameAll);
			return "list";
		}
		if (nameAllForPaging != null && nameAll == null) {
			List<Item> itemList = itemService.findByCategory(page, nameAllForPaging);
			model.addAttribute("itemList", itemList);
			session.setAttribute("nameAll", nameAllForPaging);
			session.setAttribute("nowPage", page);
			return "list";
		}
		if (nameAllForPaging == null && nameAll != null) {
			List<Item> itemList = itemService.findByCategory(page, nameAll);
			model.addAttribute("itemList", itemList);
			session.setAttribute("nameAll", nameAll);
			session.setAttribute("nowPage", page);
			return "list";
		}
		if (nameAllForPaging == null && nameAll == null) {
			List<Item> itemList = itemService.findAllByPage(page);
			model.addAttribute("itemList", itemList);
			session.setAttribute("nowPage", page);
		}
		return "list";
	}

	@RequestMapping("/showDetail")
	public String showDetail(int id, Model model) {
		Item item = itemService.load(id);
		model.addAttribute("item", item);
		return "detail";
	}

}
