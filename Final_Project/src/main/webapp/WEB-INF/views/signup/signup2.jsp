<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<div class="card">
		<div class="card-header">
			<h4>
				회원가입 <small>2단계 - 선택정보 입력</small>
			</h4>
		</div>
		<div class="card-body">
			<form:form action="/signupOk" method="post" autocomplete="off"
				modelAttribute="accountVo">
				<div class="form-group">
					<label for="zipcode">주소</label>
					<div class="form-row">
						<div class="col-3">
							<form:input type="text" class="form-control" placeholder="우편번호"
								id="zipcode" path="zipcode" />
						</div>
						<div class="col-9">
							<form:input type="text" class="form-control" placeholder="상세주소"
								path="address" id="address" />
						</div>
					</div>
				</div>
				<div class="form-group" >
					<select
						class="form-control" id="sel1" name="sellist1" style="display: none;">
					</select>
				</div>
				<div class="form-group">
					<label for="email">이메일</label>
					<form:input type="email" class="form-control" path="email"
						placeholder="등록할 이메일" id="email" />
				</div>
				<button type="button" class="btn btn-primary btn-block mt-5" id="bt">다음</button>
			</form:form>
		</div>
	</div>
	<script>
		$("#bt").on("click",function() {
			$(this).attr("type","submit");
			$(this).click();
		});
	
	
		$("#address").on("change", function() {
			$.ajax({
				url : "/find/zipcode",
				data : {
					data : $(this).val()
				}
			}).done(function(rst) {
				var _html = "";
				for(var i=0; i<rst.length;i++) {
					_html += "<option>"+rst[i].zipNo+" | " + rst[i].roadAddr+"</option>";					
				}
				$("#sel1").html(_html);
				$("#sel1").show();
			});
		}).on("keydown", function() {
			$("#sel1").hide();
		});
	</script>

</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />
















