package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TuituanshenqingMapper;
import com.entity.Tuituanshenqing;
import com.server.TuituanshenqingServer;
@Service
public class TuituanshenqingServerImpi implements TuituanshenqingServer {
   @Resource
   private TuituanshenqingMapper gdao;
	@Override
	public int add(Tuituanshenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Tuituanshenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Tuituanshenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Tuituanshenqing> getsytuituanshenqing1(Map<String, Object> map) {
		return gdao.getsytuituanshenqing1(map);
	}
	public List<Tuituanshenqing> getsytuituanshenqing2(Map<String, Object> map) {
		return gdao.getsytuituanshenqing2(map);
	}
	public List<Tuituanshenqing> getsytuituanshenqing3(Map<String, Object> map) {
		return gdao.getsytuituanshenqing3(map);
	}
	
	@Override
	public Tuituanshenqing quchongTuituanshenqing(Map<String, Object> account) {
		return gdao.quchongTuituanshenqing(account);
	}

	@Override
	public List<Tuituanshenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Tuituanshenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Tuituanshenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

