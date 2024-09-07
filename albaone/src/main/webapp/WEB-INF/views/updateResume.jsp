<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/albaone/resources/css/resume.css">
<title>이력서 수정</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container resume">
    <div class="card">
        <div class="card-body">
            <i class="bi bi-file-earmark-fill"></i>
            <h2>지원서 수정</h2>
            <form action="resumeupdate?number=${resume.number}" method="post" enctype="multipart/form-data" modelAttribute="updateResume" onsubmit="return validateFile();">
                <!-- 성명 및 사진 -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">성명</label>
                            <input type="text" class="form-control" id="name" name="name" value="${resume.name}" required readonly>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="photo">사진 (최근 6개월 이내)</label>
                            <input type="file" class="form-control" name="myimg">
                            <small>현재 사진: ${resume.myimgName}</small>
                        </div>
                    </div>
                </div>
                
                <!-- 생년월일 및 성별 -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="birthdate">생년월일</label>
                            <input type="date" class="form-control" id="birthdate" name="birthdate" value="${resume.birthdate}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="gender">성별</label>
                            <div class="d-flex">
                                <div class="form-check me-3">
                                    <input type="radio" class="form-check-input" id="genderMale" name="gender" value="남성" ${resume.gender == '남성' ? 'checked' : ''} required>
                                    <label class="form-check-label" for="genderMale">남성</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="genderFemale" name="gender" value="여성" ${resume.gender == '여성' ? 'checked' : ''} required>
                                    <label class="form-check-label" for="genderFemale">여성</label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- 연락처 및 이메일 -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="contact">연락처</label>
                            <input type="text" class="form-control" id="contact" name="contact" value="${resume.contact}" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="email">e-mail</label>
                            <input type="email" class="form-control" id="email" name="email" value="${resume.email}" required>
                        </div>
                    </div>
                </div>
                
                <!-- 주소 -->
                <div class="form-group mb-3">
                    <label for="address">현 주소 (우편번호: - )</label>
                    <input type="text" class="form-control" id="address" name="address" value="${resume.address}" required>
                </div>                
				<!-- 학력사항 -->
				<div class="form-group mb-3">
				    <label for="education">학력사항</label>
				    <div id="educationFields">
				        <c:forEach var="edu" items="${schools}" varStatus="status">
				            <div class="education-row mb-3">
				                <input type="text" class="form-control" name="schools[]" value="${edu}" placeholder="학교명" required>
				                <input type="text" class="form-control mt-2" name="periods[]" value="${periods[status.index]}" placeholder="기간" required>
				                <input type="text" class="form-control mt-2" name="majors[]" value="${majors[status.index]}" placeholder="전공" required>
				            </div>
				        </c:forEach>
				        <button type="button" class="btn btn-secondary mt-3" onclick="addEducationField()">학력 추가</button>
				    </div>
				</div>
				
				<!-- 경력사항 -->
				<div class="form-group mb-3">
				    <label for="experience">아르바이트 경력사항</label>
				    <div id="experienceFields">
						<c:forEach var="exp" items="${jobTitles}" varStatus="status">
						    <div class="experience-row mb-3">
						        <input type="text" class="form-control" name="jobTitles[]" value="${exp}" placeholder="직장명" required>
						        <input type="text" class="form-control mt-2" name="experiencePeriods[]" value="${experiencePeriods[status.index]}" placeholder="기간" required>
						        <input type="text" class="form-control mt-2" name="mainWorks[]" value="${mainWorks[status.index]}" placeholder="주요 업무" required>
						    </div>
						</c:forEach>
				        <button type="button" class="btn btn-secondary mt-3" onclick="addExperienceField()">경력 추가</button>
				    </div>
				</div>

                <!-- 지원동기 -->
                <div class="form-group mb-3">
                    <label for="reason">지원동기</label>
                    <textarea class="form-control" id="reason" name="reason" rows="4" required>${resume.reason}</textarea>
                </div>
                
                <!-- 근무시간, 희망 시급, 희망 휴일 -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="work_hours">근무시간</label>
                            <input type="text" class="form-control" id="work_hours" name="work_hours" value="${resume.work_hours}" placeholder="예: 09:00 ~ 18:00" required>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="desired_salary">희망시급</label>
                            <input type="text" class="form-control" id="desired_salary" name="desired_salary" value="${resume.desired_salary}" placeholder="원/시간" required>
                        </div>
                    </div>
                </div>
                <div class="form-group mb-3">
                    <label for="desired_days">희망휴일</label>
                    <input type="text" class="form-control" id="desired_days" name="desired_days" value="${resume.desired_days}" required>
                </div>
                
                <!-- 버튼 -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">수정 완료</button>
                    <a href="${pageContext.request.contextPath}/resumecancel" class="btn btn-danger">취소</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/albaone/resources/js/resume.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>
