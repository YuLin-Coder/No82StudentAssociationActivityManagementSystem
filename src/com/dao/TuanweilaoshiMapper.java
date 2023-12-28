package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tuanweilaoshi;

public interface TuanweilaoshiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tuanweilaoshi record);

    int insertSelective(Tuanweilaoshi record);

    Tuanweilaoshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuanweilaoshi record);
	
    int updateByPrimaryKey(Tuanweilaoshi record);
	public Tuanweilaoshi quchongTuanweilaoshi(Map<String, Object> bianhao);
	public List<Tuanweilaoshi> getAll(Map<String, Object> map);
	public List<Tuanweilaoshi> getsytuanweilaoshi1(Map<String, Object> map);
	public List<Tuanweilaoshi> getsytuanweilaoshi3(Map<String, Object> map);
	public List<Tuanweilaoshi> getsytuanweilaoshi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tuanweilaoshi> getByPage(Map<String, Object> map);
	public List<Tuanweilaoshi> select(Map<String, Object> map);
//	所有List
}

