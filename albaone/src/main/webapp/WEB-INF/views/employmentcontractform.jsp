<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서</title>
</head>
<body>
	<%@include file="menu.jsp" %>
	
    <form action="employmentcontract" method="post" modelAttribute="employment">
        <p>사업주명 : <input type="text" name="ownername"></p>
        <p>알바생명 : <input type="text" name="parttimename"></p>
        <p>근무 날짜 : <input type="date" name="period_start"><input type="date" name="period_end"></p>
        <p>근무장소 : <input type="text" name="plcae"></p>
        <p>업무내용 : <input type="text" name="workdetail"></p>
        <p>근무 시간 : <input type="text" name="workinghours_start"><input type="text" name="workinghours_end"></p>
        <p>주당 근무일 : <input type="text" name="workday"></p>
        <p>임금 : <input type="text" name="money"></p>
        <p>상여금 : <input type="text" name="bonus"></p>
        <p>보험 : <input type="text" name="insurance"></p>
        <p>작성 날짜 : <input type="date" name="createdate"></p>
        <p><input type="submit" value="등록"></p>
        <input type="hidden" value="${apply_id}" name="apply_id">
        <input type="hidden" value="${status}" name="status">
        <input type="hidden" value="${postNumber}" name="postNumber">
    </form>
</body>
</html>
