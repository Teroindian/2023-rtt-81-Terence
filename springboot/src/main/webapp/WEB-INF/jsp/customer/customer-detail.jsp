<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Customer  Details</h1>
            </div>
        </div>
    </div>
</section>
 <!--- <h1> hello world </h1> ---!>


<c:if test="${not empty customerVar}">
<section class="bg-light1 pb-5">



 <div class="container">
   <div class="row justify-content-center">
      <div class="col-12">

  <h3 class="text-center pb-3">Customers Details ${customerVar.size()}</h3>

    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone</th>
            <th>City</th>
            <th>Image URL</th>
            <th>Edit</th>
        </tr>
        <c:forEach items="${customerVar}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstname}</td>
                <td>${customer.lastname}</td>
                <td>${customer.phone}</td>
                <td>${customer.city}</td>
                <td>${customer.imageUrl}</td>
                <td>
                    <!-- Edit button -->
                <!--      <form action="/customers/${customer.id}/edit" method="get">-->
                 <!--         <input type="submit" value="Edit"> -->
                 <!--     </form> -->

                    <a href="/customer/edit/${customer.id}"><button>Edit</button></a>


                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
     </div>
      </div>

</section>
</c:if>







<jsp:include page="../include/footer.jsp"/>