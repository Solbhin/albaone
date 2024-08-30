<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>PDF 샘플</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> 
</head>
<body>
    <%@include file="menu.jsp" %>

    <div class="container mt-5">
        <div id="contract" class="bg-light p-4 rounded">
            <h2 class="text-center mb-4">표준 근로 계약서</h2>

            <!-- 계약 기간 -->
            <p>계약 기간: ${contract.period_start} ~ ${contract.period_end}</p>
            <p>근로 장소: ${contract.place}</p>
            <p>근무 시간: ${contract.workinghours_start} ~ ${contract.workinghours_end}</p>
            <p>주당 근무일: ${contract.workday}</p>
            <p>임금: ${contract.money}</p>
            <p>상여금: ${contract.bonus}</p>
            <p>보험: ${contract.insurance}</p>

            <hr>

            <h4>사업주 정보</h4>
            <p>사업주 이름: ${contract.ownername}</p>
            <p>사업주 전화번호: ${contract.ownerPhone}</p>
            <p>사업주 주소: ${contract.owneraddr}</p>

            <hr>

            <h4>알바생 정보</h4>
            <p>알바생 이름: ${contract.parttimename}</p>
            <p>알바생 전화번호: ${contract.parttimePhone}</p>
            <p>알바생 주소: ${contract.parttimeaddr}</p>

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
        </div>

        <!-- PDF 다운로드 버튼 -->
        <div class="text-center mt-4">
            <button class="btn btn-danger" onclick="downloadPDF()">PDF로 다운로드하기</button>
        </div>
    </div>

    <script type="text/javascript" src="/albaone/resources/js/downloadcontractexam.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.5/jspdf.min.js"></script>
</body>
</html>
