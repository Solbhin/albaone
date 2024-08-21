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
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.itextpdf.layout.properties.TextAlignment;
import com.springmvc.domain.Employmentcontract;
import com.springmvc.service.*;

@Controller
public class EmploymentcontractController
{
	@Autowired
	private EmploymentcontractServiceImpl employmentcontractService;
	
    @Autowired
    private ApplyServiceImpl applyService;
	
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
			@RequestParam("parttimename")String parttimename,
			@RequestParam("parttimephone")String parttimephone,
			@RequestParam("parttimeaddress")String parttimeaddress,
			Model model,
			HttpSession session
	)
	{
		String id = (String) session.getAttribute("id");
		model.addAttribute("apply_id", apply_id);
		model.addAttribute("status", status);
		model.addAttribute("postNumber", postNumber);
		model.addAttribute("user", UserServiceImpl.findUserById(id));
		model.addAttribute("BusinessNumber",UserServiceImpl.findBusinessNumber(id));
		if(parttimename != null)
		{
			model.addAttribute("parttimename",parttimename);
		}
		if(parttimephone != null)
		{
			model.addAttribute("parttimephone",parttimephone);
		}
		if(parttimeaddress != null)
		{
			model.addAttribute("parttimeaddress",parttimeaddress);
		}
				
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
			@RequestParam(value = "insurance", required = false) List<String> insurance,
			@RequestParam("workinghours_start") String workingHoursStart,
	        @RequestParam("workinghours_end") String workingHoursEnd,
	        @RequestParam(value = "workday", required = false) String workday,
			BindingResult result,
			HttpServletRequest req)
	{
		if(result.hasErrors()){return "resume";}
		
		String root = req.getServletContext().getRealPath("/resources/images");//저장 경로
		
		//sineName - 파일명, 파라미터
		MultipartFile sineNameowner = employmentcontract.getSinefileowner();//멀티 파츠로 파일 생성
		MultipartFile sineNameparttime = employmentcontract.getSinefileparttime();
		System.out.println(sineNameowner);
		System.out.println(sineNameparttime);
		
		String saveNameowner = sineNameowner.getOriginalFilename();//원래 파일명
		String saveNameparttime = sineNameparttime.getOriginalFilename();
		
		File saveFileowner = new File(root ,saveNameowner);
		File saveFileparttime = new File(root ,saveNameparttime);
		
		if(sineNameowner !=null && !sineNameowner.isEmpty())
		try
		{
			sineNameowner.transferTo(saveFileowner);
			employmentcontract.setSinefilenameowner(saveNameowner);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(sineNameparttime !=null && !sineNameparttime.isEmpty())
		try
		{
			sineNameparttime.transferTo(saveFileparttime);
			employmentcontract.setSinefilenameparttime(saveNameparttime);
		}
		catch(Exception e)
		{
				e.printStackTrace();
		}
		
		// 체크박스로 받은 보험 항목을 문자열로 변환하여 employmentcontract에 설정
	    if (insurance != null && !insurance.isEmpty())
	    {
	    	// 리스트를 문자열로 변환
	        String insuranceString = String.join(", ", insurance);
	        employmentcontract.setInsurance(insuranceString); 
	    }
	    
	    //리스트의 ,제거 - select로 넘어올 경우의 ,제거
	    workingHoursStart = workingHoursStart.replace(",", "").trim();
	    workingHoursEnd = workingHoursEnd.replace(",", "").trim();
		
	    employmentcontract.setWorkinghours_start(workingHoursStart);
	    employmentcontract.setWorkinghours_end(workingHoursEnd);
	    
	    // 체크박스로 받은 근로날짜 항목을 문자열로 변환하여 employmentcontract에 설정
	    if (workday != null && !workday.isEmpty())
	    {
	    	// 리스트를 문자열로 변환
	        String workdayString = String.join(", ", workday);
	        employmentcontract.setWorkday(workdayString); 
	    }
	    
		employmentcontractService.create(employmentcontract);
		applyService.updateApplyStatus(apply_id,status,postNumber);
		
		return "redirect:/businesApplylist?postNumber="+postNumber;
	}
	
	// 사업자 번호로 계약서 조회
	@GetMapping("/contracts")
	public String getContractsByPartTimeName(HttpSession session , Model model)
	{
		String id = (String) session.getAttribute("id");
		String BusinessNumber =  UserServiceImpl.findBusinessNumber(id);
		if (BusinessNumber != null && !BusinessNumber.isEmpty())
		{
			List<Employmentcontract> contracts = employmentcontractService.findAllByBusinessNumber(BusinessNumber);
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
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam int num, HttpSession session)
	{
	    employmentcontractService.deleteContractsByPartTimeName(num);
	    return ResponseEntity.ok("삭제되었습니다."); // 성공 메시지 반환
	}
	
	//다운로드 샘플 보여주기
	@GetMapping("/downloadcontractexam")
	public String downloadcontractexam
	(
			Model model,
			@RequestParam("num") int num
	)
	{
		model.addAttribute("contract",employmentcontractService.findByNum(num));
		return "downloadcontractexam";
	}
	
	// PDF 다운로드 메서드
	@GetMapping("/downloadPDF")
	public ResponseEntity<byte[]> downloadPDF(@RequestParam int num)
	{
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
	        String fontPath = servletContext.getRealPath("/resources/fonts/NanumGothic.ttf");
	        PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H);
	        document.setFont(font);

	        // PDF 내용 작성 (JSP 내용을 반영)
	        document.add(new Paragraph("표준 근로 계약서").setFontSize(30).setTextAlignment(TextAlignment.CENTER));
	        document.add(new Paragraph("사업주 이름: " + contract.getOwnername()));
	        document.add(new Paragraph("사업주 전화번호: " + contract.getOwnerPhone()));
	        document.add(new Paragraph("사업주 주소: " + contract.getOwneraddr()));
	        document.add(new Paragraph("알바생 이름: " + contract.getParttimename()));
	        document.add(new Paragraph("알바생 전화번호: " + contract.getParttimePhone()));
	        document.add(new Paragraph("알바생 주소: " + contract.getParttimeaddr()));
	        document.add(new Paragraph("계약 기간: " + contract.getPeriod_start() + " ~ " + contract.getPeriod_end()));
	        document.add(new Paragraph("근로 장소: " + contract.getPlace()));
	        document.add(new Paragraph("근무 시간: " + contract.getWorkinghours_start() + " ~ " + contract.getWorkinghours_end()));
	        document.add(new Paragraph("주당 근무일: " + contract.getWorkday()));
	        document.add(new Paragraph("임금: " + contract.getMoney()));
	        document.add(new Paragraph("상여금: " + contract.getBonus()));
	        document.add(new Paragraph("보험: " + contract.getInsurance()));
	        document.add(new Paragraph("사업주 사인:"));
	        
	        // 사인 이미지 추가
	        String signaturePathowner = servletContext.getRealPath("/resources/images/" + contract.getSinefilenameowner());
	        ImageData imageDataowner = ImageDataFactory.create(signaturePathowner);
	        Image signatureImageowner = new Image(imageDataowner);
	        signatureImageowner.setWidth(50); // 이미지 너비 설정
	        document.add(signatureImageowner);
	        
	        document.add(new Paragraph("알바 사인:"));
	        String signaturePathparttime = servletContext.getRealPath("/resources/images/" + contract.getSinefilenameparttime());
	        ImageData imageDataparttime = ImageDataFactory.create(signaturePathparttime);
	        Image signatureImageparttime = new Image(imageDataparttime);
	        signatureImageparttime.setWidth(50); // 이미지 너비 설정
	        document.add(signatureImageparttime);
	        
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
