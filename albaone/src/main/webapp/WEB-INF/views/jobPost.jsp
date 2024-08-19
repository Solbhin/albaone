<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>게시글 상세보기</title>
<style>
    .card {
        margin: 20px auto;
        max-width: 600px;
    }
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=44958d35fea409dd01c5a5b5f945ab12"></script>
<script>
    function initMap() {
        // 주소를 가져옵니다.
        var addr = document.getElementById("addr").value;

        // 주소를 좌표로 변환하기 위한 geocoder 생성
        var geocoder = new kakao.maps.services.Geocoder();

        // 주소로 좌표 변환
        geocoder.addressSearch(address, function(result, status) {
            if (status === kakao.maps.services.Status.OK) {
                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                // 지도 생성
                var map = new kakao.maps.Map(document.getElementById('map'), {
                    center: coords, // 지도의 중심 좌표
                    level: 3 // 지도의 확대 수준
                });

                // 마커 추가
                var marker = new kakao.maps.Marker({
                    position: coords
                });
                marker.setMap(map);
            } else {
                alert('주소 검색에 실패했습니다: ' + status);
            }
        });
    }

    // 페이지 로드 시 initMap 함수 호출
        window.onload = function() {
            // 카카오 객체가 준비되었는지 확인
            if (typeof kakao !== 'undefined' && kakao.maps) {
                initMap();
            } else {
                console.error('카카오 맵 API가 로드되지 않았습니다.');
            }
        };
</script>

</head>
<body>

    <%@include file="menu.jsp" %>
    
    <div class="container mt-4">
        <div class="card">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5>${jobPost.companyName}의 상세정보</h5>
                <div>
                	<c:if test="${jobPost.id == sessionScope.id}">
	                    <button class="btn btn-danger btn-sm" onclick="if(confirm('정말 삭제하시겠습니까?')) { location.href='deleteJobPost?postNumber=${jobPost.postNumber}'; }">삭제</button>
	                    <button class="btn btn-primary btn-sm" onclick="location.href='editJobPost?postNumber=${jobPost.postNumber}'">수정</button>
					</c:if>
                </div>
            </div>
            <div class="card-body">
            	<div id="map" style="height: 400px; width: 100%;"></div>
                <p id="addr"><strong>주소:</strong> ${jobPost.workLocation}</p>
                <p><strong>연락처:</strong> ${jobPost.contactNumber}</p>
                <p><strong>임금:</strong> ${jobPost.salary} 원</p>
                <p><strong>근무시간:</strong> ${jobPost.workHours}</p>
                <p><strong>근무요일:</strong> ${jobPost.workDays}</p>
                <p><strong>근무기간:</strong> ${jobPost.workDuration}</p>
                <p><strong>업무내용:</strong> ${jobPost.jobDescription}</p>
            </div>
             <c:if test="${empty sessionScope.businessNumber}">
            <div class="card-footer text-center">
            	<a href="applyresumeList?postNumber=${jobPost.postNumber}">지원하기</a>
            </div>
            </c:if>
            <c:if test="${not empty sessionScope.businessNumber}">
            <div class="card-footer text-center">
            	<a href="businesApplylist?postNumber=${jobPost.postNumber}">지원 내역 조회</a>
            </div>
            </c:if>
        </div>
            <div class="text-center">
                <button onclick="window.history.back();" class="btn btn-secondary">목록으로 돌아가기</button>
            </div>
    </div>

</body>
</html>
