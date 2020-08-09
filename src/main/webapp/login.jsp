<%--
  Created by IntelliJ IDEA.
  User: romanvohmin
  Date: 04.08.2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="ru.job4j.dream.model.Candidate" %>
<%@ page import="ru.job4j.dream.store.PsqlStore" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
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
    </script>
    <title>Работа мечты</title>
</head>
<body>
<div class="container pt-3">

    <div class="col-sm-6">
        <div class="card" style="width: 100%">
            <table class="table">
                <tr class="card-header">
                    <td>
                        <h5>Авторизация</h5>
                    </td>
                    <td>
                        <a class="nav-link" href="<%=request.getContextPath()%>/reg.jsp">Регистрация</a>
                    </td>
                </tr>
            </table>

            <form action="<%=request.getContextPath()%>/auth.do" id="login" method="post">
                <div class="col-sm">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                </div>
                <div class="col-sm">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                </div>
                <br>
                <div class="col-sm">
                    <button type="submit" class="btn btn-primary" onclick="return validate()">Submit</button>
                </div>
                <br>
            </form>

        </div>
    </div>
</div>
</body>
</html>
