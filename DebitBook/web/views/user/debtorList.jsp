<%-- 
    Document   : debtorList
    Created on : Apr 7, 2023, 2:44:43 PM
    Author     : bahoann79
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Debtor List Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/debtorList.css"/>
    </head>
    <body>
        <c:import url="/views/header.jsp" />

        <div class="container-fluid content-debtor-list">
            <div class="container-head row mt-5">
                <div class="col-md-10">
                    <h3 class="mt-2">List of Debtors</h3>
                    <p>Total: 20 records</p>
                </div>

                <div class="col-md-2 align-self-center">
                    <button type="button" class="btn btn-success"><i class="fa-solid fa-plus"></i> Add new debtors</button>
                </div>
            </div>

            <div class="container-body row">
                <table class="table table-bordered table-striped ">
                    <thead class="table-heading">
                        <tr class="text-center">
                            <th>Id</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Phone Number</th>
                            <th>Email</th>
                            <th>Total Money</th>
                            <th>Created Time</th>
                            <th>Updated Time</th>
                            <th class="col-act">Action</th>
                        </tr>

                        <tr>
                            <!-- ID -->
                            <td>
                                <div class="input-group">
                                    <input type="text" class="form-control" name="" placeholder="From" />
                                </div>
                                <div class="input-group mt-2">
                                    <input type="text" class="form-control" name="" placeholder="To" />
                                </div>
                            </td>
                            <!-- Name -->
                            <td>
                                <div class="input-group">
                                    <input type="text" class="form-control heading-input" name="" />
                                </div>
                            </td>
                            <!-- Address -->
                            <td>
                                <div class="input-group">
                                    <input type="text" class="form-control heading-input" name="" />
                                </div>
                            </td>
                            <!-- Phone Number -->
                            <td>
                                <div class="input-group">
                                    <input type="text" class="form-control heading-input" name="" />
                                </div>
                            </td>
                            <!-- Email -->
                            <td>
                                <div class="input-group">
                                    <input type="text" class="form-control heading-input" name="" />
                                </div>
                            </td>
                            <!-- Total Money -->
                            <td>
                                <div class="input-group">
                                    <input type="number" class="form-control" name="" placeholder="From" min="0" />
                                </div>
                                <div class="input-group mt-2">
                                    <input type="number" class="form-control" name="" placeholder="To" />
                                </div>
                            </td>
                            <!-- Created Time -->
                            <td>
                                <div class="input-group">
                                    <input type="date" class="form-control" name="" placeholder="From"
                                           id="from-created-time" />
                                </div>
                                <div class="input-group mt-2">
                                    <input type="date" class="form-control" name="" placeholder="To" id="to-created-time" />
                                </div>
                            </td>
                            <!-- Updated Time -->
                            <td>
                                <div class="input-group">
                                    <input type="date" class="form-control" name="" placeholder="From" />
                                </div>
                                <div class="input-group mt-2">
                                    <input type="date" class="form-control" name="" placeholder="To" />
                                </div>
                            </td>
                            <!-- Action -->
                            <td>
                                <div class="text-center">
                                    <button class="btn btn-danger btn-act">Clear Filter</button>
                                </div>
                                <div class="text-center mt-2">
                                    <button class="btn btn-primary btn-act">Hide</button>
                                </div>
                            </td>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${requestScope.debtors}" var="debtor">
                            <tr>
                                <td>${debtor.id}</td>
                                <td>${debtor.name}</td>
                                <td>${debtor.address}</td>
                                <td>${debtor.phoneNumber}</td>
                                <td>${debtor.email}</td>
                                <td>
                                    <fmt:formatNumber value="${debtor.totalMoney}" pattern="#,###"/>
                                </td>
                                <td>${debtor.createdAt}</td>
                                <td>${debtor.updatedAt}</td>
                                <td>
                                    <button type="button" class="btn btn-info"><i class="fa-solid fa-circle-info"></i>
                                        Detail</button>
                                    <button type="button" class="btn btn-debt"><i class="fa-solid fa-plus"></i> Add new
                                        debts</button>
                                    <button type="button" class="btn btn-warning"><i class="fa-solid fa-pen"></i> Edit</button>
                                </td>
                            </tr>

                        </c:forEach>

                    </tbody>
                </table>

                <div class="paging d-flex justify-content-center  ">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li class="page-item page-item-btn">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">Previous</span>
                                </a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item page-item-btn">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">Next</span>
                                </a>
                            </li>
                            <li class="page-item">
                                <select class="form-select" aria-label="Page size">
                                    <option value="5">5 rows</option>
                                    <option value="10">10 rows</option>
                                    <option value="20">20 rows</option>
                                    <option value="30">30 rows</option>
                                    <option value="50">50 rows</option>
                                </select>
                            </li>
                        </ul>
                    </nav>
                </div>



            </div>
        </div>


        <c:import url="/views/footer.jsp" />


    </body>
</html>
