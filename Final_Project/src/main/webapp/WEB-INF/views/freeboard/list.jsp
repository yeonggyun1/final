<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<div class="card">
		<div class="card-header">
			<form action="/freeboard/view">
				<input name="no" />
				<button>글번호</button>
				<a href="/freeboard/insert">글쓰기</a>
			</form>
		</div>
		<div class="card-body">
			<table style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="one" items="${all }">
						<tr>
							<td>${one.no }</td>
							<td><a href="/freeboard/view?no=${one.no }">${one.title }</a></td>
							<td>${one.writer }</td>
							<td><fmt:formatDate value="${one.writedate }"
									pattern="yyyy.MM.dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />