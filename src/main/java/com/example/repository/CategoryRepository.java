package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Category;

/**
 * Categoryテーブルを操作するRepositoryクラス.
 * 
 * @author yuma.watanabe
 *
 */
@Repository
public class CategoryRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Category> CATEGORY_ROW_MAPPER = (rs, i) -> {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setParent(rs.getInt("parent"));
		category.setName(rs.getString("name"));
		category.setNameAll(rs.getString("name_all"));
		return category;
	};

	public Category findByParent(int parent) {
		String sql = "SELECT id,patent,name,name_all from category WHERE parent =:parent";
		SqlParameterSource param = new MapSqlParameterSource().addValue("parent", parent);
		Category category = template.queryForObject(sql, param, CATEGORY_ROW_MAPPER);
		return category;
	}

	public List<Category> findParentCategory() {
		String Sql = "SELECT id,parent,name,name_all from category where parent is null";
		List<Category> categoryList = template.query(Sql, CATEGORY_ROW_MAPPER);
		return categoryList;
	}

	public List<Category> findChildCategory(Integer parent) {
		String Sql = "SELECT id,parent,name,name_all from category where parent = :parent";
		SqlParameterSource param = new MapSqlParameterSource().addValue("parent", parent);
		List<Category> categoryList = template.query(Sql, param, CATEGORY_ROW_MAPPER);
		return categoryList;
	}

	public List<Category> findGrandChild(int parent, int childParent) {
		String Sql = "select id,parent,name,name_all from category where parent in "
				+ "(select :childParent from category where parent in "
				+ "(select id from category where id = :parent))";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("parent",parent).addValue("childParent", childParent);
		List<Category> categoryList = template.query(Sql, param, CATEGORY_ROW_MAPPER);
		return categoryList;
	}

}
