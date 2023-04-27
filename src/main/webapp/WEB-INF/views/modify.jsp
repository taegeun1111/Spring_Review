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
    <form action="/board/modify" method="post">
        <div class="modify-container">
            <div class="modify-main-wrapper">
                <section class="title-wrapper">
                    <input type="hidden" name="boardNo" value="${b.boardNo}">
                    <input class="main-title" type="text" value="${b.title}" name="title">
                    <input class="main-content" type="text" value="${b.content}" name="content">
                </section>
                <section class="button-wrapper">
                    <button type="submit">Confirm</button>
                    <a href="/board/detail">Back</a>
                </section>

            </div>
        </div>
    </form>
</body>

</html>