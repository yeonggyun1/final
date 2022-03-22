<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="toast" data-autohide="false">
	<div class="toast-header">
		<strong class="mr-auto text-primary">알림창</strong> <small
			class="text-muted">5 mins ago</small>
		<button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
	</div>
	<div class="toast-body">새 메세지 알림</div>
</div>
<script>
	var serverName = location.host;
	var ws = new WebSocket("ws://" + serverName + "/ws/alert");

	ws.onmessage = function(recv) {
		// console.log(recv.data);
		var obj = JSON.parse(recv.data);

		$('.toast').toast('show');
	}
	// 	$(document).ready(function() {
	// 		$('.toast').toast('show');
	// 	});
	
	
</script>

</body>

</html>
