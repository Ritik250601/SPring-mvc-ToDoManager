<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>ToDo APP</title>
</head>
<body>
	<div class="container">

		<h1 class="text-center mt-3">Welcome to Todo Manager</h1>

		<div class="alert alert-success">
			<c:if test="${not empty msg }">
				<b><c:out value="${msg}"></c:out></b>

			</c:if>

		</div>



		<div class="row mt-5">
			<div class="col-md-2">

				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active"
						aria-current="true">Menu</button>
					<a type="button" href='<c:url value="/add"></c:url>'
						class="list-group-item list-group-item-action">Add Todo</a> <a
						type="button" href='<c:url value="/home"></c:url>'
						class="list-group-item list-group-item-action">View Todo</a>
				</div>
			</div>
			<div class="col-md-10 text-center">
				<c:if test="${page == 'home'}">
					<h1 class="text-center">All TODOS</h1>
					<c:forEach items="${todos}" var="t">
					<div class="card">
					<div class="card-body">
					<h3><c:out value="${t.todoTitle }"></c:out></h3>
					<p><c:out value="${t.todoContent }"></c:out></p>
					</div>
					
					</div>
					
					</c:forEach>
				</c:if>

				<c:if test="${page == 'add' }">

					<h1 class="text-center">Add TODOs</h1>
					<form:form action="saveTodo" method="post" modelAttribute="todo">
						<div class="form-group">
							<form:input path="todoTitle" clssClass="form-control"
								Placeholder="Enter Your Todo Title" />
						</div>
						<br>
						<div class="form-group">
							<form:textarea path="todoContent" cssClass="form-control"
								placeholder="Enter Your Todo Content" cssStyle="height:300px" />
						</div>
						<div class="container text-center mt-3">
							<button class="btn btn-outline-success">Add Todo</button>
						</div>
					</form:form>

				</c:if>

			</div>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>