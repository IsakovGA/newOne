<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Прайс-лист</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }


        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tt {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }


        .tt td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: none;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
        }

        .tt th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: none;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
        }
    </style>
</head>
<body>

<h2>Прайс-лист</h2>


<c:url var="findProdCat" value="findProdCat"/>
<c:url var="listProdCat" value="newOne"/>

<table class = "tt">
<form:form action="${findProdCat}" commandName="findProdCat" method="get">

        <tr>
            <th width="120">Категория</th>
            <th width="120">Наименование</th>
            <th width="120">Цена от</th>
            <th width="120">Цена до</th>
        </tr>
        <tr>
            <td><input width="80" type="text" name="catId"></td>
            <td><input width="80" type="text" name="name"></td>
            <td><input width="80" type="number" name="minPrice"></td>
            <td><input width="80" type="number" name="maxPrice"></td>
            <td><input type="submit" value="<spring:message text="Найти"/>"></td>
        </tr>

</form:form>
</table>

<br/>


    <table class="tg">
        <tr>
            <th width="120">Категория</th>
            <th width="120">Наименование</th>
            <th width="120">Цена</th>
        </tr>
        <c:if test="${!empty findProdCatResult}">
            <c:forEach items="${findProdCatResult}" var="prodCat">
                <tr>
                    <td><c:out value="${prodCat.cat}"/></td>
                    <td><c:out value="${prodCat.name}"/></td>
                    <td><c:out value="${prodCat.price}"/></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>



</body>
</html>
