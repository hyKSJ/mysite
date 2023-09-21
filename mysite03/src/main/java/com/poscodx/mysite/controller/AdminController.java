package com.poscodx.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.service.FileUploadService;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;

@Auth(Role="ADMIN")
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private SiteService siteService;

	@Autowired
	private FileUploadService fileUploadService;

	@RequestMapping("")
	public String main(Model model) {
		SiteVo vo = siteService.getSite();
		model.addAttribute("siteVo", vo);
		return "admin/main";
	}

//	@RequestMapping("/main/update")
//	public String update(@RequestParam("f") MultipartFile file, SiteVo vo) {
//		String url = fileUploadService.restore(file);
//		vo.setProfile(url);
//		System.out.println(vo);
//		siteService.updateSite(vo);
//		return "redirect:/admin";  
//	}
	@RequestMapping("/main/update")
	public String update(@RequestParam("f") MultipartFile file, SiteVo vo) {
		System.out.println(vo);
		String profile = fileUploadService.restore(file);
		System.out.println(profile);
		System.out.println(vo);
		if (profile != null) {
			vo.setProfile(profile);
		}
		siteService.updateSite(vo);
		return "redirect:/admin";
	}

	
	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}

	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}

	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}	
}