<%--
  Created by IntelliJ IDEA.
  User: romanvohmin
  Date: 29.07.2020
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>
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
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
        function validate() {
            let elements = document.getElementsByTagName("input");
            for (let i = 0, element; element = elements[i++];) {
                console.log(element);
                if (element.value === "") {
                    console.log("Please fill field ")
                    alert("Заполните поле " + element.name);
                    return false;
                }
            }
        }
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/dreamjob/city',
                dataType: 'json'
            }).done(function (data) {
                $.each(data, function (index, value) {
                    $('#city').append('<option value="' + value.id + '">' + value.city + '</option>')
                });
                $('#city').val(new URLSearchParams(window.location.search).get("city"));
            }).fail(function (err) {
                alert(err);
            });
        });
    </script>
    <title>Работа мечты!</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    Candidate candidate = new Candidate(0, "", 0, 0);
    if (id != null) {
        candidate = PsqlStore.instOf().findCandidateById(Integer.parseInt(id));
    }
%>
<%
    String photoId = (String) request.getAttribute("photoId");
    if (photoId == null && candidate.getId() > 0) {
        photoId = String.valueOf(candidate.getPhotoId());
    }
%>
<div class="container pt-3">
    <ul class="nav">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">Главная</a>
        </li>
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
                <% if (id == null) { %>
                    <% if (photoId == null) { %>
                        <a href='<c:redirect url="/upload"/>'></a>
                    <% } else { %>
                        Новый кандидат.
                    <% } %>
                <% } else { %>
                    Редактирование кандидата.
                <% } %>
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/candidates.do?id=<%=candidate.getId()%>" method="post">
                    <div class="form-group">
                        <label>Имя</label>
                        <input type="text" class="form-control" name="name" value="<%=candidate.getName()%>">
                        <input type="hidden" name="photoId" value="<%=photoId%>">
                    </div>
                    <div class="form-group">
                        <label id="city_list">Город</label>
                        <select class="form-control" id="city" name="city">
                            <option disabled>Выберите город</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="return validate();">Сохранить</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
