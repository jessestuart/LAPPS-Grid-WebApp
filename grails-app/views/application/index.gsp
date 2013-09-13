<%--
  Created by IntelliJ IDEA.
  User: jdstuart
  Date: 9/13/13
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Application</title>
    <h1>LAPPS</h1>
    <form action="submit" method="post">
        <select name="LAPPS_datasource">
            <g:each var="dataSource" in="${dataSources}">
                <option value="${dataSource.name}">${dataSource.name}</option>
            </g:each>
        </select>
        <select name="LAPPS_service">
            <g:each var="service" in="${services}">
                <option value="${service.name}">${service.name}</option>
            </g:each>
        </select>
        <g:submitButton name="submit">Submit</g:submitButton>

        %{--<g:select name="datasource" from="${dataSources}">--}%
           %{----}%
        %{--</g:select>--}%
        %{--<g:select name="service" from="${services}">--}%

        %{--</g:select>--}%
    </form>
</head>
<body>

</body>
</html>