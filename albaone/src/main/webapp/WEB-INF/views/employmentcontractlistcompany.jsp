<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>근로 계약서 목록(사업주 전용 페이지)</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<%@include file="menu.jsp" %>

    <h1>근로 계약서 목록</h1>
    <c:if test="${not empty contract}">
        <table border="1">
            <thead>
                <tr>
                    <th>알바생 이름</th>
                    <th>전화번호</th>
                    <th>근무 시작</th>
                    <th>근무 종료</th>
                    <th>근로 장소</th>
                    <th>업무 내용</th>
                    <th>근로 시작 시간</th>
                    <th>근로 종료 시간</th>
                    <th>주당 근무일</th>
                    <th>임금</th>
                    <th>상여금</th>
                    <th>보험</th>
                    <th>작성 날짜</th>
                    <th>사측 사인</th>
                    <th>알바생 사인</th>
                    <td>PDF로 다운</td>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contract" items="${contract}">
                    <tr>
                        <td>${contract.parttimename}</td>
                        <td>${contract.parttimePhone}</td>
                        <td>${contract.period_start}</td>
                        <td>${contract.period_end}</td>
                        <td>${contract.place}</td>
                        <td>${contract.workdetail}</td>
                        <td>${contract.workinghours_start}</td>
                        <td>${contract.workinghours_end}</td>
                        <td>${contract.workday}</td>
                        <td>${contract.money}</td>
                        <td>${contract.bonus}</td>
                        <td>${contract.insurance}</td>
                        <td>${contract.createdate}</td>
                        <!-- 사인 파일 경로 -->
                        <td><img src="resources/images/${contract.sinefilenameowner}" alt="사장 사인" width="50"></td>
                      	<td><img src="resources/images/${contract.sinefilenameparttime}" alt="알바생 사인" width="50"></td>
                        <!-- 클릭시 PDF 다운로드 미완성 - 다운만 가능 디자인 안됨 -->
                        <td><a href="downloadPDF?num=${contract.num}">다운로드 테스트</a></td>
                        
                        <!--
                        	해고 되고 3년간 의무 보관 - 해고되고 3년 뒤부터 삭제 가능하도록
                        	데이터 테이블에 퇴직 날짜가 없어 나중에 구현하는 것으로 함
                        -->
                        <td><a href="#" class="delete-link" data-num="${contract.num}">삭제</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty contract}">
        <p>등록된 근로 계약서가 없습니다.</p>
    </c:if>
    
    <script>
	    $(document).ready(function() {
	        $(".delete-link").on("click", function(event){
	            event.preventDefault(); // 기본 링크 클릭 동작 방지
	            var link = $(this);
	            var num = link.data("num"); // 데이터 속성에서 num 가져오기
	
	            if (confirm('정말 삭제하시겠습니까?'))
	            {
	                $.ajax({
	                    url: "empcomdel",
	                    type: "GET",
	                    data: { num: num },
	                    success: function(response)
	                    {
	                        // 삭제가 성공적으로 이루어졌다면 해당 행을 삭제
	                        link.closest("tr").remove(); // 삭제된 행을 테이블에서 제거
	                    },
	                    error: function()
	                    {
	                        alert('삭제 중 오류가 발생했습니다. 다시 시도해 주세요.');
	                    }
	                });
	            }
	        });
	    });
</script>
</body>
</html>

