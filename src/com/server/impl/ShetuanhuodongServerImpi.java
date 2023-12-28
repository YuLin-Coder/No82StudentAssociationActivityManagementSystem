package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShetuanhuodongMapper;
import com.entity.Shetuanhuodong;
import com.server.ShetuanhuodongServer;
@Service
public class ShetuanhuodongServerImpi implements ShetuanhuodongServer {
   @Resource
   private ShetuanhuodongMapper gdao;
	@Override
	public int add(Shetuanhuodong po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shetuanhuodong po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shetuanhuodong> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shetuanhuodong> getsyshetuanhuodong1(Map<String, Object> map) {
		return gdao.getsyshetuanhuodong1(map);
	}
	public List<Shetuanhuodong> getsyshetuanhuodong2(Map<String, Object> map) {
		return gdao.getsyshetuanhuodong2(map);
	}
	public List<Shetuanhuodong> getsyshetuanhuodong3(Map<String, Object> map) {
		return gdao.getsyshetuanhuodong3(map);
	}
	
	@Override
	public Shetuanhuodong quchongShetuanhuodong(Map<String, Object> account) {
		return gdao.quchongShetuanhuodong(account);
	}

	@Override
	public List<Shetuanhuodong> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shetuanhuodong> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shetuanhuodong getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

