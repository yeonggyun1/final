<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<h3>
		회원가입 <small>1단계(필수정보 입력)</small>
	</h3>
	<form action="/signup" method="post" autocomplete="off"
		onsubmit="return valid_form();">
		<div class="form-group">
			<label for="id">아이디</label> <input type="text" class="form-control"
				placeholder="사용할 아이디" id="id" name="userId">
			<spring:hasBindErrors name="accountVo">
				<c:if test="${errors.hasFieldErrors('userId') }">
					<b>${errors.getFieldError('userId').defaultMessage }</b>
				</c:if>
			</spring:hasBindErrors>
		</div>
		<div class="form-group">
			<label for="pwd">비밀번호</label> <input type="password"
				class="form-control" placeholder="사용할 비밀번호" id="pwd" name="userPass">
		</div>
		<div class="form-group">
			<label for="pwd_confirm">비밀번호 재확인</label> <input type="password"
				class="form-control" placeholder="비밀번호 재확인" id="pwd_confirm">
		</div>
		<div class="form-group">
			<label for="name">사용자 이름</label> <input type="text"
				class="form-control" placeholder="사용자 이름" id="name" name="userName">
		</div>
		<button type="submit" class="btn btn-primary btn-block">다음</button>
	</form>
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