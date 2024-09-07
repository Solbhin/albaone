<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${companyName} 리뷰 보기</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>

	<div class="container mt-5">
		<h2>${companyName}의리뷰</h2>
		<c:if test="${not empty averageRating}">
			<h3>
				평균 평점: ${averageRating} 점
				<c:choose>
					<c:when test="${averageRating >= 0}">
						<c:forEach var="i" begin="1" end="5">
							<i
								class="fas fa-star ${i <= averageRating ? 'text-warning' : 'text-muted'}"></i>
						</c:forEach>
					</c:when>
				</c:choose>
			</h3>
		</c:if>
		
<div class="mb-4">
        <h5>리뷰 목록</h5>
        <ul class="list-group">
            <c:if test="${not empty reviews}">
                <c:forEach var="review" items="${reviews}">
                    <li class="list-group-item">
                        <strong>${review.id}</strong>: ${review.comment}
                        <span class="badge badge-primary float-right">
                            <c:forEach var="i" begin="1" end="5">
                                <i class="fas fa-star ${i <= review.ratingAvg ? 'text-warning' : 'text-muted'}"></i>
                            </c:forEach>
                        </span>
                       <c:if test="${id==review.id}">
	                       <a href="updateReview?reviewNumber=${review.reviewNumber}" 
	                       class="btn btn-primary">수정</a>
	                       <a href="removeReview?companyName=${review.companyName}&id=${review.id}&reviewNumber=${review.reviewNumber}" 
	                          class="btn btn-danger" 
	                          onclick="return confirm('정말 삭제하시겠습니까?');">
	                          삭제
	                       </a>
                        </c:if>
                    </li>
                </c:forEach>
            </c:if>
            <c:if test="${empty reviews}">
                <li class="list-group-item">리뷰가 없습니다.</li>
            </c:if>
        </ul>
    </div>
    <c:if test="${not empty id && empty sessionScope.businessNumber}">
        <div class="mb-4">
            <a href="ReviewForm?companyName=${companyName}" class="btn btn-success">리뷰 작성하기</a>
        </div>
    </c:if>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
