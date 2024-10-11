<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<title>Danh sách sản phẩm</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.a {
	width: 160px;
	height: 200px;
	border: 1px solid black;
	padding: 5px;
	margin: 10px;
	float: left;
	text-align: center;
}

.hinh {
	width: 80px;
	height: 100px;
}
</style>
</head>

<body>
	<p>
		<a href="/Tuan03_Bai04/ShoppingCart.jsp">Xem giỏ hàng</a>
	</p>
	<c:forEach items="${ds}" var="sp">
		<div class="a">
			<form name= "modelDetail" method="POST" action="/Tuan03_Bai04/CartController"
				>



				${sp.model} <br /> <img src="/Tuan03_Bai04${sp.imgURL}"
					class="hinh"><br /> Giá: ${sp.price} <br /> <input
					type="text" size="2" value="1" name="quantity"><br /> <input
					type="hidden" name="id" value="${sp.id}"> <input
					type="hidden" name="price" value="${sp.price}"> <input
					type="hidden" name="description" value="${sp.model}"> <input
					type="hidden" name="action" value="add"> <input
					type="submit" name="addToCart" value="Thêm vào giỏ hàng">
			</form>
		</div>
	</c:forEach>
</body>
</html>
