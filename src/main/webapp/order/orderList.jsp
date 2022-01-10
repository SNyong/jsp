<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문서</title>
<style>
   th, td {
      text-align: center;
   }
#orderList * {
   padding: 0;
   margin: 0;
}

#orderList ul {
   list-style-type: none;
   width: 100%;
   padding: 20px;
}

#orderList #List {
   width: 800px;
   height: 400px;
   border: 0px solid gray;
   padding: 40px 10px 0 10px;
   margin: auto;
}

#orderList #delivery {
   width: 800px;
   height: 300px;
   border: 0px solid gray;
   padding: 40px 10px 0 10px;
   margin: auto;
}

#orderList #totalPay {
   width: 800px;
   height: 200px;
   padding: 40px 10px 0 10px;
   margin: auto;
   font-size: 1.6em;
   text-align: right;
}

#orderList #commandCell {
   text-align: center;
}

#orderList table {
   margin: auto;
   width: 800px;
   height: auto;
   font-size: 1.6em;
   font-family: "돋움";
}

#orderList .tr_up {
   text-align: center;
   background-color: #B7F0B1;
   padding: 10px;
}

#orderList .td_left {
   width: 200px;
   background-color: #B7F0B1;
   padding: 10px;
}

#orderList .td_right {
   width: 600px;
   text-align: left;
   padding-left: 10px;
}
</style>
</head>
<body>
   <form action="orderOk.or" method="post">
      <section id="orderList">
         <section id="List">
         <table>
            <caption>주문 내용</caption>
            <tr class="tr_up">
               <td>상품명</td>
               <td>가격</td>
               <td>수량</td>
               <td>금액</td>
            </tr>

            <c:set var="total" value="0" />
            <c:forEach var="item" items="${orderList}" varStatus="status">
               <input type="hidden" name="bucketCode" value="${item.bucketCode}" />
               <input type="hidden" name="productCode" value="${item.productCode}" />
               <input type="hidden" name="qntty" value="${item.bucketQ}" />
               <tr>
                  <td>${item.productName}</td>
                  <td style="text-align: right">${item.productSellPrice}</td>
                  <td>${item.bucketQ}</td>
                  <td style="text-align: right">${item.productSellPrice * item.bucketQ}</td>
                  <c:set var="amout" value="${item.productSellPrice * item.bucketQ}" />
                  <c:set var="total" value="${total + amout}"/>
               </tr>
            </c:forEach>
         </table>
         </section>

         <section id="delivery">
         <table>
            <tr>
               <td class="td_left">받는 사람</td>
               <td class="td_right">${member.name}</td>
            </tr>
            <tr>
               <td class="td_left">연락처</td>
               <td class="td_right">
                  ${member.number}
               </td>
            </tr>
            <tr>
               <td class="td_left">이메일</td>
               <td class="td_right">
                  ${member.email}
               </td>
            </tr>
            <tr>
               <td class="td_left">주소</td>
               <td class="td_right">
                  <input style="width: 90%; padding: 10px; margin: 0" type="text"
                        name="address" id="address" value="${member.address} ${member.address1}"/>
               </td>
            </tr>
         </table>
         </section>

         <section id="totalPay">
            총 결제 금액: <c:out value="${total}"/> &nbsp;&nbsp;&nbsp;
            <input type="hidden" id ="total" name="total" value="${total }"/>
         <table>
            <tr>
               <td id="commandCell">
                  <input type="submit" style="padding: 0.7em" value="결제" />
                  <input type="button" style="padding: 0.7em" value="뒤로가기" onClick="history.back();" /></td>
            </tr>
         </table>
         </section>
      </section>
   </form>
</body>

</html>