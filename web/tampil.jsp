<%-- 
    Document   : tampil
    Created on : Jul 4, 2013, 10:59:56 AM
    Author     : glassfish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="5; url=Servlet1?page=${requestScope['page']}">
        <title>Tampil Siswa</title>
    </head>
    <body>
        Menampilkan List Siswa Dengan meta refresh menggunakan Paging<br>
        Setiap halaman akan menampilkan 5 baris data, setiap halaman akan ditampilkan 5 detik<br>
        Halaman Ke ${requestScope['page']}
        <br>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nama</td>
            </tr>
            <c:forEach items="${requestScope['list']}" var="s">
                <tr>
                <td>${s.id}</td>
                <td>${s.nama}</td>
            </tr>
            </c:forEach>
            
        </table>
    </body>
</html>
