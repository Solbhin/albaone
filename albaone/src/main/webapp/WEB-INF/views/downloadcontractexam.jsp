<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PDF 샘플</title>
</head>
<body>
	<%@include file="menu.jsp" %>

	<!-- 임시 조회 -->
	<p>사업주 : ${ contract.ownername } 전화번호 ${contract.ownerPhone }
	<p>사업주 주소 : ${contract.owneraddr }
	<p>알바생명 : ${ contract.parttimename } 전화번호 ${ contract.parttimePhone }
	<p>알바생 주소 : ${ contract.parttimeaddr }
	<!-- 계약 종료 기간이 없는 경우를 if 문으로 따로 적어야 함 -->
	<p>계약 기간 : ${ contract.period_start } ~ ${ contract.period_start }
	<p>근로 장소 : ${ contract.place }
	<p>근무 시간 : ${ contract.workinghours_start } ~ ${ contract.workinghours_end }
	<p>주당 근무일 : ${ contract.workday }
	<p>임금 : ${ contract.money }
	<p>상여금 : ${ contract.bonus }
	<p>보험 : ${ contract.insurance }
	<p>사업주 사인
	<img src="resources/images/${contract.sinefilenameowner}" alt="사장 사인" width="50">
	<p>알바 사인
	<img src="resources/images/${contract.sinefilenameparttime}" alt="알바생 사인" width="50">
	
	<!-- 클릭시 PDF 다운로드 미완성 - 다운만 가능 디자인 안됨 -->
	<p><a href="downloadPDF?num=${contract.num}">PDF로 다운로드하기</a></p>
</body>
</html>