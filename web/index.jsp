<%-- 
    Document   : index
    Created on : 19/04/2016, 17:19:41
    Author     : LEONE
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rentcar, seu carro já!</title>
    </head>
    <body>
        <form action ="Login" method="post">
            <strong><center><font size="10"> RentCar, Seu Carro Já! </font><center></strong><br/><br><br><br><br><br><br><br>
            <table>
                <tr alight="center">
                    <td>
                        <div align="right">
                            Usuario: <input type="text" name="edtSenha"><br><br>
                            Senha: <input type="password" name="edtSenha"><br><br>
                            <input type ="submit" value="OK"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
