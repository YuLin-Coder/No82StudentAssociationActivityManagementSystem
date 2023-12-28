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

import com.entity.Shetuanhuodong;
import com.server.ShetuanhuodongServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShetuanhuodongController {
	@Resource
	private ShetuanhuodongServer shetuanhuodongService;


   
	@RequestMapping("addShetuanhuodong.do")
	public String addShetuanhuodong(HttpServletRequest request,Shetuanhuodong shetuanhuodong,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shetuanhuodong.setAddtime(time.toString().substring(0, 19));
		shetuanhuodongService.add(shetuanhuodong);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shetuanhuodongList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shetuanhuodongList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShetuanhuodong.do")
	public String doUpdateShetuanhuodong(int id,ModelMap map,Shetuanhuodong shetuanhuodong){
		shetuanhuodong=shetuanhuodongService.getById(id);
		map.put("shetuanhuodong", shetuanhuodong);
		return "shetuanhuodong_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shetuanhuodongDetail.do")
	public String shetuanhuodongDetail(int id,ModelMap map,Shetuanhuodong shetuanhuodong){
		shetuanhuodong=shetuanhuodongService.getById(id);
		map.put("shetuanhuodong", shetuanhuodong);
		return "shetuanhuodong_detail";
	}
//	前台详细
	@RequestMapping("sthdDetail.do")
	public String sthdDetail(int id,ModelMap map,Shetuanhuodong shetuanhuodong){
		shetuanhuodong=shetuanhuodongService.getById(id);
		map.put("shetuanhuodong", shetuanhuodong);
		return "shetuanhuodongdetail";
	}
//	
	@RequestMapping("updateShetuanhuodong.do")
	public String updateShetuanhuodong(int id,ModelMap map,Shetuanhuodong shetuanhuodong,HttpServletRequest request,HttpSession session){
		shetuanhuodongService.update(shetuanhuodong);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shetuanhuodongList.do";
	}

//	分页查询
	@RequestMapping("shetuanhuodongList.do")
	public String shetuanhuodongList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_list";
	}
	
	@RequestMapping("shetuanhuodong_yanben1.do")
	public String shetuanhuodong_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben1";
	}
	@RequestMapping("shetuanhuodong_yanben2.do")
	public String shetuanhuodong_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben2";
	}
	@RequestMapping("shetuanhuodong_yanben3.do")
	public String shetuanhuodong_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben3";
	}
	@RequestMapping("shetuanhuodong_yanben4.do")
	public String shetuanhuodong_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben4";
	}
	@RequestMapping("shetuanhuodong_yanben5.do")
	public String shetuanhuodong_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_yanben5";
	}
	
	@RequestMapping("shetuanhuodongList2.do")
	public String shetuanhuodongList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh,HttpServletRequest request){
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
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodong_list2";
	}	
	
	@RequestMapping("sthdList.do")
	public String sthdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodonglist";
	}
	@RequestMapping("sthdListtp.do")
	public String sthdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shetuanhuodong shetuanhuodong, String huodongmingcheng, String huodongshijian1,String huodongshijian2, String shetuanbianhao, String shetuanmingcheng, String huodongjianjie, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huodongmingcheng==null||huodongmingcheng.equals("")){pmap.put("huodongmingcheng", null);}else{pmap.put("huodongmingcheng", huodongmingcheng);}		if(huodongshijian1==null||huodongshijian1.equals("")){pmap.put("huodongshijian1", null);}else{pmap.put("huodongshijian1", huodongshijian1);}		if(huodongshijian2==null||huodongshijian2.equals("")){pmap.put("huodongshijian2", null);}else{pmap.put("huodongshijian2", huodongshijian2);}		if(shetuanbianhao==null||shetuanbianhao.equals("")){pmap.put("shetuanbianhao", null);}else{pmap.put("shetuanbianhao", shetuanbianhao);}		if(shetuanmingcheng==null||shetuanmingcheng.equals("")){pmap.put("shetuanmingcheng", null);}else{pmap.put("shetuanmingcheng", shetuanmingcheng);}		if(huodongjianjie==null||huodongjianjie.equals("")){pmap.put("huodongjianjie", null);}else{pmap.put("huodongjianjie", huodongjianjie);}		
		int total=shetuanhuodongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shetuanhuodong> list=shetuanhuodongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shetuanhuodonglisttp";
	}
	
	@RequestMapping("deleteShetuanhuodong.do")
	public String deleteShetuanhuodong(int id,HttpServletRequest request){
		shetuanhuodongService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shetuanhuodongList.do";
	}
	
	
}
