package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tuituanshenqing;

public interface TuituanshenqingServer {

  public int add(Tuituanshenqing po);

  public int update(Tuituanshenqing po);
  
  
  
  public int delete(int id);

  public List<Tuituanshenqing> getAll(Map<String,Object> map);
  public List<Tuituanshenqing> getsytuituanshenqing1(Map<String,Object> map);
  public List<Tuituanshenqing> getsytuituanshenqing2(Map<String,Object> map);
  public List<Tuituanshenqing> getsytuituanshenqing3(Map<String,Object> map);
  public Tuituanshenqing quchongTuituanshenqing(Map<String, Object> acount);

  public Tuituanshenqing getById( int id);

  public List<Tuituanshenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tuituanshenqing> select(Map<String, Object> map);
}
//	所有List
