<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>PDF 샘플</title>
    <link rel="stylesheet" href="/albaone/resources/css/font.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> 
    <link rel="stylesheet" href="/albaone/resources/css/downloadcontractexam.css">
</head>
<body>
    <%@include file="menu.jsp" %>

    <div class="container mt-5">
        <div id="contract" class="p-4 rounded">
            <h2 class="text-center mb-4">표준 근로 계약서</h2>

            <!-- 계약 기간 -->
            <div class="p">계약 기간: ${contract.period_start} ~ ${contract.period_end}</div>
            <span>노사가 협의하여 일을 하기로 한 기간</span>
            <div class="p">근로 장소: ${contract.place}</div>
            <span>일을 수행하기로 한 장소</span>
            <div class="p">근무 시간: ${contract.workinghours_start} ~ ${contract.workinghours_end}</div>
            <span>노사가 법정 근로 시간 내(하루 8시간, 주 40 시간) 내 하루 몇시간을 일할지 기재</span>
            <div class="p">주당 근무일: ${contract.workday}</div>
            <span>일주일 중 어떤 날 근무할지 기재</span>
            <div class="p">임금: ${contract.money}</div>
            <span>임금을 기재</span>
            <div class="p">상여금: ${contract.bonus}</div>
            <span>상여금의 유무와 그 금액에 대하여 기재</span>
            <div class="p">보험: ${contract.insurance}</div>
            <span>사회보험 적용 여부에 대해 기재</span>

            <hr>

            <h4>사업주 정보</h4>
            <div class="p">사업주 이름: ${contract.ownername}</div>
            <div class="p">사업주 전화번호: ${contract.ownerPhone}</div>
            <div class="p">사업주 주소: ${contract.owneraddr}</div>

            <hr>

            <h4>알바생 정보</h4>
            <div class="p">알바생 이름: ${contract.parttimename}</div>
            <div class="p">알바생 전화번호: ${contract.parttimePhone}</div>
            <div class="p">알바생 주소: ${contract.parttimeaddr}</div>

            <hr>

            <div class="sine">
                <div class="d-flex justify-content-end">
                    <div class="text-center mr-4">
                        <p>사업주 서명</p>
                        <img src="resources/images/${contract.sinefilenameowner}" alt="사장 사인" width="100">
                    </div>
                    <div class="text-center">
                        <p>알바생 서명</p>
                        <img src="resources/images/${contract.sinefilenameparttime}" alt="알바생 사인" width="100">
                    </div>
                    
                </div>
            </div>

            <hr>

            <br>

            
            <p class="text-center"><strong>-근로기준법 제17조에 따라 근로계약 체결시 근로자에게 교부하여야 함</strong></p>
            <p class="text-center"><strong>-사업주와 근로자는 각자가 근로계약, 취업규칙, 단체협약을 지키고 성실하게 이행하여야 함</strong></p>
            <p class="text-center"><strong>-이 계약에 정함이 없는 사항은 근로기준법령에 의함</strong></p>
            
            <br>
            
            <p class="text-right">작성 날짜 : ${contract.createdate}</p>
        </div>

        <!-- PDF 다운로드 버튼 -->
        <div class="text-center mt-4">
            <button class="btn" onclick="downloadPDF()">PDF로 다운로드하기</button>
        </div>
    </div>

	<!-- footer있어도 PDF에 포함 안됨 -->
	
    <script type="text/javascript" src="/albaone/resources/js/downloadcontractexam.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.min.js"></script>
</body>
</html>