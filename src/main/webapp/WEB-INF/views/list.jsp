<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">

    <title>Document</title>

    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">

    <!-- reset -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- fontawesome css: https://fontawesome.com -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">

    <link rel="stylesheet" href="/assets/css/list.css">
    <!-- <link rel="stylesheet" href="/assets/css/list.css"> -->
</head>

<body>
    <div class="wrap">
        <!-- 상단 박스 -->
        <div class="main-title-wrapper">
            <div class="iconSection">icon-section</div>
            <h1>Your Note</h1>
        </div>
        <!-- 하단 박스 -->
        <h3 class="sub-title">Sales Overview</h3>
        <div class="main-content-wrapper">
            <c:forEach var="b" items="${blist}">
                <div class="card-container">
                    <section class="card-wrapper">
                        <div class="card-title-wrapper">
                            
                            <div class="card-btn-group">
                                <h2 class="card-title">${b.shortTitle}</h2>
                                <button class="del-btn">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                            <div class="time-view-wrapper">
                                <div class="time">
                                    ${b.date}
                                </div>
                                <div class="view">
                                    <i class="fas fa-eye"></i>
                                    <span class="view-count">${b.viewCount}</span>
                                </div>
                            </div>
                        </div>

                        <div class="card-content">

                            ${b.shortContent}

                        </div>

                    </section>
                </div>
            </c:forEach>
        </div>
    </div>
</body>

</html>