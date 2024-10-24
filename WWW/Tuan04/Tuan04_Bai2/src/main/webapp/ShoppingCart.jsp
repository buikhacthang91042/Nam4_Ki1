<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="cart" scope="session" class="model.CartBean" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ hàng</title></head>
<body>
    <p><a href="/Tuan04_Bai2/ProductListController">Danh sách sản phẩm</a></p>
    
    <table width="100%" border="1">
        <tr bgcolor="#CCCCCC">
            <td>Mô tả sản phẩm</td>
            <td>Số lượng</td>
            <td>Đơn giá</td>
            <td>Tổng cộng</td>
        </tr>
        
        
            <tr>
                <td colspan="4">
                <c:if test="${cart.lineItemCount==0}">
                Giỏ hàng hiện tại trống.<br />
                </c:if></td>
            </tr>
        
        
        <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
            <form name="item" method="POST" action="/Tuan04_Bai2/CartController">
                <tr>
                    <td>
                        <c:out value="${cartItem.partNumber}" /><b><br /></b>
                        <c:out value="${cartItem.modelDescription}" />
                    </td>
                    <td>
                        <input type="hidden" name="itemIndex" value='<c:out value="${counter.count}"/>' />
                        <input type="text" name="quantity" value='<c:out value="${cartItem.quantity}" />' size="2" />
                        <input type="submit" name="action" value="Update" />
                        <input type="submit" name="action" value="Delete" />
                    </td>
                    <td>$<c:out value="${cartItem.unitCost}" /></td>
                    <td>$<c:out value="${cartItem.totalCost}" /></td>
                </tr>
            </form>
        </c:forEach>
        
        <tr>
            <td colspan="2"></td>
            
            <td>Phụ tổng:$<c:out value="${cart.orderTotal}" /></td>
        </tr>
    </table>
</body>
</html>
