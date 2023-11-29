<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../include/header.jsp"/>

<section>
     <div class="container pt-5">
        <h1 class="pb-3"> Customer Search </h1>

        <form action="/customer/search">


              First Name: <input type="text" name="search" placeholder="Search by first name" value="${search}"/>
              <br>
              Last Name: <input type="text" name="search" placeholder="Search by last name" value="${search}"/>
                <button type="submit" class="btn btn-primary">Submit</button>

         </form>

         <c:if test="${not empty customerVar}">
                     <h1>Customers Found ${customerVar.size()}</h1>

                     <table class="table table-hover">
                         <tr>
                             <td>Id</td>
                             <td>First Name</td>
                             <td>Last Name</td>
                             <td>Phone</td>
                             <td>City</td>
                         </tr>
                         <c:forEach items="${customerVar}" var="customer">
                             <tr>
                                 <td>${customer.id}</td>
                                 <td>${customer.firstname}</td>
                                 <td>${customer.lastname}</td>
                                 <td>${customer.phone}</td>
                                 <td>${customer.city}</td>
                             </tr>
                         </c:forEach>
                     </table>

                 </c:if>

      </div>
</section>

<jsp:include page="../include/footer.jsp"/>