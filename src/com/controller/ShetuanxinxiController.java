package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Shetuanxinxi;
import com.server.ShetuanxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShetuanxinxiController {
	@Resource
	private ShetuanxinxiServer shetuanxinxiService;


   
	@RequestMapping("addShetuanxinxi.do")
	public String addShetuanxinxi(HttpServletRequest request,Shetuanxinxi shetuanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shetuanxinxi.setAddtime(time.toString().substring(0, 19));
		shetuanxinxiService.add(shetuanxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shetuanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shetuanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShetuanxinxi.do")
	public String doUpdateShetuanxinxi(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxi=shetuanxinxiService.getById(id);
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxi_updt";
	}
	
	@RequestMapping("doUpdateShetuanxinxi2.do")
	public String doUpdateShetuanxinxi2(ModelMap map,Shetuanxinxi shetuanxinxi,HttpServletRequest request){
		shetuanxinxi=shetuanxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxi_updt2";
	}
	
@RequestMapping("updateShetuanxinxi2.do")
	public String updateShetuanxinxi2(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxiService.update(shetuanxinxi);
		return "redirect:doUpdateShetuanxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("shetuanxinxiDetail.do")
	public String shetuanxinxiDetail(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxi=shetuanxinxiService.getById(id);
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxi_detail";
	}
//	前台详细
	@RequestMapping("stxxDetail.do")
	public String stxxDetail(int id,ModelMap map,Shetuanxinxi shetuanxinxi){
		shetuanxinxi=shetuanxinxiService.getById(id);
		map.put("shetuanxinxi", shetuanxinxi);
		return "shetuanxinxidetail";
	}
//	
	@RequestMapping("updateShetuanxinxi.do")
	public String updateShetuanxinxi(int id,ModelMap map,Shetuanxinxi shetuanxinxi,HttpServletRequest request,HttpSession session){
		shetuanxinxiService.update(shetuanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shetuanxinxiList.do";
	}

//	分页查询
	@RequestMapping("shetuanxinxiList.do")
	public String shetuanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_list";
	}
	
	@RequestMapping("shetuanxinxi_yanben1.do")
	public String shetuanxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben1";
	}
	@RequestMapping("shetuanxinxi_yanben2.do")
	public String shetuanxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben2";
	}
	@RequestMapping("shetuanxinxi_yanben3.do")
	public String shetuanxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben3";
	}
	@RequestMapping("shetuanxinxi_yanben4.do")
	public String shetuanxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben4";
	}
	@RequestMapping("shetuanxinxi_yanben5.do")
	public String shetuanxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxi_yanben5";
	}
	
	
	
	@RequestMapping("stxxList.do")
	public String stxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxilist";
	}
	@RequestMapping("stxxListtp.do")
	public String stxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanxinxi shetuanxinxi, String shetuanbianhao, String mima, String shetuanmingcheng, String fuzeren, String shetuanLOGO, String lianxidianhua, String shetuanrenshu1,String shetuanrenshu2, String shetuandengji, String shetuanjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(fuzeren==null||fuzeren.equals("")){pmap.put("fuzeren", null);}else{pmap.put("fuzeren", fuzeren);}		if(shetuanLOGO==null||shetuanLOGO.equals("")){pmap.put("shetuanLOGO", null);}else{pmap.put("shetuanLOGO", shetuanLOGO);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shetuanrenshu1==null||shetuanrenshu1.equals("")){pmap.put("shetuanrenshu1", null);}else{pmap.put("shetuanrenshu1", shetuanrenshu1);}		if(shetuanrenshu2==null||shetuanrenshu2.equals("")){pmap.put("shetuanrenshu2", null);}else{pmap.put("shetuanrenshu2", shetuanrenshu2);}		if(shetuandengji==null||shetuandengji.equals("")){pmap.put("shetuandengji", null);}else{pmap.put("shetuandengji", shetuandengji);}		if(shetuanjianjie==null||shetuanjianjie.equals("")){pmap.put("shetuanjianjie", null);}else{pmap.put("shetuanjianjie", shetuanjianjie);}		
		int total=shetuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanxinxi> list=shetuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanxinxilisttp";
	}
	
	@RequestMapping("deleteShetuanxinxi.do")
	public String deleteShetuanxinxi(int id,HttpServletRequest request){
		shetuanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shetuanxinxiList.do";
	}
	
	@RequestMapping("quchongShetuanxinxi.do")
	public void quchongShetuanxinxi(Shetuanxinxi shetuanxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("shetuanbianhao", shetuanxinxi.getShetuanbianhao());
		   System.out.println("shetuanbianhao==="+shetuanxinxi.getShetuanbianhao());
		   System.out.println("shetuanbianhao222==="+shetuanxinxiService.quchongShetuanxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(shetuanxinxiService.quchongShetuanxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "社团编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
