<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/css/detail.css">
    <link
    href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">
</head>

<body>
    <form action="/board/save" method="post">
        <div class="save-container">
            <div class="save-main-wrapper">
                <section class="title-wrapper">
                    <input class="main-title" type="text" name="title" placeholder="title">

                    <textarea class="main-content" type="text" name="content" placeholder="content"></textarea>

                </section>
                <section class="button-wrapper">
                    <button type="submit">Confirm</button>
                    <a href="/board/list">Back</a>
                </section>

            </div>
        </div>
    </form>
</body>

</html>