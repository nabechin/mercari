package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findParentCategory() {
		return repository.findParentCategory();
	}

	public List<Category> findChildCategory(int parent) {
		return repository.findChildCategory(parent);
	}

	public List<Category> findGrandChild(int parent, int childParent) {
		return repository.findGrandChild(parent, childParent);
	}
}
