package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shetuanxinxi;

public interface ShetuanxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shetuanxinxi record);

    int insertSelective(Shetuanxinxi record);

    Shetuanxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shetuanxinxi record);
	
    int updateByPrimaryKey(Shetuanxinxi record);
	public Shetuanxinxi quchongShetuanxinxi(Map<String, Object> shetuanbianhao);
	public List<Shetuanxinxi> getAll(Map<String, Object> map);
	public List<Shetuanxinxi> getsyshetuanxinxi1(Map<String, Object> map);
	public List<Shetuanxinxi> getsyshetuanxinxi3(Map<String, Object> map);
	public List<Shetuanxinxi> getsyshetuanxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shetuanxinxi> getByPage(Map<String, Object> map);
	public List<Shetuanxinxi> select(Map<String, Object> map);
//	所有List
}

