<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp"/>
<div class="container pt-3">
<div id="chart_div" style="width: 100%; height: 500px;"></div>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  $.ajax({
    		  url : "/statistics/message/data"
    		  
    	  }).done(function(rst){
    		  var data = google.visualization.arrayToDataTable(rst);

    	        var options = {
    	          title: '시간대별 메시지 전송 건수',
    	          hAxis: {title: '시간',  titleTextStyle: {color: '#333'}},
    	          vAxis: {title: '건수', minValue: 0}
    	        };

    	        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
    	        chart.draw(data, options);
    	        console.log(rst);
    	  });
        
      }
    </script>

</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp"/>