package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TuanweilaoshiMapper;
import com.entity.Tuanweilaoshi;
import com.server.TuanweilaoshiServer;
@Service
public class TuanweilaoshiServerImpi implements TuanweilaoshiServer {
   @Resource
   private TuanweilaoshiMapper gdao;
	@Override
	public int add(Tuanweilaoshi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tuanweilaoshi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tuanweilaoshi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tuanweilaoshi> getsytuanweilaoshi1(Map<String, Object> map) {
		return gdao.getsytuanweilaoshi1(map);
	}
	public List<Tuanweilaoshi> getsytuanweilaoshi2(Map<String, Object> map) {
		return gdao.getsytuanweilaoshi2(map);
	}
	public List<Tuanweilaoshi> getsytuanweilaoshi3(Map<String, Object> map) {
		return gdao.getsytuanweilaoshi3(map);
	}
	
	@Override
	public Tuanweilaoshi quchongTuanweilaoshi(Map<String, Object> account) {
		return gdao.quchongTuanweilaoshi(account);
	}

	@Override
	public List<Tuanweilaoshi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tuanweilaoshi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tuanweilaoshi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

