package com.poscodx.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poscodx.mysite.service.GuestbookService;
import com.poscodx.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("")
	public String main(Model model) {
		List<GuestbookVo> list = guestbookService.getContentsList();
		model.addAttribute("list", list);
		
		return "guestbook/main";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/delete";
	}
	
	@RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
	public String deleteContents(@PathVariable("no") Long no) {
		guestbookService.deleteContents(no);
		return "redirect:/guestbook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookService.addContents(vo);
		System.out.println(vo.getName());
		return "redirect:/guestbook";
	}
}
