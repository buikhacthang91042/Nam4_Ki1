<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Nhân Viên Mới</title>
    <style type="text/css">
        .dienThongTin {
            margin-top: 30px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h1>Thêm nhân viên mới</h1>



    <form action="/BuiKhacThang_OnTapGK/ThemNhanVienMoiServlet" method="post">
        <div class="dienThongTin">
            <label>Mã nhân viên</label>
            <input type="text" name="maNhanVien" value="${param.maNhanVien}">
            <c:if test="${not empty error['maNhanVien'] }">
            	<span class="error">${error['maNhanVien']}</span>
            </c:if>
            <br>
        </div>

        <div class="dienThongTin">`
            <label>Tên nhân viên</label>
            <input type="text" name="tenNhanVien" value="${param.tenNhanVien}">
            <c:if test="${not empty error['tenNhanVien']}">
                <span class="error">${error['tenNhanVien']}</span>
            </c:if>
            <br>
        </div>

        <div class="dienThongTin">
            <label>Tuổi nhân viên</label>
            <input type="text" name="tuoi" value="${param.tuoi}">
            <c:if test="${not empty error['tuoi']}">
                <span class="error">${error['tuoi']}</span>
            </c:if>
            <br>
        </div>

        <div class="dienThongTin">
            <label>Số điện thoại</label>
            <input type="text" name="sdt" value="${param.sdt}">
            <c:if test="${not empty error['sDT']}">
                <span class="error">${error['sDT']}</span>
            </c:if>
            <br>
        </div>

        <div class="dienThongTin">
            <label>Địa chỉ</label>
            <input type="text" name="diaChi" value="${param.diaChi}">
            <c:if test="${not empty error['diaChi']}">
                <span class="error">${error['diaChi']}</span>
            </c:if>
            <br>
        </div>

        <div class="dienThongTin">
            <label>Phòng ban</label>
            <select name="phongBan">
                <option value="">Chọn phòng ban</option>
                <c:forEach var="phongBan" items="${listPhongBan}">
                    <option value="${phongBan.maPhongBan}" ${param.phongBan == phongBan.maPhongBan ? 'selected' : ''}>
                        ${phongBan.tenPhongBan}
                    </option>
                </c:forEach>
            </select>
            <c:if test="${not empty error['phongBan']}">
                <span class="error">${error['phongBan']}</span>
            </c:if>
            <br>
        </div>

        <div class="dienThongTin">
            <input type="submit" value="THÊM">
        </div>
    </form>
</body>
</html>
