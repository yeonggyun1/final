<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/views/include/top.jsp" />
<div class="container pt-3">
	<div id="chart_div" style="width: 100%; height: 500px;"></div>

	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  $.ajax("/statistics/message/data").done(function(rst){
    		  // console.log(rst);
		        var data = google.visualization.arrayToDataTable(rst);
		
		        var options = {
		          title: 'Company Performance',
		          hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		          vAxis: {minValue: 0}
		        };
		
		        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
		        chart.draw(data, options);
    	  });
    	  
    	  
      }
    </script>

</div>
<jsp:include page="/WEB-INF/views/include/bottom.jsp" />