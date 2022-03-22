<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<div class="card">
		<div class="card-header">
			<h4>로그인</h4>
		</div>
		<div class="card-body">
			<form action="/session" method="post" autocomplete="off">
				<c:if test="${not empty err }">
					<div class="alert alert-danger">
						 아이디나 비밀번호가 일치하지 않습니다.
					</div>
				</c:if>
				<div class="form-group">
					<label for="id">아이디</label> <input type="text" class="form-control"
						name="loginId" placeholder="계정 아이디" id="id" />
				</div>
				<div class="form-group">
					<label for="pwd">비밀번호</label> <input type="password"
						class="form-control" placeholder="계정 비밀번호" id="pwd"
						name="loginPass" />
				</div>
				<p class="text-info">비밀번호가 생각나지 않습니다?</p>
				<button type="submit" class="btn btn-success btn-block">로그인</button>
			</form>
		</div>
	</div>
	<div class="card mt-2">
		<div class="card-body">
			아직 계정이 없으신가요? <a href="/signup">계정을 생성하세요.</a>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />