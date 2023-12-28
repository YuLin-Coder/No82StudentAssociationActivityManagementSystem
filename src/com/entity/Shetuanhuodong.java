package com.entity;

public class Shetuanhuodong {
    private Integer id;
	private String huodongmingcheng;	private String huodongshijian;	private String shetuanbianhao;	private String shetuanmingcheng;	private String huodongjianjie;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getHuodongmingcheng() {
        return huodongmingcheng;
    }
    public void setHuodongmingcheng(String huodongmingcheng) {
        this.huodongmingcheng = huodongmingcheng == null ? null : huodongmingcheng.trim();
    }	public String getHuodongshijian() {
        return huodongshijian;
    }
    public void setHuodongshijian(String huodongshijian) {
        this.huodongshijian = huodongshijian == null ? null : huodongshijian.trim();
    }	public String getShetuanbianhao() {
        return shetuanbianhao;
    }
    public void setShetuanbianhao(String shetuanbianhao) {
        this.shetuanbianhao = shetuanbianhao == null ? null : shetuanbianhao.trim();
    }	public String getShetuanmingcheng() {
        return shetuanmingcheng;
    }
    public void setShetuanmingcheng(String shetuanmingcheng) {
        this.shetuanmingcheng = shetuanmingcheng == null ? null : shetuanmingcheng.trim();
    }	public String getHuodongjianjie() {
        return huodongjianjie;
    }
    public void setHuodongjianjie(String huodongjianjie) {
        this.huodongjianjie = huodongjianjie == null ? null : huodongjianjie.trim();
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
