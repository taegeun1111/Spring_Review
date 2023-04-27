<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/css/detail.css">
</head>

<body>
    <div class="detail-container">
        <div class="detail-main-wrapper">
            <section class="title-wrapper">
                <div class="main-title">${b.title}</div>
                <div class="main-content">${b.content}</div>
            </section>
            <section class="button-wrapper">
                <a href="/board/modify?boardNo=${b.boardNo}">Modify</a>
                <a href="/board/list">Back</a>
                <a href=""></a>
            </section>

        </div>
    </div>
</body>

</html>