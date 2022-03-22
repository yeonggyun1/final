<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<div style="margin-left: 20px;">
		<small>※ 쉬운 비밀번호를 입력하면 타인의 수정, 삭제가 쉽습니다.</small>
		<form method="post">
			<div style="margin-top: 10px;">
				<input type="text" name="writer" placeholder="작성자.."
					style="width: 40%" /> <input type="password" name="pass"
					class="form-control" placeholder="비밀번호.." style="width: 40%" />
			</div>
			<div style="margin-top: 10px;">
				<input type="text" name="title" class="form-control"
					placeholder="글제목.." style="width: 82%" />
			</div>
			<div style="margin-top: 10px;">
				<textarea rows="10" name="content" placeholder="글내용.."
					style="width: 82%;"></textarea>
			</div>
			<div style="margin-top: 10px;">
				<button type="submit">등록</button>
				<button type="button">취소</button>
			</div>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />