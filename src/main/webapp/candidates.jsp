<%--
  Created by IntelliJ IDEA.
  User: romanvohmin
  Date: 29.07.2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
            integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Работа мечты!</title>
</head>
<body>
<div class="container pt-3">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/posts.do">Вакансии</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/candidates.do">Кандидаты</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/post/edit.jsp">Добавить вакансию</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/candidate/edit.jsp">Добавить кандидата</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp"> <c:out value="${user.name}"/> | Выйти</a>
        </li>
    </ul>

    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Кандидаты
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Список кандидатов</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${candidates}"
                               var="cand"> <%-- candidates - коллекция полученная из CandidateServlet --%>
                        <c:set var="candPhotoID" scope="request" value="${cand.photoId}"/>

                        <c:forEach items="${photos}" var="photo">
                            <c:if test="${candPhotoID == photo.id}">
                                <c:set var="photoName" scope="request" value="${photo.name}"/>
                            </c:if>
                        </c:forEach>

                        <tr>
                            <td>
                                <a href='<c:url value="/candidate/edit.jsp?id=${cand.id}"/>'>
                                    <i class="fa fa-edit mr-3"></i> <%-- сама иконка редактирования--%>
                                </a>
                                <c:out value="${cand.name}"/>
                            </td>
                            <td>
                                <a href="<c:url value='/download?name=${photoName}'/>">Download</a>
                            </td>
                            <td>
                                <img src="<c:url value='/download?name=${photoName}'/>" width="100px"
                                     height="100px"/>
                            </td>
                            <td>
                                <p>
                                    <a href='<c:url value="/del.do?id=${cand.id}"/>' class="btn btn-info btn-sm">
                                        <span class="glyphicon glyphicon-trash"></span> <i class="fa fa-trash "></i> Удалить кандидата
                                    </a>
                                </p>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
