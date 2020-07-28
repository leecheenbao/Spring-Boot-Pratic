package com.mds.controller;

import java.awt.PageAttributes.MediaType;
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
import org.springframework.util.MultiValueMap;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.mds.model.*;
import com.mds.repository.*;
import com.mds.service.*;

@RestController
@RequestMapping("/insuranceDetail")
public class AjaxController {

	@Autowired
	private SignatureDocRepository sdr;
	@Autowired
	private DocRepository dr;
	@Autowired
	private DocListRepository dlr;

	@RequestMapping(value = "/onChange", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String change(Model model, @RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "doc_id", required = false) String doc_id,
			@RequestParam(value = "docsub_id", required = false) String docsub_id,
			@RequestParam(value = "class_id", required = false) String class_id) {
//		System.out.println("action=" + doc_id + "," + docsub_id);
//		System.out.println("===onChange start ===");

		String str = "";
		int count = 0;
		String space = ",";
		String dataStr = "";
		List<SignatureDoc> list = null;
		if (action.equals("changeDocId")) {
			list = sdr.findOneDoc(doc_id, docsub_id);
			dataStr = null;
		} else {
			list = sdr.findAll();
		}
		for (SignatureDoc l : list) {
			dataStr = l.getInsurance_id() + "_" + l.getEpeoplename();
			if (list.size() - 1 == count) {
				space = "";
			}
			str += dataStr + space;
			count++;
		}
		return str;

	}

	@RequestMapping(value = "/docOnChange", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String docChange(Model model, @RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "doc_id", required = false) String doc_id) {
		System.out.println(doc_id);
		List<DocList> list = dlr.findOneDoc(doc_id);

		String str = "";
		int count = 0;
		String space = ",";
		String dataStr = "";

		for (DocList dl : list) {
			dataStr = dl.getDocsub_id();
			if (list.size() - 1 == count) {
				space = "";
			}
			str += dataStr + space;
			count++;
		}
		System.out.println(str);

		return str;

	}

}