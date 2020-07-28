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
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mds.model.*;
import com.mds.repository.*;
import com.mds.service.*;

//@RestController
@Controller
public class InsuranceController {
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Autowired
	private SignatureRepository signatureRepository;

	@Autowired
	private SignatureDocService signatureDocService;
	@Autowired
	private SignatureDocRepository signatureDocRepository;

	@Autowired
	private DocRepository docRepository;

	@Autowired
	private SignatureDocRepository sdr;

	@Autowired
	private DocListRepository dlr;

	@Autowired
	private DocSubRepository dsr;

	@GetMapping("/insuranceDetail")
	public String index(Model model) {

		model.addAttribute("signature", signatureRepository.findAllOrderBySeq());
		model.addAttribute("insurance", insuranceRepository.findAll());
//		model.addAttribute("doc", dl.findAllDoc());

		model.addAttribute("doc", docRepository.findAll());
		model.addAttribute("signatureDoc", signatureDocRepository.findAll());
		model.addAttribute("docSub", dsr.findAll());
		List<SignatureDoc> list = signatureDocRepository.findAll();

		List<DocList> dlrList = dlr.findAll();
		List<Doc> dList = docRepository.findAll();
		List<DocSub> dsList = dsr.findAll();

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> sublist = new ArrayList<Map<String, Object>>();
		Map<String, Object> submap = new HashMap<String, Object>();

//		for (DocList dl : dlrList) {
//			for (Doc d : dList) {
//				for (DocSub ds : dsList) {
//					if (dl.getDoc_id().equals(d.getDoc_id()) && dl.getDocsub_id().equals(ds.getDocsub_id())) {
//						map.put("class_id", d.getClass_id());
//						map.put("doc_id", d.getDoc_id());
//						map.put("xcode_title", d.getXcode_title());
//						map.put("doc_name", d.getDoc_name());
//
//						if (!dl.getDocsub_id().equals("null")) {
//							submap.put("sub_title", ds.getSub_title());
//							sublist.add(submap);
//						}
//
//						map.put("subtitle", submap);
//						System.out.println(ds.getSub_title());
//					}
//					listMap.add(map);
//				}
//
//			}
//		}
//
//		System.out.println(listMap);

		String str = "";
		int count = 0;
		String test = ",";
		for (SignatureDoc l : list) {
			String dataStr = l.getInsurance_id() + "_" + l.getEpeoplename();

			if (list.size() - 1 == count) {
				test = "";
			}
			str += dataStr + test;
			count++;
		}
		model.addAttribute("str", str);
		return "insuranceDetail";
	}

	@PostMapping("/insurance/create")
	public String create(Model model, @Valid SignatureDoc signatureDoc, BindingResult result,
			RedirectAttributes redirect, @RequestParam(value = "data", required = false) String s,
			@RequestParam(value = "doc_id", required = false) String doc_id,
			@RequestParam(value = "docsub_id", required = false) String docsub_id) {
		sdr.delete(sdr.findOneDoc(doc_id, docsub_id));

		try {
			String[] dataStr = s.split(",");
			for (int i = 0; i < dataStr.length; i++) {
				String[] d = dataStr[i].split("_");

				String insurance_id = d[0];
				String epeoplename = d[1];

				System.out.println("delete=" + insurance_id + "_" + doc_id + "_" + epeoplename);
				String group_id = UUID.randomUUID().toString();

				signatureDoc.setGroup_id(group_id);
				signatureDoc.setInsurance_id(insurance_id);
				signatureDoc.setDoc_id(doc_id);
				signatureDoc.setEpeoplename(epeoplename);
				signatureDoc.setDocsub_id(docsub_id);
				signatureDoc.setDocsub_id(docsub_id);
				signatureDocService.save(signatureDoc);
				System.out.println(docsub_id);
			}

			redirect.addFlashAttribute("success", "新增資料成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/insuranceDetail";
	}

}