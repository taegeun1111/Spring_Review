<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        </head>

        <body>
            <div class="wrap">
                <!-- 상단 박스 -->
                <div class="main-title-wrapper">
                    <div class="iconSection">icon-section</div>
                    <h1>Board</h1>
                </div>
                <div class="main-content-wrapper">
                    <div class="sub-title-wrapper">
                        Sales Overview
                    </div>
                    <!-- 하단 박스 -->
                    <div class="content-wrapper">
                        <c:forEach var="b" items="${blist}">
                            <div class="card-container" data-bno="/board/detail?boardNo=${b.boardNo}">
                                <!-- <input type="hidden" id="hidden-bno" name="boardNo" value="${b.boardNo}"> -->
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
                        <div class="add-btn">
                            <h4>Add</h4>
                            <button class="plus-btn">
                                <i class="fas fa-plus"></i>
                            </button>
                        </div>
                    </div>
                </div>

            </div>

            <script>
                // int boardNo받기
                const cardContainers = document.querySelectorAll('.card-container');
                 
                cardContainers.forEach(cardContainer => {
                    cardContainer.onclick = () => {
                        const bnoHref = cardContainer.dataset.bno;
                        // let bno = cardContainer.querySelector('#hidden-bno').value;
                        window.location.href = bnoHref;
                    };
                });

                //삭제버튼에 태그
                const $addBtn =  document.querySelector('.add-btn');
                $addBtn.onclick = e =>{
                    // if(!e.target.matches('.add-btn *')) return;
                    window.location.href = '/board/save';
                }


            </script>
        </body>

        </html>