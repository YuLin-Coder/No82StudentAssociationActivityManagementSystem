package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shenqingrutuan;

public interface ShenqingrutuanServer {

  public int add(Shenqingrutuan po);

  public int update(Shenqingrutuan po);
  
  
  
  public int delete(int id);

  public List<Shenqingrutuan> getAll(Map<String,Object> map);
  public List<Shenqingrutuan> getsyshenqingrutuan1(Map<String,Object> map);
  public List<Shenqingrutuan> getsyshenqingrutuan2(Map<String,Object> map);
  public List<Shenqingrutuan> getsyshenqingrutuan3(Map<String,Object> map);
  public Shenqingrutuan quchongShenqingrutuan(Map<String, Object> acount);

  public Shenqingrutuan getById( int id);

  public List<Shenqingrutuan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shenqingrutuan> select(Map<String, Object> map);
}
//	所有List
