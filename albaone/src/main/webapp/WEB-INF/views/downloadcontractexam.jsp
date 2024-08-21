<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PDF 샘플</title>
<!-- <link rel="stylesheet" href="/resources/css/downloadcontractexam.css"> -->
<link rel="stylesheet" href="/albaone/resources/css/downloadcontractexam.css">
</head>
<body>
	<%@include file="menu.jsp" %>
	<!-- 임시 조회 -->
    <div id="contract">
    	<p id="title">표준 근로 계약서
        <p>사업주 이름 : ${ contract.ownername }</p>
        <p>사업주 전화번호 ${contract.ownerPhone }</p>
        <p>사업주 주소 : ${contract.owneraddr }</p>
        <br>
        <p>알바생 이름 : ${ contract.parttimename }</p>
        <p>알바생 전화번호 ${ contract.parttimePhone }</p>
        <p>알바생 주소 : ${ contract.parttimeaddr }</p>
        <br>
        <!-- 계약 종료 기간이 없는 경우를 if 문으로 따로 적어야 함 -->
        <p>계약 기간 : ${ contract.period_start } ~ ${ contract.period_start }</p>
        <p>근로 장소 : ${ contract.place }</p>
        <p>근무 시간 : ${ contract.workinghours_start } ~ ${ contract.workinghours_end }</p>
        <p>주당 근무일 : ${ contract.workday }</p>
        <p>임금 : ${ contract.money }</p>
        <p>상여금 : ${ contract.bonus }</p>
        <p>보험 : ${ contract.insurance }</p>
        
        <br>

        <p>사업주 사인</p>
        <p><img src="resources/images/${contract.sinefilenameowner}" alt="사장 사인" width="50"></p>
        
        <br>

        <p>알바 사인</p>
        <p><img src="resources/images/${contract.sinefilenameparttime}" alt="알바생 사인" width="50"></p>
    </div>
	
	<!-- 클릭시 PDF 다운로드 미완성 - 다운만 가능 디자인 안됨 -->
    <div id="button"><button onclick="downloadPDF()">PDF로 다운로드하기</button></div>

    <script>
        function downloadPDF()
        {
            window.location.href = `downloadPDF?num=${contract.num}`;
        }
    </script>
</body>
</html>