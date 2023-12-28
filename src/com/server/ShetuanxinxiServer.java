package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shetuanxinxi;

public interface ShetuanxinxiServer {

  public int add(Shetuanxinxi po);

  public int update(Shetuanxinxi po);
  
  
  
  public int delete(int id);

  public List<Shetuanxinxi> getAll(Map<String,Object> map);
  public List<Shetuanxinxi> getsyshetuanxinxi1(Map<String,Object> map);
  public List<Shetuanxinxi> getsyshetuanxinxi2(Map<String,Object> map);
  public List<Shetuanxinxi> getsyshetuanxinxi3(Map<String,Object> map);
  public Shetuanxinxi quchongShetuanxinxi(Map<String, Object> acount);

  public Shetuanxinxi getById( int id);

  public List<Shetuanxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shetuanxinxi> select(Map<String, Object> map);
}
//	所有List
