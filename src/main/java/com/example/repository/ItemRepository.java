package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

/**
 * Itemテーブルを操作するrepositoryクラス
 * 
 * @author yuma.watanabe
 *
 */
@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Item> ITEM_ROW_MAPPER = (rs, i) -> {
		Item item = new Item();
		item.setId(rs.getInt("i_id"));
		item.setName(rs.getString("i_name"));
		item.setCondition(rs.getInt("i_condition"));
		item.setCategoryId(rs.getInt("i_category_id"));
		item.setBrand(rs.getString("i_brand"));
		item.setPrice(rs.getDouble("i_price"));
		item.setShipping(rs.getInt("i_shipping"));
		item.setDescription(rs.getString("i_description"));
		item.setBigCategory(rs.getString("c_bigCategory"));
		item.setMiddleCategory(rs.getString("c_middleCategory"));
		item.setSmallCategory(rs.getString("c_smallCategory"));
		item.setNameAll(rs.getString("c_name_all"));
		return item;
	};

	public List<Item> findAllByPage(Integer page) {
		int selectPage = 30 * (page - 1);
		String sql = "SELECT i.id AS i_id,i.name AS i_name,i.condition AS i_condition,i.category_id AS i_category_id,i.brand AS"
				+ " i_brand,i.price AS i_price,i.shipping AS i_shipping,i.description AS i_description,split_part(c.name_all,'/',1) AS c_bigCategory,"
				+ " split_part(c.name_all,'/',2) AS c_middleCategory,split_part(c.name_all,'/',3) AS c_smallCategory,c.name_all AS c_name_all "
				+ "from items i left outer join category c on i.category_id = c.id order by i.id limit 30 offset "
				+ selectPage;
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}

	public List<Item> findByCategory(Integer page, String nameAll) {
		int selectPage = 30 * (page - 1);
		String sql = "SELECT i.id AS i_id,i.name AS i_name,i.condition AS i_condition,i.category_id AS i_category_id,i.brand AS"
				+ " i_brand,i.price AS i_price,i.shipping AS i_shipping,i.description AS i_description,split_part(c.name_all,'/',1) AS c_bigCategory,"
				+ " split_part(c.name_all,'/',2) AS c_middleCategory,split_part(c.name_all,'/',3) AS c_smallCategory,c.name_all AS c_name_all "
				+ "from items i left outer join category c on i.category_id = c.id where c.name_all like :nameAll order by i.id limit 30 offset "
				+ selectPage;
		SqlParameterSource param = new MapSqlParameterSource().addValue("nameAll", nameAll + '%');
		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
		return itemList;

	}

	public Item load(int id) {
		String sql = "SELECT i.id AS i_id,i.name AS i_name,i.condition AS i_condition,i.category_id AS i_category_id,i.brand AS"
				+ " i_brand,i.price AS i_price,i.shipping AS i_shipping,i.description AS i_description,split_part(c.name_all,'/',1) AS c_bigCategory,"
				+ " split_part(c.name_all,'/',2) AS c_middleCategory,split_part(c.name_all,'/',3) AS c_smallCategory,c.name_all AS c_name_all "
				+ " from items i left outer join category c on i.category_id = c.id where i.id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item item = template.queryForObject(sql, param, ITEM_ROW_MAPPER);
		return item;
	}

	public List<Item> findByParentId(int id) {

		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<Item> itemList = template.query(Sql, param, ITEM_ROW_MAPPER);
		return itemList;
	}

}
