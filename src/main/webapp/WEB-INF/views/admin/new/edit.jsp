<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/admin/new/list"/>
<c:url var="editNewURL" value="/admin/new/edit/"/>
<c:url var="newAPI" value="/api/new"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="row">
		<div class="col-5 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Edit News</h4>
					<p class="card-description">Basic form edits</p>
					<c:if test="${not empty messageResponse}">
						<div class="alert alert-${alert} my-3 mx-3" role="alert">
							${messageResponse}</div>
					</c:if>
					<form:form id="formSubmit" role="form" modelAttribute="vm">
						<div class="form-group">
							<label for="categoryCode">Category</label>
                            <form:select path="categoryCode" id="categoryCode">
                                <form:option value="" label="--Category--"></form:option>
                                <form:options items="${categories}"></form:options>
                            </form:select>
						</div>
						<div class="form-group">
							<label for="title">Title</label>
                            <form:input path="title" cssClass="form-control" id="title" />
						</div>
						<div class="form-group">
							<label>Thumbnail</label>
							<input type="file" class="form-control" id="thumbnail" name="thumbnail"/>
						</div>

						<div class="form-group">
							<label for="shortDesc">Textarea</label>
                            <form:textarea path="shortDesc" id="shortDesc" cssClass="form-control" />
						</div>
						<div class="form-group">
							<label for="content">Content</label>
                            <form:textarea path="content" id="content"  rows="4" cssClass="form-control" />
						</div>
						<form:hidden path="id" id="newId" />
                        <c:if test="${not empty vm.id}">
                            <button class="btn btn-gradient-primary mr-2" id="btnAddOrEdit" type="button">Edit</button>
                        </c:if>
                        <c:if test="${empty vm.id}">
                            <button class="btn btn-gradient-primary mr-2" id="btnAddOrEdit" type="button">Add</button>
                        </c:if>

						<button class="btn btn-light">Cancel</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrEdit').click(function (e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData,function (i,v) {
				data["" + v.name + ""] = v.value;
			});
			var id = $('#newId').val();
			if(id == ''){
				addNew(data);
			}else {
				updateNew(data);
			}
			console.log(formData);
		});
		function addNew(data) {
			$.ajax({
				url: '${newAPI}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
					window.location.href = "${newURL}";
				},
				error: function (error) {
					window.location.href = "${newURL}";
				}
			});
		}
		function updateNew(data) {
			$.ajax({
				url: '${newAPI}',
				type: 'PUT',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function (result) {
					window.location.href = "${newURL}";
				},
				error: function (error) {
					window.location.href = "${newURL}";
				}
			});
		}
	</script>
</body>
</html>