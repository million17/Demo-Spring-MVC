<%@include file="/common/taglib.jsp"%>
<div class="d-flex justify-content-center h-100">
    <div class="card">
        <div class="card-body">
            <form:form action="register-user" method="post" modelAttribute="user">
                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <form:input path="userName" />

                </div>
                <div class="input-group form-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <form:input path="password" />
                </div>
                <div class="form-group">
                    <button type="submit" class="btn float-right login_btn">Login
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>