<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>직업 공고 수정</title>
</head>
<body>
    <%@include file="menu.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center">직업 공고 수정</h2>
        <div id="map" style="width:100%;height:400px;"></div>
        <form action="./editJobPost?postNumber=${jobPost.postNumber}" method="post" modelAttribute="jobPost">
            <div class="form-group">
                <label for="companyName">상호명</label>
                <input type="text" class="form-control" name="companyName" value="${jobPost.companyName}" placeholder="상호명" required>
            </div>
            <div class="form-group">
                <label for="workLocation">근무지 주소</label>
                <input type="text" class="form-control" name="workLocation" id="workLocation" value="${jobPost.workLocation}" placeholder="근무지 주소" required>
                <div id="addressError" class="text-danger" style="display:none;">유효한 주소를 입력하세요.</div>
            </div>
            <div class="form-group">
                <label for="contactNumber">연락처</label>
                <input type="text" class="form-control" name="contactNumber" value="${jobPost.contactNumber}" placeholder="연락처" required>
            </div>
            <div class="form-group">
                <label for="salary">임금</label>
                <input type="number" class="form-control" name="salary" value="${jobPost.salary}" placeholder="임금" required>
            </div>
            <div class="form-group">
                <label for="workHours">근무시간</label>
                <input type="text" class="form-control" name="workHours" value="${jobPost.workHours}" placeholder="근무시간" required>
            </div>
            <div class="form-group">
                <label for="workDays">근무요일</label>
                <input type="text" class="form-control" name="workDays" value="${jobPost.workDays}" placeholder="근무요일" required>
            </div>
            <div class="form-group">
                <label for="workDuration">근무기간</label>
                <input type="text" class="form-control" name="workDuration" value="${jobPost.workDuration}" placeholder="근무기간" required>
            </div>
            <div class="form-group">
                <label for="jobDescription">하는 일</label>
                <textarea class="form-control" name="jobDescription" rows="4" placeholder="하는 일" required>${jobPost.jobDescription}</textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-block">수정하기</button>
        </form>
    </div>
    
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b93f1c67d88fac7ef8329a28850e92c&libraries=services,clusterer,drawing"></script>
    <script type="text/javascript">
    $(document).ready(function()
    {
        var container = document.getElementById('map');
        var options =
        {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 기본 초기 좌표
            level: 3
        };
        var map = new kakao.maps.Map(container, options);
        var geocoder = new kakao.maps.services.Geocoder();

        // 페이지 로드 시 기존 주소로 초기화
        var initialAddress = "${jobPost.workLocation}"; // 서버에서 전달된 주소
        if (initialAddress) {
            geocoder.addressSearch(initialAddress, function(result, status)
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
                        content: '<div style="padding:10px; text-align:center; font-size:14px; line-height:1.5; display: flex; justify-content: center; align-items: center;">' + initialAddress + '</div>'
                    });
                    infowindow.open(map, marker);
                    map.setCenter(coords);
                }
                else
                {
                    console.error("주소 검색 실패:", status); // 오류 콘솔에서 확인
                }
            });
        }

        // 주소 유효성 검사 및 지도에 표시, input 이벤트로 진행
        $('#workLocation').on('input', function()
        { 
            var address = $(this).val();
            if (address)
            {
                geocoder.addressSearch(address, function(result, status)
                {
                    if (status === kakao.maps.services.Status.OK)
                    {
                        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                        var marker = new kakao.maps.Marker({
                            position: coords
                        });
                        marker.setMap(map);
                        
                        var infowindow = new kakao.maps.InfoWindow({
                            content: '<div style="padding:10px; text-align:center; font-size:14px; line-height:1.5; display: flex; justify-content: center; align-items: center;">' + address + '</div>'
                        });
                        infowindow.open(map, marker);
                        map.setCenter(coords);
                        $('#addressError').hide();
                    }
                    else
                    {
                        $('#addressError').show();
                        map.setCenter(new kakao.maps.LatLng(33.450701, 126.570667)); // 기본 위치로 이동
                    }
                });
            }
            else
            {
                $('#addressError').hide();
                map.setCenter(new kakao.maps.LatLng(33.450701, 126.570667)); // 기본 위치로 이동
            }
        });
    });
</script>


</body>
</html>
