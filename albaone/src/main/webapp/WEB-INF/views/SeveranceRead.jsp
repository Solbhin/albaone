<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>퇴직금 조회</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<%@include file="menu.jsp"%>
<!-- 기업 회원일 경우 -->
<c:if test="${not empty sessionScope.businessNumber && not empty sessionScope.id}">
    <h1>알바생 퇴직금 조회하기</h1>
    <form id="searchForm">
        <p>알바생 이름으로 조회: <input type="text" id="parttimeNameInput"></p>
        <button type="button" id="searchParttimeBtn">조회</button>
    </form>
    
    <div id="severanceList_com">
        <c:forEach var="severance" items="${severanceList_com}">
            <div class="severance-item" data-parttimename="${severance.parttimename}" data-company="${severance.company}" data-money="${severance.money}">
                <p> 알바생명 : ${severance.parttimename} </p> 
                <p> 회사명 : ${severance.company} </p>
                <p> 퇴직금 : ${severance.money} </p> 
                <hr>
            </div>
        </c:forEach>
    </div>
</c:if>

<!-- 일반 회원일 경우 -->
<c:if test="${empty sessionScope.businessNumber && not empty sessionScope.id}">
    <h1>받은 퇴직금 조회</h1>
    <form id="searchFormAlba">
        <p>회사명으로 조회: <input type="text" id="companyNameInput"></p>
        <button type="button" id="searchCompanyBtn">조회</button>
    </form>
    
    <div id="severanceList_alba">
        <c:forEach var="severance" items="${severanceList_alba}">
            <div class="severance-item" data-parttimename="${severance.parttimename}" data-company="${severance.company}" data-money="${severance.money}">
                <p> 알바생명 : ${severance.parttimename} </p> 
                <p> 회사명 : ${severance.company} </p> 
                <p> 퇴직금 : ${severance.money} </p> 
                <hr>
            </div>
        </c:forEach>
    </div>
</c:if>

<script type="text/javascript">
    $(document).ready(function(){
        // 알바생 이름으로 조회
        $('#searchParttimeBtn').click(function(){
            var inputName = $('#parttimeNameInput').val().toLowerCase();
            $('#severanceList_com .severance-item').each(function() {
                var parttimeName = $(this).data('parttimename').toLowerCase();
                if (parttimeName.includes(inputName)) {
                    $(this).show(); // 조건에 맞으면 보여줌
                } else {
                    $(this).hide(); // 조건에 맞지 않으면 숨김
                }
            });
        });

        // 회사명으로 조회
        $('#searchCompanyBtn').click(function() {
            var inputCompany = $('#companyNameInput').val().toLowerCase();
            $('#severanceList_alba .severance-item').each(function() {
                var companyName = $(this).data('company').toLowerCase();
                if (companyName.includes(inputCompany)) {
                    $(this).show(); // 조건에 맞으면 보여줌
                } else {
                    $(this).hide(); // 조건에 맞지 않으면 숨김
                }
            });
        });
    });
</script>

</body>
</html>
