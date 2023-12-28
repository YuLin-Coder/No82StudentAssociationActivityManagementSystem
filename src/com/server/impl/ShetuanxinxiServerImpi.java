package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShetuanxinxiMapper;
import com.entity.Shetuanxinxi;
import com.server.ShetuanxinxiServer;
@Service
public class ShetuanxinxiServerImpi implements ShetuanxinxiServer {
   @Resource
   private ShetuanxinxiMapper gdao;
	@Override
	public int add(Shetuanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shetuanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shetuanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shetuanxinxi> getsyshetuanxinxi1(Map<String, Object> map) {
		return gdao.getsyshetuanxinxi1(map);
	}
	public List<Shetuanxinxi> getsyshetuanxinxi2(Map<String, Object> map) {
		return gdao.getsyshetuanxinxi2(map);
	}
	public List<Shetuanxinxi> getsyshetuanxinxi3(Map<String, Object> map) {
		return gdao.getsyshetuanxinxi3(map);
	}
	
	@Override
	public Shetuanxinxi quchongShetuanxinxi(Map<String, Object> account) {
		return gdao.quchongShetuanxinxi(account);
	}

	@Override
	public List<Shetuanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shetuanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shetuanxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

