<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>상품고르기</h1>
  <form action="addcart.do" method="post">
    <input type="radio" name="product" value="no">상품없음
    <input type="radio" name="product" checked="checked" value="tv">텔레비전
    <input type="radio" name="product" value="notebook">노트북
    <input type="radio" name="product" value="pc">PC
    <br>수량: 
    <input type="number" name="count" value="10">
    <input type="submit" value="장바구니담기">
    <br><br>
    <input type="button" onclick="location.href='viewcart.do'" value="장바구니보기">
  </form>
</body>
</html>