<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
<style>
   #OrderOkList{
   width: 800px;
   align: center;
   }

   #OrderOkList caption{
   font-size: 1.7em;
   }

   #OrderOkList tr{
   list-style-type: none;
   width: 100%;
   padding: 20px;
   text-align: center;
   }   

   #OrderOkList tr td{
   padding: 10px;
   font-size: 1.3em;
   }   

   #OrderOkList #back {
   background-color: #B7F0B1;
   }   
</style>
</head>
<body>
   <section id="OrderOkList">      
         <table>
            <caption>주문내역</caption>
            <tr>

               <td id="back">주문일시</td>
               <td id="back">결제금액</td>
               <td id="back">상세보기</td>
            </tr>

            <c:forEach var="order" items="${order }">
            <form action="orderView.or" method="post" id="OKList" name="OKList">
               <input type="hidden" name="code" value="${order.orderCode }" />   
               <tr>
                  <td>${order.orderDate }</td>
                  <td>${order.totalPrice }</td>
                  
                  <td><input type="submit" value="상세조회" /></td>
               </tr>
               </form>
            </c:forEach>
         </table>
      
   </section>
</body>
</html>