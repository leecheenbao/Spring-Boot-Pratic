package com.mds.controller;

import java.io.*;
import java.util.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.model.*;
import com.mds.repository.DocListRepository;
import com.mds.repository.DocRepository;
import com.mds.service.*;

//@RestController
@Controller
public class DocController {
	@Autowired
	private DocService docService;
	@Autowired
	private DocRepository docRepository;

	@Autowired
	private DocSubService docsubService;
	@Autowired
	private DocListService doclistService;
	@Autowired
	private DocListRepository doclistRepository;

	@GetMapping("/doc")
	public String index(Model model) {

		model.addAttribute("doc", docRepository.findAll());
		System.out.println();
		return "docList";
	}

	@GetMapping("/doc/create")
	public String create(Model model) {
		model.addAttribute("docsub", docsubService.findAll());
		model.addAttribute("doc", new Doc());
		return "docForm";
	}

	@GetMapping("/doc/{id}/edit")
	public String edit(DocList doclist, @PathVariable String id, Model model) {
		List<DocList> list = doclistRepository.findOneDoc(id);
		System.out.println(list);

		String str = "";
		int count = 0;
		String space = ",";
		String dataStr = "";

		for (DocList l : list) {
			dataStr = l.getDocsub_id();
			if (list.size() - 1 == count) {
				space = "";
			}
			str += dataStr + space;
			count++;
		}

		model.addAttribute("doclist", str);
		model.addAttribute("doc", docService.findOne(id));
		model.addAttribute("docsub", docsubService.findAll());
		return "docForm";
	}

	@PostMapping("/doc/save")
	public String save(@Valid Doc doc, @Valid DocList doclist,
			@RequestParam(value = "docsub_id", required = false) String subStr, BindingResult result,
			RedirectAttributes redirect) {
		try {

			String[] docsub_id = subStr.split(",");
			doclistRepository.delete(doclistRepository.findOneDoc(doc.getDoc_id()));
			for (int i = 0; i < docsub_id.length; i++) {
				String guid = UUID.randomUUID().toString();
				doclist.setGuid(guid);
				doclist.setDoc_id(doc.getDoc_id());
				doclist.setDocsub_id(docsub_id[i]);

				doclistService.save(doclist);
			}

			docService.save(doc);
			redirect.addFlashAttribute("success", "新增資料成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/doc";
	}

	@GetMapping("/doc/{id}/delete")
	public String delete(@PathVariable String id, RedirectAttributes redirect) {
		docService.delete(id);
		redirect.addFlashAttribute("success", "刪除資料成功！");
		return "redirect:/doc";
	}

	@GetMapping("/doc/search")
	public String search(@RequestParam("s") String s, Model model) {
		System.out.println(s);

		if (s.equals("")) {
			return "redirect:/doc";
		}

		model.addAttribute("docs", docService.search(s));
		return "docList";
	}

//	// doc 包至Json
//	@RequestMapping(value = "/doc/hello", produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public Map test(Model model) {
//		model.addAttribute("docs", docService.findAll());
//		Iterable<doc> emp = docService.findAll();
//
//		Map<String, Object> mapResult = new HashMap<>();
//		for (doc e : emp) {
//			mapResult.put("doc", emp);
//			mapResult.put("test", "key1");
//		}
//
//		return mapResult;
//	}
//

}