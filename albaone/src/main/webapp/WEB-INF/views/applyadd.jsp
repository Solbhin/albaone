<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>채용 지원하기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container">
    <h2>채용 지원하기</h2>
    <form action="${pageContext.request.contextPath}/apply" method="post">
        <!-- 숨겨진 필드로 postNumber를 전송 -->
        <input type="hidden" name="postNumber" value="${postNumber}"/>

        <!-- 이력서 선택 -->
        <div class="form-group">
            <label for="resume_Id">이력서 선택:</label>
            <select id="resume_Id" name="resumeId" class="form-control" required>
                <option value="" disabled selected>이력서를 선택하세요</option>
                <c:forEach var="resume" items="${resumes}">
                    <option value="${resume.number}">${resume.name}</option>
                </c:forEach>
            </select>
        </div>

        <!-- 숨겨진 필드로 현재 선택된 이력서의 number를 전송 -->
        <input type="hidden" id="resumeNumber" name="number" value=""/>

        <!-- 이력서 제목 입력 -->
        <div class="form-group">
            <label for="resumetitle">이력서 제목:</label>
            <input type="text" id="resumetitle" name="resumetitle" class="form-control" required/>
        </div>

        <!-- 제출 버튼 -->
        <button type="submit" class="btn btn-primary">지원하기</button>
    </form>

    <!-- 에러 메시지 출력 -->
    <c:if test="${not empty param.error}">
        <div class="alert alert-danger" role="alert">${param.error}</div>
    </c:if>
</div>

<!-- Bootstrap 및 jQuery 스크립트 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- JavaScript 코드로 선택한 이력서의 number를 숨겨진 필드에 설정 -->
<script>
    document.getElementById('resume_Id').addEventListener('change', function() {
        document.getElementById('resumeNumber').value = this.value;
    });
</script>
</body>
</html>
