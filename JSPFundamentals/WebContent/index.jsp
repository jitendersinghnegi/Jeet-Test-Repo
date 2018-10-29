<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<title>Zostel Spiti- Enjoy home away from home</title>
</head>
<body>
	<div class="container">

		<header>
			<%@include file="header.jsp"%>
		</header>
		<article>
			<div class="row">
				<div class="jumbotron">
					<h1 class="text-center">Yahaan aana apni marzi se par ....</h1>
					<p class="text-center">Kya haal janaab</p>
					<div class="row">
						
							<form action="findCourse.jsp" class="form-inline">
								<div class="form-group">
									<label class="control-label">Search Rooms</label> <input
										type="search" class="form-control" name="courseName"
										placeholder="Enter Room Type" /> <input type="submit"
										class="btn-btn-primary" value="Search" />
								</div>
							</form>
						
					</div>
					<br />
					<p class="text-center">
						<a href="courses.jsp" class="btn btn-lg btn-success">View All
							Rooms</a>
					</p>
				</div>


			</div>

			<div class="row">
				<p>
					New Users : <a href="register.jsp">Register Here</a>
				</p>
			</div>
			<div class="row">
				<p>
					Existing Users : <a href="login.jsp">Login Here</a>
				</p>
			</div>
		</article>
		<footer>
			<%@include file="footer.jsp"%>
		</footer>
	</div>
</body>
</html>