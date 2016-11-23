<html>
<head>
<meta name='layout' content="main">
<title>Lista de movimientos</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Mes', 'Ingreso', 'Pagos', 'Balance'],
          	<g:each in="${objectArray}" status="i" var="object">
          		['${object.Mes}',${object.Ingreso},${object.Pago},${object.Diferencia}],
			</g:each>
        ]);

        var options = {
          chart: {
            title: 'Balance de movimientos',
          }
        };

        var chart = new google.charts.Bar(document.getElementById('movimientos'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>
	<div id='overall'>
		<div class="buttons">
          <span class="button">
          	<g:link action="listClient"><g:img dir="images/skin" file="house.png"/> Home</g:link>            
          	<g:link controller="User" action="logout"><g:img dir="images/skin" file="myLogout.ico" width="23" height="23"/> Log Out</g:link>            
          </span>
              <div id="movimientos" style="width: 100%; height: 500px;"></div>
		</div>
	</div>
</body>
</html>
