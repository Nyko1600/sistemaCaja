<html>
	<head>
    	<title>Random</title>
        <g:javascript library="jquery" />
	</head>
    <body>
      <div id="caja">
        <ul id="menu">
          <li>
            <g:remoteLink action="ajaxRandom" update="caja">
              Next Coments
            </g:remoteLink>
          </li>
          <li>
            <g:link action="index">
              Admin
            </g:link>
		  </li> 
		</ul>
      </div>
    </body>
</html>