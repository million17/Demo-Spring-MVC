<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
					<form id="formSubmit" role="form">
						<div class="form-group">
							<label for="categoryCode">Category</label>
							<select class="form-control form-control-lg" name="categoryCode" id="categoryCode">
								<option value="1">Pháp Luật</option>
								<option value="2">Thể Thao</option>
								<option value="3">Thời Sự</option>
							</select>
						</div>
						<div class="form-group">
							<label for="title">Title</label>
							<input type="text"
								class="form-control" id="title" name="title" placeholder="title"
								value="">
						</div>
						<div class="form-group">
							<label>Thumbnail</label>
							<input type="file" name="thumbnail" id="thumbnail" class="form-control">
						</div>

						<div class="form-group">
							<label for="shortDesc">Textarea</label>
							<textarea class="form-control" id="shortDesc" name="shortDesc" rows="4"></textarea>
						</div>
						<div class="form-group">
							<label for="content">Content</label>
							<textarea  class="form-control" name="content" id="content" rows="4" value=""></textarea>
						</div>
						<button class="btn btn-gradient-primary mr-2" id="btnAddOrEdit" type="button">Submit</button>
						<button class="btn btn-light">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		var editor = '';
		$( document ).ready(function() {
		    editor = CKEDITOR.replace('content');
		});
		$("#btnAddOrEdit").click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) { 
				 data[""+ v.name +""] = v.value;
			});
			var id = $('#id').val();
			if(id == ""){
				addNew(data);
			} else {
				updateNew(data);
			}
		});
		function addNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result){
					window.location.href = "${NEWurl}?type=edit&id="+result.id+"&message=insert_success";
					
				},
				error : function(error) {
					window.location.href = "${NEWurl}?type=list&page=1&maxPageItem=3&message=error_system";
				}

			});
		}
		function updateNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function (result) {
					window.location.href = "${NEWurl}?type=edit&id="+result.id+"&message=update_success";
				},
				error : function (error) { 
					window.location.href = "${NEWurl}?type=list&page=1&maxPageItem=3&message=error_system";
				}
			});
		}
	</script>
</body>
</html>