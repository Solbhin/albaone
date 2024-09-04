<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>지원자 목록</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="menu.jsp" %>
    <div class="container mt-5">
        <h2 class="text-center">지원자 목록</h2>
        <div class="table-responsive">
            <table class="table table-bordered table-hover mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">이름</th>
                        <th scope="col">이메일</th>
                        <th scope="col">전화번호</th>
                        <th scope="col">주소</th>
                        <th scope="col">이력서 제목</th>
                        <th scope="col">근무 위치</th>
                        <th scope="col">근무 시간</th>
                        <th scope="col">근무일</th>
                        <th scope="col">급여</th>
                        <th scope="col">직무 설명</th>
                        <th scope="col">사진<th>
                        <th scope="col">지원 상태</th>
                        <th scope="col">상세보기</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="apply" items="${businesapply}">
                        <tr>
                            <td>${apply.name}</td>
                            <td>${apply.email}</td>
                            <td>${apply.contact}</td>
                            <td>${apply.address}</td>
                            <td>${apply.resumetitle}</td>
                            <td>${apply.workLocation}</td>
                            <td>${apply.workHours}</td>
                            <td>${apply.workDays}</td>
                            <td>${apply.salary}원</td>
                            <td>${apply.jobDescription}</td>
                            <td><img src="${pageContext.request.contextPath}/resources/images/${apply.myimgName}" alt="사진" width="100"></td>
                            <td>
                            <c:choose>
                                <c:when test="${apply.status == '지원 중'}">
                                   <span class="badge badge-warning">지원 중</span>
                                </c:when>
                                <c:when test="${apply.status == '수락'}">
                                    <span class="badge badge-success">수락</span>
                                </c:when>
                                <c:when test="${apply.status == '거절'}">
                                    <span class="badge badge-danger">거절</span>
                                </c:when>
                                <c:otherwise>
                                     <span class="badge badge-secondary">상태 미정</span>
                                </c:otherwise>
                            </c:choose>
                            </td>
                            <td><a href="businesapplyview?apply_id=${apply.apply_id}&postNumber=${postNumber}" class="btn btn-primary">상세보기</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- 뒤로 가기 버튼 -->
        <div class="text-center mt-4">
            <button onclick="window.history.back();" class="btn btn-secondary">목록으로 돌아가기</button>
        </div>
    </div>

    <!-- 부트스트랩 JS 및 의존성 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>