<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<div style="border-bottom: 1px solid; margin-bottom: 30px;">
		<p style="margin-left: 20px;">
			<a href="/freeboard">글목록</a> | <a href="/freeboard/insert">글작성</a>
		</p>
	</div>
	<div style="margin-left: 20px; width: 80%">
		<h4>${one.title }</h4>
		<p style="font-size: small;">
			${one.writer } |
			<fmt:formatDate value="${one.writedate }"
				pattern="yyyy.MM.dd hh:mm:ss" />
		</p>
		<p style="min-height: 300px; white-space: break-spaces">
			<c:out value="${one.content}" />
		</p>
		<div style="margin-top: 10px;">
			<button type="button">수정</button>
			<button type="button">삭제</button>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />