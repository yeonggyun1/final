<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<jsp:include page="/WEB-INF/views/message/include/top.jsp" />

<div class="pt-3">
	<h5>받은쪽지함()</h5>
</div>
<div class="table-responsive-sm">
	<table class="table table-success">
		<thead class="thead-light">
			<tr>
				<th>#</th>
				<th>내용</th>
				<th>보낸사람</th>
				<th>상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${received }" var="vo"></c:forEach>
			<tr>
				<td><input type="checkbox" name="no" value="${vo.no }" /></td>
				<td
					class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
					스프링 프레임워크(영어: Spring Framework)는 자바 플랫폼을 위한 오픈 소스 애......</td>
				<td>${vo.writer }</td>
				<td class="text-error"><c:choose>
						<c:when test="${vo.readDate eq null }">
							<span class="text-danger">읽지않음</span>
						</c:when>
						<c:otherwise>
							<span class="text-info"> <fmt:formatDate
									value="${vo.readDate }" pattern="yyyy.mm.dd" />
							</span>
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td><input type="checkbox" /></td>
				<td
					class="white-space: nowrap;overflow:hidden;text-overflow: ellipsis;">
					제어 반전(IoC: Inversion of Control) 컨테이너는 스프링의 가장 중요하고 핵심적.....</td>
				<td>관리자(admin)</td>
				<td class="text-error">읽지않음</td>
			</tr>
		</tbody>
	</table>
</div>




<jsp:include page="/WEB-INF/views/message/include/bottom.jsp" />
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />