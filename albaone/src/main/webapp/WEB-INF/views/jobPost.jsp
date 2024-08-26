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
</head>
<body>

    <%@include file="menu.jsp" %>
    
    <div class="container mt-4">
        <div class="card">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h5>${jobPost.companyName}의 상세정보</h5>
                <div>
                	<c:if test="${jobPost.id == sessionScope.id}">
	                    <button class="btn btn-danger btn-sm" onclick="if(confirm('정말 삭제하시겠습니까?')) { location.href='deleteJobPost?postNumber=${jobPost.postNumber}&status=공고 없음'; }">삭제</button>
	                    <button class="btn btn-primary btn-sm" onclick="location.href='editJobPost?postNumber=${jobPost.postNumber}'">수정</button>
					</c:if>
                </div>
            </div>
            <div class="card-body">
            	<div id="map" style="width:100%;height:400px;"></div>
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
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b93f1c67d88fac7ef8329a28850e92c&libraries=services,clusterer,drawing"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		var geocoder = new kakao.maps.services.Geocoder();
		
		var callback = function(result, status) {
			if (status === kakao.maps.services.Status.OK) {
				
				var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
				
				var marker = new kakao.maps.Marker({
					position: coords
				});
				marker.setMap(map);
				
				var infowindow = new kakao.maps.InfoWindow({
					content: '<div style="padding:10px; text-align:center; font-size:14px; line-height:1.5; display: flex; justify-content: center; align-items: center;">' + '${jobPost.companyName}' + '</div>'
				});
				
				infowindow.open(map, marker);
				
				map.setCenter(coords);
			}
		};
		
		geocoder.addressSearch('${jobPost.workLocation}', callback);
		
	</script>
</body>
</html>
