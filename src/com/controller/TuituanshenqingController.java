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

import com.entity.Tuituanshenqing;
import com.server.TuituanshenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TuituanshenqingController {
	@Resource
	private TuituanshenqingServer tuituanshenqingService;


   
	@RequestMapping("addTuituanshenqing.do")
	public String addTuituanshenqing(HttpServletRequest request,Tuituanshenqing tuituanshenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tuituanshenqing.setAddtime(time.toString().substring(0, 19));
		tuituanshenqingService.add(tuituanshenqing);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tuituanshenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tuituanshenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTuituanshenqing.do")
	public String doUpdateTuituanshenqing(int id,ModelMap map,Tuituanshenqing tuituanshenqing){
		tuituanshenqing=tuituanshenqingService.getById(id);
		map.put("tuituanshenqing", tuituanshenqing);
		return "tuituanshenqing_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("tuituanshenqingDetail.do")
	public String tuituanshenqingDetail(int id,ModelMap map,Tuituanshenqing tuituanshenqing){
		tuituanshenqing=tuituanshenqingService.getById(id);
		map.put("tuituanshenqing", tuituanshenqing);
		return "tuituanshenqing_detail";
	}
//	前台详细
	@RequestMapping("ttsqDetail.do")
	public String ttsqDetail(int id,ModelMap map,Tuituanshenqing tuituanshenqing){
		tuituanshenqing=tuituanshenqingService.getById(id);
		map.put("tuituanshenqing", tuituanshenqing);
		return "tuituanshenqingdetail";
	}
//	
	@RequestMapping("updateTuituanshenqing.do")
	public String updateTuituanshenqing(int id,ModelMap map,Tuituanshenqing tuituanshenqing,HttpServletRequest request,HttpSession session){
		tuituanshenqingService.update(tuituanshenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tuituanshenqingList.do";
	}

//	分页查询
	@RequestMapping("tuituanshenqingList.do")
	public String tuituanshenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_list";
	}
	
	@RequestMapping("tuituanshenqing_yanben1.do")
	public String tuituanshenqing_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_yanben1";
	}
	@RequestMapping("tuituanshenqing_yanben2.do")
	public String tuituanshenqing_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_yanben2";
	}
	@RequestMapping("tuituanshenqing_yanben3.do")
	public String tuituanshenqing_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_yanben3";
	}
	@RequestMapping("tuituanshenqing_yanben4.do")
	public String tuituanshenqing_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_yanben4";
	}
	@RequestMapping("tuituanshenqing_yanben5.do")
	public String tuituanshenqing_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_yanben5";
	}
	
	@RequestMapping("tuituanshenqingList3.do")
	public String tuituanshenqingList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh,HttpServletRequest request){
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
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_list3";
	}	@RequestMapping("tuituanshenqingList2.do")
	public String tuituanshenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh,HttpServletRequest request){
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
		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqing_list2";
	}	
	
	@RequestMapping("ttsqList.do")
	public String ttsqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqinglist";
	}
	@RequestMapping("ttsqListtp.do")
	public String ttsqListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuituanshenqing tuituanshenqing, String shetuanbianhao, String shetuanmingcheng, String xuehao, String xingming, String yuanxi, String tuituanliyou, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(xuehao==null||xuehao.equals("")){pmap.put("xuehao", null);}else{pmap.put("xuehao", xuehao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(yuanxi==null||yuanxi.equals("")){pmap.put("yuanxi", null);}else{pmap.put("yuanxi", yuanxi);}		if(tuituanliyou==null||tuituanliyou.equals("")){pmap.put("tuituanliyou", null);}else{pmap.put("tuituanliyou", tuituanliyou);}		
		int total=tuituanshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuituanshenqing> list=tuituanshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuituanshenqinglisttp";
	}
	
	@RequestMapping("deleteTuituanshenqing.do")
	public String deleteTuituanshenqing(int id,HttpServletRequest request){
		tuituanshenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tuituanshenqingList.do";
	}
	
	
}
