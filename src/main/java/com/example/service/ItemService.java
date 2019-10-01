package com.example.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * Item情報を操作するServiceクラス.
 * 
 * @author yuma.watanabe
 *
 */
@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public List<Item> findAllByPage(Integer page) {
		return repository.findAllByPage(page);
	}

//	public Page<Item> showItemPaging(int page, int size, List<Item> itemList) {
//		page--;
//
//		int startItemCount = page * size;
//		List<Item> list;
//
//		if (itemList.size() < startItemCount) {
//			list = Collections.emptyList();
//		} else {
//			int toIndex = Math.min(startItemCount + size, itemList.size());
//			list = itemList.subList(startItemCount, toIndex);
//		}
//		Page<Item> itemPage = new PageImpl<Item>(list, PageRequest.of(page, size), itemList.size());
//		return itemPage;
//	}
	public List<Item> findByCategory(Integer page, String nameAll) {
		return repository.findByCategory(page, nameAll);
	}

	public Item load(int id) {
		return repository.load(id);
	}

	public List<Item> findByParentId(int id) {
		return repository.findByParentId(id);
	}

}
