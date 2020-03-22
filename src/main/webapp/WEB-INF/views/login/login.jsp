<%@include file="/common/taglib.jsp"%>
<div class="d-flex justify-content-center h-100">
	<div class="card">
		<c:if test="${param.incorrectAccount != null}">
			<div class="alert alert-danger my-3 mx-3" role="alert">
					Username or Password incorrect</div>
		</c:if>
		<div class="card-body">
			<form action="j_spring_security_check" method="post"
				  id="formLogin">
				<div class="input-group form-group">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fas fa-user"></i></span>
					</div>
					<input type="text" class="form-control" placeholder="username"
						   name="j_username" id="userName">

				</div>
				<div class="input-group form-group">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fas fa-key"></i></span>
					</div>
					<input type="password" class="form-control" placeholder="password"
						   name="j_password" id="password">
				</div>
				<div class="form-group">
					<button type="submit" class="btn float-right login_btn">Login
					</button>
				</div>
			</form>
		</div>
	</div>
</div>