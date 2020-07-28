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
import com.mds.repository.SignatureRepository;
import com.mds.service.*;

//@RestController
@Controller
public class SignatureController {
	@Autowired
	private SignatureService signatureService;
	@Autowired
	private SignatureRepository signatureRepository;

	@GetMapping("/signature")
	public String index(Model model) {

		model.addAttribute("signature", signatureRepository.findAll());
		
		return "signatureList";
	}

	@GetMapping("/signature/create")
	public String create(Model model) {
		model.addAttribute("signature", new Signature());
		return "signatureForm";
	}

	@GetMapping("/signature/{id}/edit")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("signature", signatureService.findOne(id));
		return "SignatureForm";
	}

	@PostMapping("/signature/save")
	public String save(@Valid Signature signature, BindingResult result, RedirectAttributes redirect) {
		System.out.println(result.getErrorCount());

		try {

			signatureService.save(signature);
			redirect.addFlashAttribute("success", "新增資料成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/signature";
	}

	@GetMapping("/signature/{id}/delete")
	public String delete(@PathVariable String id, RedirectAttributes redirect) {
		signatureService.delete(id);
		redirect.addFlashAttribute("success", "刪除資料成功！");
		return "redirect:/signature";
	}

	@GetMapping("/signature/search")
	public String search(@RequestParam("s") String s, Model model) {
		System.out.println(s);

		if (s.equals("")) {
			return "redirect:/signature";
		}

		model.addAttribute("signatures", signatureService.search(s));
		return "signatureList";
	}


}