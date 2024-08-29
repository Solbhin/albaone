<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서</title>
<link rel="stylesheet" href="/albaone/resources/css/employmentcontractform.css"> 
</head>
<body>
	<%@include file="menu.jsp" %>
    <div id="form">
        <p id="title">표준 계약서 작성</p>
        <form action="employmentcontract" method="post" modelAttribute="employment" enctype="multipart/form-data">
            <p>사업주명 : <input type="text" name="ownername" value="${user.name}" readonly></p>
            <p>사업자 번호 : <input type="text" name="businessNumber" value="${BusinessNumber}" readonly></p>
            <p>사업주 전화번호 : <input type="text" name="ownerPhone" value="${ user.phone }"></p>
            <p>사업주 주소 : <input type="text" name="owneraddr" maxlength="40"></p>
            <br>
            <p>알바생명 : <input type="text" name="parttimename" value="${parttimename }"></p>
            <p>알바생 전화번호 : <input type="text" name="parttimePhone" value="${parttimephone}" maxlength="11"></p>
            <p>알바생 주소 : <input type="text" name="parttimeaddr" value="${parttimeaddress}" maxlength="40"></p>
            <br>
            <p>근무 날짜 :
                <input type="date" name="period_start"required>
                ~ <input type="date" name="period_end">
            </p>
            <p>근무장소 : <input type="text" name="place" required></p>
            <p>업무내용</p>
            <textarea rows="2" cols="50" name="workdetail" placeholder="업무 내용을 입력하세요"></textarea>
            <div id="worktime">
                <p>근무 시작 시간</p>
                <input type="checkbox" id="startCheckbox" onchange="toggleWorkingHoursStart()"> 직접 입력
                <select id="workinghours_start" name="workinghours_start">
                    <option value="00:00">00:00</option>
                    <option value="00:30">00:30</option>
                    <option value="01:00">01:00</option>
                    <option value="02:30">02:30</option>
                    <option value="02:00">02:00</option>
                    <option value="03:30">03:30</option>
                    <option value="03:00">03:00</option>
                    <option value="04:00">04:00</option>
                    <option value="04:30">04:30</option>
                    <option value="05:00">05:00</option>
                    <option value="05:30">05:30</option>
                    <option value="06:30">06:30</option>
                    <option value="06:00">06:00</option>
                    <option value="07:00">07:00</option>
                    <option value="07:30">07:30</option>
                    <option value="08:00">08:00</option>
                    <option value="08:30">08:30</option>
                    <option value="09:00">09:00</option>
                    <option value="09:30">09:30</option>
                    <option value="10:00">10:00</option>
                    <option value="10:30">10:30</option>
                    <option value="11:00">11:00</option>
                    <option value="11:30">11:30</option>
                    <option value="12:00">12:00</option>
                    <option value="12:30">12:30</option>
                    <option value="13:00">13:00</option>
                    <option value="13:30">13:30</option>
                    <option value="14:00">14:00</option>
                    <option value="14:30">14:30</option>
                    <option value="15:00">15:00</option>
                    <option value="15:30">15:30</option>
                    <option value="16:00">16:00</option>
                    <option value="16:30">16:30</option>
                    <option value="17:00">17:00</option>
                    <option value="17:30">17:30</option>
                    <option value="18:00">18:00</option>
                    <option value="18:00">18:30</option>
                    <option value="19:00">19:00</option>
                    <option value="19:30">19:30</option>
                    <option value="20:00">20:00</option>
                    <option value="20:30">20:30</option>
                    <option value="21:00">21:00</option>
                    <option value="21:30">21:30</option>
                    <option value="22:00">22:00</option>
                    <option value="22:30">22:30</option>
                    <option value="23:00">23:00</option>
                    <option value="23:30">23:30</option>
                </select>
                <input type="text" id="workinghours_start_input" name="workinghours_start" placeholder="근무 시작 시간" style="display:none">
                <p>근무 종료 시간</p>
                    <input type="checkbox" id="endCheckbox" onchange="toggleWorkingHoursEnd()"> 직접 입력
                    <select id="workinghours_end" name="workinghours_end">
                        <option value="00:00">00:00</option>
                        <option value="00:30">00:30</option>
                        <option value="01:00">01:00</option>
                        <option value="02:30">02:30</option>
                        <option value="02:00">02:00</option>
                        <option value="03:30">03:30</option>
                        <option value="03:00">03:00</option>
                        <option value="04:00">04:00</option>
                        <option value="04:30">04:30</option>
                        <option value="05:00">05:00</option>
                        <option value="05:30">05:30</option>
                        <option value="06:30">06:30</option>
                        <option value="06:00">06:00</option>
                        <option value="07:00">07:00</option>
                        <option value="07:30">07:30</option>
                        <option value="08:00">08:00</option>
                        <option value="08:30">08:30</option>
                        <option value="09:00">09:00</option>
                        <option value="09:30">09:30</option>
                        <option value="10:00">10:00</option>
                        <option value="10:30">10:30</option>
                        <option value="11:00">11:00</option>
                        <option value="11:30">11:30</option>
                        <option value="12:00">12:00</option>
                        <option value="12:30">12:30</option>
                        <option value="13:00">13:00</option>
                        <option value="13:30">13:30</option>
                        <option value="14:00">14:00</option>
                        <option value="14:30">14:30</option>
                        <option value="15:00">15:00</option>
                        <option value="15:30">15:30</option>
                        <option value="16:00">16:00</option>
                        <option value="16:30">16:30</option>
                        <option value="17:00">17:00</option>
                        <option value="17:30">17:30</option>
                        <option value="18:00">18:00</option>
                        <option value="18:00">18:30</option>
                        <option value="19:00">19:00</option>
                        <option value="19:30">19:30</option>
                        <option value="20:00">20:00</option>
                        <option value="20:30">20:30</option>
                        <option value="21:00">21:00</option>
                        <option value="21:30">21:30</option>
                        <option value="22:00">22:00</option>
                        <option value="22:30">22:30</option>
                        <option value="23:00">23:00</option>
                        <option value="23:30">23:30</option>
                    </select>
                    <input type="text" id="workinghours_end_input" name="workinghours_end" placeholder="근무 종료 시간" style="display:none">
            </div>
            
            <p>주당 근무일<br>
                월 <input type="checkbox" name="workday" value="월">
                화 <input type="checkbox" name="workday" value="화">
                수 <input type="checkbox" name="workday" value="수">
                목 <input type="checkbox" name="workday" value="목">
                금 <input type="checkbox" name="workday" value="금">
                토 <input type="checkbox" name="workday" value="토">
                일 <input type="checkbox" name="workday" value="일">
            </p>
            <p>임금 : <input type="number" name="money" min="9860" required placeholder="최저시급 9860"></p>
            <p>상여금 : <input type="number" name="bonus" required placeholder="없으면 0을 입력" min="0"></p>
            <p>보험<br>
                고용보험<input type="checkbox" id="insurance" name="insurance" value="고용보험">
                산재보험<input type="checkbox" id="insurance" name="insurance" value="산재보험">
                국민연금<input type="checkbox" id="insurance" name="insurance" value="국민연금">
                건강보험<input type="checkbox" id="insurance" name="insurance" value="건강보험">
            </p>
            <p>작성 날짜 : <input type="date" name="createdate" required></p>
            <p>사업주 사인 : <input type="file" name="sinefileowner" required></p>
            
            <!-- 사업주가 알바생 사인을 바로 받기는 힘들기 때문에 required 속성은 뺌 -->
            <p>알바생 사인 : <input type="file" name="sinefileparttime"></p>
            <p><input type="submit" value="등록" id="button"></p>
            <input type="hidden" value="${employeeId}" name="employeeId">
    
            <input type="hidden" value="${apply_id}" name="apply_id">
            <input type="hidden" value="${status}" name="status">
            <input type="hidden" value="${postNumber}" name="postNumber"> 
            <input type="hidden" value="${parttimeid}" name="parttimeid"> 
        </form>
    </div>

    <script type="text/javascript" src="/albaone/resources/js/employmentcontractform.js"></script>
</body>
</html>
