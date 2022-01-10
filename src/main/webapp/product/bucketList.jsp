<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="vo.Product"%>
<%@ page import="vo.Bucket"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 리스트</title>
<style type="text/css">
#bucketList * {
   text-align: center;
}

#bucketList  {
   width: 800px;
   margin: auto;
   border: 2px solid #B7F0B1;
}

#bucketList table {
   width: 700px;
   margin: auto;
   text-align: center;
}

#bucketList ul {
   list-style-type: none;
   width: 100%;
   padding: 20px;
}
#bucketList img{
width : 100px;
}
</style>
<script>
// 전체선택하기 
function selectAll(selectAll)  {
     const checkboxes 
          = document.getElementsByName('chkbox');
     checkboxes.forEach((checkbox) => {
          checkbox.checked = selectAll.checked;
     });
     
      var frm = document.querySelector("form");
     itemSum(frm);
   }

// 총 가격 구하기
function itemSum(frm){
   var sum = 0;
   var count = frm.chkbox.length; 
   if (count > 1){
 	  for(var i=0; i < count; i++ ){
 	      if( frm.chkbox[i].checked == true ){
 	      sum += parseInt(frm.chkbox[i].id);
 	      	}
		}
   }else {
	   sum += parseInt(frm.chkbox.id);
   }
   frm.total_sum.value = sum;

}
  
</script>
</head>
<body>
   <section id="bucketList">
   <form id="form" method="post" name="cartform" action="order.or">
         <div id="frm">
         <table>
            <tr>
               <td colspan=7>
                  <h1>장바구니</h1>
               </td>

            </tr>
            <tr>
               
               <td><input type='checkbox' name='allCheck' onclick='selectAll(this)'/></td>
               <td colspan="2">물품 이름</td>
               <td>가격</td>
               <td>수량</td>
               <td>총 가격</td>
               <td>삭제</td>
            </tr>
            <% int i=0; %>
            <c:forEach var="bucketList" items="${bucketList }">
            
               <tr>
                  <td><input type="checkbox" id="${bucketList.productSellPrice * bucketList.bucketQ}" name="chkbox" class="check"
                     value="${bucketList.productCode }" onchange="itemSum(this.form);" /></td>
                     
                  <td><a href ="itemView.pro?ProductCode=${bucketList.productCode }">
                  <img src="./image/${bucketList.image }" id="productImage" /></a></td>
                  
                  <td><a href ="itemView.pro?ProductCode=${bucketList.productCode }">
                  
                  ${bucketList.productName }</a></td>
                  
                  <td>${bucketList.productSellPrice }원</td>
               
                  <td>
                        <input type="hidden" id="productCode" name="productCode" value="${bucketList.productCode }" /> 
                        <input type="text" id="bucketQ" name="bucketQ" style="width: 50px;" value="${bucketList.bucketQ }" /> 
                        <input type="button" value="변경" onclick="this.form.action='bucketMod.buc'; this.form.submit();"/>
                  </td>
                  
                  <td>
                
                  ${bucketList.productSellPrice * bucketList.bucketQ }원
                  
                  </td>
                  <td><a
                     href="bucketDel.buc?productCode=${bucketList.productCode }">삭제</a></td>
               </tr>
               <%i++; %>
            </c:forEach>
            <tr>
            <td colspan="6">
            <p>총 가격 : <input name="total_sum" id="total_sum" type="text" size="20" readonly style="border:none" value="0"/> </p></td></tr>
         </table>
         
         </div>
         <br>
         <input type="submit" value="구매하기"> 
         <a href="itemList.pro?Category=1">계속쇼핑하기</a>
      </form>
   </section>
   
</body>
</html>