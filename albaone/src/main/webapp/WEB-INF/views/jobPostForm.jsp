<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.time.LocalDateTime"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>직업 공고 등록</title>
</head>
<style>
	.main
	{
		margin-bottom : 5%;
	}
</style>
<body>
    <%@include file="menu.jsp" %>
    
    <div class="container mt-4 main">
        <h2 class="text-center">직업 공고 등록</h2>
        <div id="map" style="width:100%;height:400px;"></div>
        <form action="./jobposting" method="post" modelAttribute="jobPost" id="jobPostingForm">
            <div class="form-group">
                <label for="companyName">상호명</label>
                <input type="text" class="form-control" name="companyName" placeholder="상호명" required>
            </div>
            <div class="form-group">
            <div class="form-group">
                <label for="workLocation">근무지 주소</label>
                <input type="text" class="form-control" name="workLocation" id="workLocation" placeholder="근무지 주소" required>
                <div id="addressError" class="text-danger" style="display:none;">유효한 주소를 입력하세요.</div>
            </div>
            <div class="form-group">
                <label for="businessNumber">사업자 등록번호</label>
                <input type="text" class="form-control" name="businessNumber" id="businessNumber" value="${businessNumber}" readonly>
            </div>
                <label for="contactNumber">연락처</label>
                <input type="text" class="form-control" name="contactNumber" placeholder="연락처" required>
            </div>
            <div class="form-group">
                <label for="salary">임금</label>
                <input type="number" class="form-control" name="salary" placeholder="임금" required>
            </div>
            <div class="form-group">
                <label for="workHours">근무시간</label>
                <input type="text" class="form-control" name="workHours" placeholder="근무시간" required>
            </div>
            <div class="form-group">
                <label for="workDays">근무요일</label>
                <input type="text" class="form-control" name="workDays" placeholder="근무요일" required>
            </div>
            <div class="form-group">
                <label for="workDuration">근무기간</label>
                <input type="text" class="form-control" name="workDuration" placeholder="근무기간" required>
            </div>
            <div class="form-group">
                <label for="jobDescription">하는 일</label>
                <textarea class="form-control" name="jobDescription" rows="4" placeholder="하는 일" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-block">등록하기</button>
        </form>
    </div>
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7dae7fbe3ec02d481fe913a5d0874e98&libraries=services,clusterer,drawing"></script>
    <script type="text/javascript">
        var container = document.getElementById('map');
        var options =
        {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 초기 좌표 설정
            level: 3
        };
        var map = new kakao.maps.Map(container, options);
        var geocoder = new kakao.maps.services.Geocoder();

        // 주소 유효성 검사 및 지도에 표시, input 이벤트로 진행
        $('#workLocation').on('input', function() { 
            var address = $(this).val();
            // 주소가 비어있지 않은 경우에만 진행
            if (address)
            {
                geocoder.addressSearch(address, function(result, status)
                {
                    if (status === kakao.maps.services.Status.OK)
                    {
                        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                        
                        // 지도에 마커를 표시
                        var marker = new kakao.maps.Marker({
                            position: coords
                        });
                        marker.setMap(map);
                        
                        var infowindow = new kakao.maps.InfoWindow({
                            content: '<div style="padding:10px; text-align:center; font-size:14px; line-height:1.5; display: flex; justify-content: center; align-items: center;">' + address + '</div>'
                        });
                        infowindow.open(map, marker);
                        map.setCenter(coords);
                        
                        // 오류 메시지 숨기기
                        $('#addressError').hide();
                    }
                    else
                    {
                        // 주소가 유효하지 않은 경우
                        $('#addressError').show();
                        map.setCenter(new kakao.maps.LatLng(33.450701, 126.570667)); // 기본 위치로 이동
                    }
                });
            }
            else
            {
                $('#addressError').hide(); // 주소가 비어있으면 오류 메시지 숨기기
            }
        });
    </script>
</body>
</html>
