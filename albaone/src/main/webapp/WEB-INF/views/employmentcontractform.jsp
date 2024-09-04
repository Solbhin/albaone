<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근로계약서</title>
<link rel="stylesheet" href="/albaone/resources/css/employmentcontractform.css"> 
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="menu.jsp" %>
    <div class="container mt-5" id="form">
        <h2 class="text-center">표준 계약서 작성</h2>
        <form action="employmentcontract" method="post" modelAttribute="employment" enctype="multipart/form-data">
            <!-- 사업주 정보 -->
            <div class="form-row">
                <div class="form-group col-md-6">
	                <label for="ownername">사업주 성명</label>
	                <input type="text" class="form-control" id="ownername" name="ownername" value="${ user.name }" readonly>
	            </div>
	            <div class="form-group col-md-6">
	                <label for="BusinessNumber">사업자 번호</label>
	                <input type="text" class="form-control" id="BusinessNumber" name="BusinessNumber" value="${BusinessNumber }" readonly>
	            </div>
	            <div class="form-group col-md-6">
	                <label for="ownerPhone">사업주 연락처</label>
	                <input type="text" class="form-control" id="ownerPhone" name="ownerPhone" value="${ user.phone  }">
	            </div>
            </div>

            <div class="form-group">
                <label for="owneraddr">사업주 주소</label>
                <input type="text" class="form-control" id="owneraddr" name="owneraddr" maxlength="40">
            </div>

            <!-- 알바생 정보 -->
            <div class="form-row">
	            <div class="form-group col-md-6">
	                <label for="parttimename">알바생 성명</label>
	                <input type="text" class="form-control" id="parttimename" name="parttimename" value="${ parttimename }" maxlength="40">
	            </div>
	            <div class="form-group col-md-6">
	                <label for="parttimePhone">사업주 연락처</label>
	                <input type="text" class="form-control" id="parttimePhone" name="parttimePhone" value="${ parttimephone }" maxlength="11">
	            </div>
            </div>
            
            <div class="form-group">
                <label for="parttimeaddr">알바생 주소</label>
                <input type="text" class="form-control" id="parttimeaddr" name="parttimeaddr" value="${ parttimeaddress }" maxlength="40">
            </div>
            
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="period_start">근무 시작 날짜</label>
                    <input type="date" class="form-control" id="period_start" name="period_start"required>
                </div>
                <div class="form-group col-md-6">
                    <label for="period_start">근무 종료 날짜</label>
                    <input type="date" class="form-control" id="period_end" name="period_end">
                </div>
            </div>
            
            <div id="worktime" class="form-group col-md-6">
                <label for="startCheckbox">근무 시작 시간</label>
                <input type="checkbox" id="startCheckbox" onchange="toggleWorkingHoursStart()"> 직접 입력
                <select id="workinghours_start" name="workinghours_start" class="form-select">
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
                <input type="text" id="workinghours_start_input" name="workinghours_start" placeholder="근무 시작 시간" class="form-control mt-2" style="display:none">
                	<label for="endCheckbox">근무 종료 시간</label>
                    <input type="checkbox" id="endCheckbox" onchange="toggleWorkingHoursEnd()"> 직접 입력
                    <select id="workinghours_end" name="workinghours_end" class="form-select">
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
                    <input type="text" id="workinghours_end_input" name="workinghours_end" placeholder="근무 종료 시간" class="form-control mt-2" style="display:none">
            </div>

            <div class="form-group">
                <label for="workday">주 근무일</label>
                <br>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="월" checked>
                    <label class="form-check-label" for="workday">월</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="화">
                    <label class="form-check-label" for="workday">화</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="수">
                    <label class="form-check-label" for="workday">수</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="목">
                    <label class="form-check-label" for="workday">목</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="금">
                    <label class="form-check-label" for="workday">금</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="토">
                    <label class="form-check-label" for="workday">토</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="workday" name="workday" value="일">
                    <label class="form-check-label" for="workday">일</label>
                </div>
            </div>
            
            <div class="form-row">
	            <div class="form-group col-md-6">
	                <label for="place">근무장소</label>
	                <input type="text" class="form-control" id="place" name="place">
	            </div>
            </div>            


            <div class="form-group">
                <label for="reason">업무내용</label>
                <textarea class="form-control" id="reason" name="workdetail" rows="4" placeholder="업무 내용을 입력하세요"></textarea>
            </div>
            
            <div class="form-row">
	            <div class="form-group col-md-6">
	                <label for="money">임금</label>
	                <input type="number" class="form-control" id="money" name="money"  min="9860" required placeholder="최저시급 9860">
	            </div>
	
	            <div class="form-group col-md-6">
	                <label for="money">상여금</label>
	                <input type="number" class="form-control" name="bonus" required placeholder="없으면 0을 입력" min="0"></p>
	            </div>
            </div>

            <div class="form-group">
                <label for="workday">보험</label>
                <br>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="insurance" name="insurance" value="고용보험">
                    <label class="form-check-label" for="insurance">고용보험</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="insurance" name="insurance" value="산재보험">
                    <label class="form-check-label" for="insurance">산재보험</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="insurance" name="insurance" value="국민연금">
                    <label class="form-check-label" for="insurance">국민연금</label>
                </div>
                <div class="form-check form-check-inline">
                    <input type="checkbox" class="form-check-input" id="insurance" name="insurance" value="건강보험">
                    <label class="form-check-label" for="insurance">건강보험</label>
                </div>
            </div>
            
            <div class="form-row">
            	<div class="form-group col-md-6">
	                <label for="createdate">작성 날짜</label>
	                <input type="date" class="form-control" id="createdate" name="createdate" required>
	            </div>
	
	            <div class="form-group col-md-6">
	                <label for="sinefileowner">사업주 사인</label>
	                <input type="file" class="form-control" id="sinefileowner" name="sinefileowner" required>
	            </div>
	
	            <div class="form-group col-md-6">
	                <label for="sinefileparttime">알바생 사인</label>
	                <input type="file" class="form-control" id="sinefileparttime" name="sinefileparttime">
	            </div>
            </div>

            <!-- 다른 페이지에서 사용할 값들, 히든 처리 -->
            <input type="hidden" value="${employeeId}" name="employeeId">
            <input type="hidden" value="${apply_id}" name="apply_id">
            <input type="hidden" value="${status}" name="status">
            <input type="hidden" value="${postNumber}" name="postNumber"> 
            <input type="hidden" value="${parttimeid}" name="parttimeid"> 

            <div class="text-left" id="button">
                <button type="submit" class="btn">작성 완료</button>
            </div>
        </form>
    </div>

    <footer>
        <%@include file="footer.jsp" %>
    </footer>
    
    <script type="text/javascript" src="/albaone/resources/js/employmentcontractform.js"></script>
</body>
</html>