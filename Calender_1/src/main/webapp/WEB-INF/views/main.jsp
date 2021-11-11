<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<section class="main">
			<h1 class="main-title">Calender And To Do List</h1>
			<div class="month clearfix">
				<span class="left">
					<i class="fas fa-chevron-left left"></i>
				</span>
				<span class="right">
               		<i class="fas fa-chevron-right right"></i>
            	</span>
            	<p class="month-name"></p>
			</div>
			
			<div class="dayCount">
				<ul class="dayCount-list clearfix">
					<li>MON</li>
					<li>TUE</li>
					<li>WED</li>
					<li>THU</li>
					<li>FRI</li>
					<li>SAT</li>
					<li>SUN</li>
				</ul>
			</div>
			<ul class="day clearfix">
			</ul>
			
		</section>
		<section class="todo">
			<h1 class="todo-title">
				Today's To Do List
			</h1>
			<div class="textToDo">
				<input type="text" class="textToDo-text">
				<button class="textToDo-button add">Add</button>
            	<button class="textToDo-button reset">Reset</button>
           		<button class="textToDo-button allreset">All reset</button>
			</div>
			<ul class="todoList"></ul>
		</section>
	</body>
</html>