package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shetuanhuodong;

public interface ShetuanhuodongServer {

  public int add(Shetuanhuodong po);

  public int update(Shetuanhuodong po);
  
  
  
  public int delete(int id);

  public List<Shetuanhuodong> getAll(Map<String,Object> map);
  public List<Shetuanhuodong> getsyshetuanhuodong1(Map<String,Object> map);
  public List<Shetuanhuodong> getsyshetuanhuodong2(Map<String,Object> map);
  public List<Shetuanhuodong> getsyshetuanhuodong3(Map<String,Object> map);
  public Shetuanhuodong quchongShetuanhuodong(Map<String, Object> acount);

  public Shetuanhuodong getById( int id);

  public List<Shetuanhuodong> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shetuanhuodong> select(Map<String, Object> map);
}
//	所有List
