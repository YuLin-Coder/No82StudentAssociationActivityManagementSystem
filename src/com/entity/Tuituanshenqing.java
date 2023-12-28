package com.entity;

public class Tuituanshenqing {
    private Integer id;
	private String shetuanbianhao;	private String shetuanmingcheng;	private String xuehao;	private String xingming;	private String yuanxi;	private String tuituanliyou;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShetuanbianhao() {
        return shetuanbianhao;
    }
    public void setShetuanbianhao(String shetuanbianhao) {
        this.shetuanbianhao = shetuanbianhao == null ? null : shetuanbianhao.trim();
    }	public String getShetuanmingcheng() {
        return shetuanmingcheng;
    }
    public void setShetuanmingcheng(String shetuanmingcheng) {
        this.shetuanmingcheng = shetuanmingcheng == null ? null : shetuanmingcheng.trim();
    }	public String getXuehao() {
        return xuehao;
    }
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao == null ? null : xuehao.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getYuanxi() {
        return yuanxi;
    }
    public void setYuanxi(String yuanxi) {
        this.yuanxi = yuanxi == null ? null : yuanxi.trim();
    }	public String getTuituanliyou() {
        return tuituanliyou;
    }
    public void setTuituanliyou(String tuituanliyou) {
        this.tuituanliyou = tuituanliyou == null ? null : tuituanliyou.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
