package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Tuituanshenqing;

public interface TuituanshenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tuituanshenqing record);

    int insertSelective(Tuituanshenqing record);

    Tuituanshenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuituanshenqing record);
	
    int updateByPrimaryKey(Tuituanshenqing record);
	public Tuituanshenqing quchongTuituanshenqing(Map<String, Object> xuehao);
	public List<Tuituanshenqing> getAll(Map<String, Object> map);
	public List<Tuituanshenqing> getsytuituanshenqing1(Map<String, Object> map);
	public List<Tuituanshenqing> getsytuituanshenqing3(Map<String, Object> map);
	public List<Tuituanshenqing> getsytuituanshenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Tuituanshenqing> getByPage(Map<String, Object> map);
	public List<Tuituanshenqing> select(Map<String, Object> map);
//	所有List
}

