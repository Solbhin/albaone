<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <style>
        #myform fieldset {
            display: inline-block;
            direction: rtl;
            border: 0;
        }
        #myform fieldset legend {
            text-align: right;
        }
        #myform input[type=radio] {
            display: none;
        }
        #myform label {
            font-size: 3em;
            color: transparent;
            cursor: pointer;
            text-shadow: 0 0 0 #f0f0f0;
        }
        #myform label:hover {
            text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
        }
        #myform label:hover ~ label {
            text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
        }
        #myform input[type=radio]:checked ~ label {
            text-shadow: 0 0 0 rgba(250, 208, 0, 0.99);
        }
        #reviewContents {
            width: 100%;
            height: 150px;
            padding: 10px;
            box-sizing: border-box;
            border: solid 1.5px #D3D3D3;
            border-radius: 5px;
            font-size: 16px;
            resize: none;
        }
    </style>   
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>리뷰 작성</title>
</head>
<body>
    <div class="container mt-5">
        <h2>리뷰 수정</h2>
        <form action="updateReview?reviewNumber=${reviewNumber}" method="post" modelAttribute="updateReview" id="myform">
            <input type="hidden" name="reviewNumber" id="reviewNumber" value="${reviewNumber}">
            <div class="form-group">
                <span for="companyName">회사명</span>
                <input type="text" class="form-control" id="companyName" name="companyName" value="${companyName}" required readonly>
            </div>
            <div class="form-group">
            	<span for="id">본인 아이디</span>
            	<input type="text" class="form-control" id="id" name="id" value="${id}" required readonly>
            </div>
            <div class="form-group">
                <span for="comment">리뷰 내용</span>
                <textarea class="form-control" id="comment" name="comment" rows="4" required></textarea>
            </div>
			<div class="form-group">
			    <span for="rating">평점</span>
			    <fieldset class="mb-3" name="myform" id="myform">
			        <span class="text-bold">별점을 선택해주세요</span><br>
			        <input type="radio" name="ratingAvg" value="1" id="rate1"><label for="rate1">★</label>
			        <input type="radio" name="ratingAvg" value="2" id="rate2"><label for="rate2">★</label>
			        <input type="radio" name="ratingAvg" value="3" id="rate3"><label for="rate3">★</label>
			        <input type="radio" name="ratingAvg" value="4" id="rate4"><label for="rate4">★</label>
			        <input type="radio" name="ratingAvg" value="5" id="rate5"><label for="rate5">★</label>
			    </fieldset>
			</div>
            <button type="submit" class="btn btn-primary">리뷰 수정</button>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>