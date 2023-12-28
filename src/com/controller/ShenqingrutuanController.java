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

import com.entity.Shenqingrutuan;
import com.server.ShenqingrutuanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShenqingrutuanController {
	@Resource
	private ShenqingrutuanServer shenqingrutuanService;


   
	@RequestMapping("addShenqingrutuan.do")
	public String addShenqingrutuan(HttpServletRequest request,Shenqingrutuan shenqingrutuan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shenqingrutuan.setAddtime(time.toString().substring(0, 19));
		shenqingrutuanService.add(shenqingrutuan);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shenqingrutuanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shenqingrutuanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShenqingrutuan.do")
	public String doUpdateShenqingrutuan(int id,ModelMap map,Shenqingrutuan shenqingrutuan){
		shenqingrutuan=shenqingrutuanService.getById(id);
		map.put("shenqingrutuan", shenqingrutuan);
		return "shenqingrutuan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shenqingrutuanDetail.do")
	public String shenqingrutuanDetail(int id,ModelMap map,Shenqingrutuan shenqingrutuan){
		shenqingrutuan=shenqingrutuanService.getById(id);
		map.put("shenqingrutuan", shenqingrutuan);
		return "shenqingrutuan_detail";
	}
//	前台详细
	@RequestMapping("sqrtDetail.do")
	public String sqrtDetail(int id,ModelMap map,Shenqingrutuan shenqingrutuan){
		shenqingrutuan=shenqingrutuanService.getById(id);
		map.put("shenqingrutuan", shenqingrutuan);
		return "shenqingrutuandetail";
	}
//	
	@RequestMapping("updateShenqingrutuan.do")
	public String updateShenqingrutuan(int id,ModelMap map,Shenqingrutuan shenqingrutuan,HttpServletRequest request,HttpSession session){
		shenqingrutuanService.update(shenqingrutuan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shenqingrutuanList.do";
	}

//	分页查询
	@RequestMapping("shenqingrutuanList.do")
	public String shenqingrutuanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_list";
	}
	
	@RequestMapping("shenqingrutuan_yanben1.do")
	public String shenqingrutuan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_yanben1";
	}
	@RequestMapping("shenqingrutuan_yanben2.do")
	public String shenqingrutuan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_yanben2";
	}
	@RequestMapping("shenqingrutuan_yanben3.do")
	public String shenqingrutuan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_yanben3";
	}
	@RequestMapping("shenqingrutuan_yanben4.do")
	public String shenqingrutuan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_yanben4";
	}
	@RequestMapping("shenqingrutuan_yanben5.do")
	public String shenqingrutuan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_yanben5";
	}
	
	@RequestMapping("shenqingrutuanList3.do")
	public String shenqingrutuanList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("shetuanbianhao", (String)request.getSession().getAttribute("username"));
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_list3";
	}	@RequestMapping("shenqingrutuanList2.do")
	public String shenqingrutuanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("xuehao", (String)request.getSession().getAttribute("username"));
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuan_list2";
	}	
	
	@RequestMapping("sqrtList.do")
	public String sqrtList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuanlist";
	}
	@RequestMapping("sqrtListtp.do")
	public String sqrtListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shenqingrutuan shenqingrutuan, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String banji, String dianhua, String shenqingliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(banji==null||banji.equals("")){pmap.put("banji", null);}else{pmap.put("banji", banji);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		
		int total=shenqingrutuanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shenqingrutuan> list=shenqingrutuanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shenqingrutuanlisttp";
	}
	
	@RequestMapping("deleteShenqingrutuan.do")
	public String deleteShenqingrutuan(int id,HttpServletRequest request){
		shenqingrutuanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shenqingrutuanList.do";
	}
	
	
}
