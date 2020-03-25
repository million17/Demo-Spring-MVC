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
	<div class="d-flex justify-content-end">
		<c:url value="/admin/new/edit/" var="/createNewURL" />
		<a href="${createNewURL}" class="btn btn-gradient-primary btn-icon-text mr-4">
            <i class="mdi mdi-file-check btn-icon-prepend"></i>
            Add News
        </a>
        <button id="btnDelete" type="button" class="btn btn-gradient-dark mr-4">
            <i class="mdi mdi-file-check btn-icon-prepend"></i>
            Delete
         </button>
    </div>
	<form action="#" id="formSubmit"
		method="get">
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll" /></th>
						<th>Title</th>
						<th>Thumbnail</th>
						<th>Short Description</th>
						<th>Content</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${vm.listResult}">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" /></td>
							<td>${ item.title }</td>
							<td>${ item.thumbnail }</td>
							<td>${ item.shortDesc }</td>
							<td>${ item.content }</td> 
							<td>
								<c:url value="/admin/new/edit/" var="updateNewURL">
									<c:param name="id" value="${item.id}"  />
								</c:url>
							<a class="btn btn-gradient-dark btn-icon-text" href="${updateNewURL}">
                         		<i class="mdi mdi-file-check btn-icon-append"></i>                          
                        	</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</form>
	<script type="text/javascript">
	</script>
</body>

</html>