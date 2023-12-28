package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shenqingrutuan;

public interface ShenqingrutuanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shenqingrutuan record);

    int insertSelective(Shenqingrutuan record);

    Shenqingrutuan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shenqingrutuan record);
	
    int updateByPrimaryKey(Shenqingrutuan record);
	public Shenqingrutuan quchongShenqingrutuan(Map<String, Object> xuehao);
	public List<Shenqingrutuan> getAll(Map<String, Object> map);
	public List<Shenqingrutuan> getsyshenqingrutuan1(Map<String, Object> map);
	public List<Shenqingrutuan> getsyshenqingrutuan3(Map<String, Object> map);
	public List<Shenqingrutuan> getsyshenqingrutuan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shenqingrutuan> getByPage(Map<String, Object> map);
	public List<Shenqingrutuan> select(Map<String, Object> map);
//	所有List
}

