package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShenqingrutuanMapper;
import com.entity.Shenqingrutuan;
import com.server.ShenqingrutuanServer;
@Service
public class ShenqingrutuanServerImpi implements ShenqingrutuanServer {
   @Resource
   private ShenqingrutuanMapper gdao;
	@Override
	public int add(Shenqingrutuan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shenqingrutuan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shenqingrutuan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shenqingrutuan> getsyshenqingrutuan1(Map<String, Object> map) {
		return gdao.getsyshenqingrutuan1(map);
	}
	public List<Shenqingrutuan> getsyshenqingrutuan2(Map<String, Object> map) {
		return gdao.getsyshenqingrutuan2(map);
	}
	public List<Shenqingrutuan> getsyshenqingrutuan3(Map<String, Object> map) {
		return gdao.getsyshenqingrutuan3(map);
	}
	
	@Override
	public Shenqingrutuan quchongShenqingrutuan(Map<String, Object> account) {
		return gdao.quchongShenqingrutuan(account);
	}

	@Override
	public List<Shenqingrutuan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shenqingrutuan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shenqingrutuan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

