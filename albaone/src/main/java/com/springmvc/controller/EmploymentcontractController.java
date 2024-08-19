package com.springmvc.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.springmvc.domain.Employmentcontract;
import com.springmvc.service.*;

@Controller
public class EmploymentcontractController
{
	@Autowired
	private EmploymentcontractServiceImpl employmentcontractService;
	
    @Autowired
    private ApplyServiceImpl applyService;
	
    //사업자 번호 조회를 위해 리파지토리가져옴
    @Autowired
    private UserServiceImpl UserServiceImpl;
    
    //서블렛연결
    @Autowired
    private ServletContext servletContext;
    
	//get 요청 발생시 계약서 create 폼 제공
	@GetMapping("/employmentcontract")
	public String employmentcontractform
	(
			@RequestParam("apply_id")int apply_id,
			@RequestParam("status")String status,
			@RequestParam("postNumber")int postNumber,
			Model model,
			HttpSession session
	)
	{
		String id = (String) session.getAttribute("id");
		model.addAttribute("apply_id", apply_id);
		model.addAttribute("status", status);
		model.addAttribute("postNumber", postNumber);
		model.addAttribute("id", id);
		model.addAttribute("BusinessNumber",UserServiceImpl.findBusinessNumber(id));
		
		return "employmentcontractform";
	}
	
	//근로계약서 폼에서 요청 발생시 create
	@PostMapping("/employmentcontract")
	public String employmentcontractend
	(
			@ModelAttribute("employment") Employmentcontract employmentcontract,
			@RequestParam("apply_id") int apply_id,
			@RequestParam("status") String status,
			@RequestParam("postNumber") int postNumber,
			BindingResult result,
			HttpServletRequest req)
	{
		if(result.hasErrors())
		{return "resume";}
		String root = req.getServletContext().getRealPath("/resources/images");//저장 경로
		//sineName - 파일명, 파라미터
		MultipartFile sineName = employmentcontract.getSinefile();//멀티 파츠로 파일 생성
		System.out.println(sineName);
		String saveName = sineName.getOriginalFilename();//원래 파일명
		File saveFile = new File(root ,saveName);
		
		if(sineName !=null && !sineName.isEmpty())
		try
		{
			sineName.transferTo(saveFile);
			employmentcontract.setSinefilename(saveName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		employmentcontractService.create(employmentcontract);
		applyService.updateApplyStatus(apply_id,status,postNumber);
		
		return "redirect:/businesApplylist?postNumber="+postNumber;
	}
	
	// 알바생명으로 모든 계약서 조회
	@GetMapping("/contracts")
	public String getContractsByPartTimeName(HttpSession session , Model model)
	{
		
		String id = (String) session.getAttribute("id");
		String BusinessNumber =  UserServiceImpl.findBusinessNumber(id);
		if (BusinessNumber != null && !BusinessNumber.isEmpty())
		{
			List<Employmentcontract> contracts = employmentcontractService.findAllByPartTimeName(BusinessNumber);
			if (!contracts.isEmpty())
			{
				model.addAttribute("contract", contracts);
			}
			else
			{
				model.addAttribute("error", "해당 알바생명의 계약서가 존재하지 않습니다.");
		    }
		}
		return "employmentcontractlistcompany"; // 뷰 이름
	}
		
	//계약서 삭제
	@GetMapping("/empcomdel")
	public String delete(Model model, @RequestParam int num,HttpSession session)
	{
		employmentcontractService.deleteContractsByPartTimeName(num);
		//getContractsByPartTimeNameownername 메서드로 이동 - 사장 이름으로 조회
		return "redirect:/home";
	}
	
	// PDF 다운로드 메서드
    @GetMapping("/downloadPDF")
    public ResponseEntity<byte[]> downloadPDF(@RequestParam int num) {
        Employmentcontract contract = employmentcontractService.findByNum(num);
        
        if (contract == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        try
        {
            // PDF 생성
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // 한글 글꼴 설정
            String fontPath = servletContext.getRealPath("/WEB-INF/resources/fonts/NanumGothic.ttf");
            PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H);
            
            System.out.println(font);
            document.setFont(font);

            // PDF 내용 작성
            document.add(new Paragraph("근로 계약서"));
            document.add(new Paragraph("사업주명: " + contract.getOwnername()));
            document.add(new Paragraph("사업자 번호: " + contract.getBusinessNumber()));
            document.add(new Paragraph("알바생명: " + contract.getParttimename()));
            document.add(new Paragraph("근무 시작 날짜: " + contract.getPeriod_start()));
            document.add(new Paragraph("근무 종료 날짜: " + contract.getPeriod_end()));
            document.add(new Paragraph("근무 장소: " + contract.getPlace()));
            document.add(new Paragraph("업무 내용: " + contract.getWorkdetail()));
            document.add(new Paragraph("근무 시작 시간: " + contract.getWorkinghours_start()));
            document.add(new Paragraph("근무 종료 시간: " + contract.getWorkinghours_end()));
            document.add(new Paragraph("주당 근무일: " + contract.getWorkday()));
            document.add(new Paragraph("임금: " + contract.getMoney()));
            document.add(new Paragraph("상여금: " + contract.getBonus()));
            document.add(new Paragraph("보험: " + contract.getInsurance()));
            document.add(new Paragraph("작성 날짜: " + contract.getCreatedate()));

            // 사인 이미지 추가
            String signaturePath = servletContext.getRealPath("/resources/images/" + contract.getSinefilename());
            ImageData imageData = ImageDataFactory.create(signaturePath);
            Image signatureImage = new Image(imageData);
            signatureImage.setWidth(100); // 이미지 너비 설정
            document.add(signatureImage);
            
            document.close();

            byte[] pdfBytes = byteArrayOutputStream.toByteArray();

            // HTTP 응답 설정
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/pdf");
            headers.add("Content-Disposition", "attachment; filename=contract_" + num + ".pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
