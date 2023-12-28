package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shetuanhuodong;

public interface ShetuanhuodongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shetuanhuodong record);

    int insertSelective(Shetuanhuodong record);

    Shetuanhuodong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shetuanhuodong record);
	
    int updateByPrimaryKey(Shetuanhuodong record);
	public Shetuanhuodong quchongShetuanhuodong(Map<String, Object> shetuanbianhao);
	public List<Shetuanhuodong> getAll(Map<String, Object> map);
	public List<Shetuanhuodong> getsyshetuanhuodong1(Map<String, Object> map);
	public List<Shetuanhuodong> getsyshetuanhuodong3(Map<String, Object> map);
	public List<Shetuanhuodong> getsyshetuanhuodong2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shetuanhuodong> getByPage(Map<String, Object> map);
	public List<Shetuanhuodong> select(Map<String, Object> map);
//	所有List
}

