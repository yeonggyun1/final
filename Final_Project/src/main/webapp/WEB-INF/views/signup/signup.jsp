<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">

	<div class="card">
		<div class="card-header">
			<h4>
				회원가입 <small>1단계 - 필수정보 입력</small>
			</h4>
		</div>
		<div class="card-body">
			<form:form action="/signup" method="post" autocomplete="off"
				onsubmit="return valid_form();" modelAttribute="accountVo">
				<div class="form-group">
					<label for="id">아이디</label>
					<form:input type="text" class="form-control" path="userId"
						placeholder="사용할 아이디" id="id" />
					<b> <form:errors path="userId" />
					</b>
				</div>
				<div class="form-group">
					<label for="pwd">비밀번호</label>
					<form:input type="password" class="form-control"
						placeholder="사용할 비밀번호" id="pwd" path="userPass" />
				</div>
				<div class="form-group">
					<label for="pwd_confirm">비밀번호 재확인</label> <input type="password"
						class="form-control" placeholder="비밀번호 재확인" id="pwd_confirm">
				</div>
				<div class="form-group">
					<label for="name">사용자 이름</label>
					<form:input type="text" class="form-control" placeholder="사용자 이름"
						id="name" path="userName" />
					<b> <form:errors path="userName" />
					</b>
				</div>
				<button type="submit" class="btn btn-primary btn-block mt-5">다음</button>
			</form:form>
		</div>
	</div>
</div>
<script>
	function valid_form() {
		if ($("#id").val().length >= 4) {
			$("#id").addClass("is-valid"); // removeClass
		}
		if ($("#pwd").val() != $("#pwd_confirm").val()) {
			$("#pwd_confirm").addClass("is-invalid");
			$("#pwd_confirm").focus();
			return false;
		}
	}
</script>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />