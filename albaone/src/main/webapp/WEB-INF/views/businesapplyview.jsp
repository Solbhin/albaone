<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지원자 상세 정보</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="menu.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center mb-4">지원자 상세 정보</h2>

        <!-- 카드 형태로 상세 정보 출력 -->
        <c:forEach var="businesview" items="${businesview}">
            <div class="card">
                <div class="card-header">
                    <h4>${businesview.name}님의 정보</h4>
                </div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <th>이름</th>
                                <td>${businesview.name}</td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>${businesview.email}</td>
                            </tr>
                            <tr>
                                <th>전화번호</th>
                                <td>${businesview.contact}</td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>${businesview.address}</td>
                            </tr>
                            <tr>
                                <th>이력서 제목</th>
                                <td>${businesview.resumetitle}</td>
                            </tr>
                            <tr>
                                <th>회사명</th>
                                <td>${businesview.companyName}</td>
                            </tr>
                            <tr>
                                <th>근무 위치</th>
                                <td>${businesview.workLocation}</td>
                            </tr>
                            <tr>
                                <th>근무 시간</th>
                                <td>${businesview.workHours}</td>
                            </tr>
                            <tr>
                                <th>근무일</th>
                                <td>${businesview.workDays}</td>
                            </tr>
                            <tr>
                                <th>급여</th>
                                <td>${businesview.salary} 원</td>
                            </tr>
                            <tr>
                                <th>직무 설명</th>
                                <td>${businesview.jobDescription}</td>
                            </tr>
                            <tr>
                            	<th>사진 </th>
                            	<td><img src="${pageContext.request.contextPath}/resources/images/${businesview.myimgName}" alt="사진" width="100"></td>
                            </tr>
                            <tr>
                                <th>지원 상태</th>
                                <td>
                                    <c:choose>
                                        <c:when test="${businesview.status == '지원 중'}">
                                            <span class="badge badge-warning">지원 중</span>
                                        </c:when>
                                        <c:when test="${businesview.status == '수락'}">
                                            <span class="badge badge-success">수락</span>
                                        </c:when>
                                        <c:when test="${businesview.status == '거절'}">
                                            <span class="badge badge-danger">거절</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge badge-secondary">상태 미정</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- 상태와 상관없이 버튼을 항상 표시합니다. -->
            <div class="text-center mt-4">
            	<!-- 계약서 폼 가기전 상태파라미터와 알바생 정보 파라미터 가지고 가기 -->
                <a href="employmentcontract?apply_id=${businesview.apply_id}&status=accepted&postNumber=${postNumber}&parttimename=${businesview.name}&parttimephone=${businesview.contact}&parttimeaddress=${businesview.address}&id=${businesview.id}&parttimeid=${id}" class="btn btn-primary"  data-status="${businesview.status}" onclick="handleClick(event, this)">채용 하기</a>
                <a href="updateStatus?apply_id=${businesview.apply_id}&status=rejected&postNumber=${postNumber}" class="btn btn-danger">채용 거절</a>
            </div>
        </c:forEach>

        <!-- 뒤로 가기 버튼 -->
        <div class="text-center mt-4">
            <button onclick="window.history.back();" class="btn btn-secondary">목록으로 돌아가기</button>
        </div>
    </div>

    <!-- 부트스트랩 JS 및 의존성 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/albaone/resources/js/businesapplyview.js"></script> 
</body>
</html>
