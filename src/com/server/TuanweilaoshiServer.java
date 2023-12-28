package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Tuanweilaoshi;

public interface TuanweilaoshiServer {

  public int add(Tuanweilaoshi po);

  public int update(Tuanweilaoshi po);
  
  
  
  public int delete(int id);

  public List<Tuanweilaoshi> getAll(Map<String,Object> map);
  public List<Tuanweilaoshi> getsytuanweilaoshi1(Map<String,Object> map);
  public List<Tuanweilaoshi> getsytuanweilaoshi2(Map<String,Object> map);
  public List<Tuanweilaoshi> getsytuanweilaoshi3(Map<String,Object> map);
  public Tuanweilaoshi quchongTuanweilaoshi(Map<String, Object> acount);

  public Tuanweilaoshi getById( int id);

  public List<Tuanweilaoshi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Tuanweilaoshi> select(Map<String, Object> map);
}
//	所有List
