package com.example.repository;

import com.example.domain.FoodPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodPriceJdbcRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	/*
	private static final RowMapper<FoodPrice> foodRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		Integer price = rs.getInt("price");
		return new FoodPrice(id, name, price);
	};

	public List<FoodPrice> findAll() {
		List<FoodPrice> foods = jdbcTemplate.query("SELECT id, name, price FROM foodprice ORDER BY id", foodRowMapper);
		return foods;
	}

	public FoodPrice findOne(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return jdbcTemplate.queryForObject("SELECT id, name, price FROM foodprice WHERE id=:id", param, foodRowMapper);
	}

	public FoodPrice save(FoodPrice food) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(food);
		if (food.getId() == 0) {
			jdbcTemplate.update("INSERT INTO foodprice(name, price) values(:name, :price)", param);
		} else {
			jdbcTemplate.update("UPDATE foodprice SET name=:name, price=:price WHERE id=:id", param);
		}
		return food;
	}

	public void rollbacktest() {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", 10);
		jdbcTemplate.update("UPDATE foodprice SET name=:name, price=99 WHERE id=:id", param);
	}

	public void delete(Integer id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		jdbcTemplate.update("DELETE FROM foodprice WHERE id=:id", param);
	}
	*/

}
