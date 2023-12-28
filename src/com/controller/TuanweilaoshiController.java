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

import com.entity.Tuanweilaoshi;
import com.server.TuanweilaoshiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class TuanweilaoshiController {
	@Resource
	private TuanweilaoshiServer tuanweilaoshiService;


   
	@RequestMapping("addTuanweilaoshi.do")
	public String addTuanweilaoshi(HttpServletRequest request,Tuanweilaoshi tuanweilaoshi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		tuanweilaoshi.setAddtime(time.toString().substring(0, 19));
		tuanweilaoshiService.add(tuanweilaoshi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "tuanweilaoshiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:tuanweilaoshiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateTuanweilaoshi.do")
	public String doUpdateTuanweilaoshi(int id,ModelMap map,Tuanweilaoshi tuanweilaoshi){
		tuanweilaoshi=tuanweilaoshiService.getById(id);
		map.put("tuanweilaoshi", tuanweilaoshi);
		return "tuanweilaoshi_updt";
	}
	
	@RequestMapping("doUpdateTuanweilaoshi2.do")
	public String doUpdateTuanweilaoshi2(ModelMap map,Tuanweilaoshi tuanweilaoshi,HttpServletRequest request){
		tuanweilaoshi=tuanweilaoshiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("tuanweilaoshi", tuanweilaoshi);
		return "tuanweilaoshi_updt2";
	}
	
@RequestMapping("updateTuanweilaoshi2.do")
	public String updateTuanweilaoshi2(int id,ModelMap map,Tuanweilaoshi tuanweilaoshi){
		tuanweilaoshiService.update(tuanweilaoshi);
		return "redirect:doUpdateTuanweilaoshi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("tuanweilaoshiDetail.do")
	public String tuanweilaoshiDetail(int id,ModelMap map,Tuanweilaoshi tuanweilaoshi){
		tuanweilaoshi=tuanweilaoshiService.getById(id);
		map.put("tuanweilaoshi", tuanweilaoshi);
		return "tuanweilaoshi_detail";
	}
//	前台详细
	@RequestMapping("twlsDetail.do")
	public String twlsDetail(int id,ModelMap map,Tuanweilaoshi tuanweilaoshi){
		tuanweilaoshi=tuanweilaoshiService.getById(id);
		map.put("tuanweilaoshi", tuanweilaoshi);
		return "tuanweilaoshidetail";
	}
//	
	@RequestMapping("updateTuanweilaoshi.do")
	public String updateTuanweilaoshi(int id,ModelMap map,Tuanweilaoshi tuanweilaoshi,HttpServletRequest request,HttpSession session){
		tuanweilaoshiService.update(tuanweilaoshi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:tuanweilaoshiList.do";
	}

//	分页查询
	@RequestMapping("tuanweilaoshiList.do")
	public String tuanweilaoshiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshi_list";
	}
	
	@RequestMapping("tuanweilaoshi_yanben1.do")
	public String tuanweilaoshi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshi_yanben1";
	}
	@RequestMapping("tuanweilaoshi_yanben2.do")
	public String tuanweilaoshi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshi_yanben2";
	}
	@RequestMapping("tuanweilaoshi_yanben3.do")
	public String tuanweilaoshi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshi_yanben3";
	}
	@RequestMapping("tuanweilaoshi_yanben4.do")
	public String tuanweilaoshi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshi_yanben4";
	}
	@RequestMapping("tuanweilaoshi_yanben5.do")
	public String tuanweilaoshi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshi_yanben5";
	}
	
	
	
	@RequestMapping("twlsList.do")
	public String twlsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshilist";
	}
	@RequestMapping("twlsListtp.do")
	public String twlsListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Tuanweilaoshi tuanweilaoshi, String bianhao, String mima, String xingming, String xingbie, String lianxidianhua, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=tuanweilaoshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Tuanweilaoshi> list=tuanweilaoshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "tuanweilaoshilisttp";
	}
	
	@RequestMapping("deleteTuanweilaoshi.do")
	public String deleteTuanweilaoshi(int id,HttpServletRequest request){
		tuanweilaoshiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:tuanweilaoshiList.do";
	}
	
	@RequestMapping("quchongTuanweilaoshi.do")
	public void quchongTuanweilaoshi(Tuanweilaoshi tuanweilaoshi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", tuanweilaoshi.getBianhao());
		   System.out.println("bianhao==="+tuanweilaoshi.getBianhao());
		   System.out.println("bianhao222==="+tuanweilaoshiService.quchongTuanweilaoshi(map));
		   JSONObject obj=new JSONObject();
		   if(tuanweilaoshiService.quchongTuanweilaoshi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "编号可以用！");
				  
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
