<%@ page import="com.bing.lan.fc.domian.History" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cal_history_list</title>

    <style type="text/css">
        @import url(cal_history_list.css);
    </style>

</head>
<body>

<%
    List<History> list = (List<History>) request.getAttribute("historys");
%>
<%--<%= list %>--%>

<table cellpadding="5" cellspacing="0" border="5">
    <caption class="h1">理财计算器</caption>
    <thead>
    <tr bgcolor="#e9967a">
        <th> 平台</th>
        <th> 投资金额(元)</th>
        <th> 优惠券(元)</th>
        <th> 年化收益率(x%)</th>
        <th> 计息时间(day)</th>
        <th> 加息率(x%)</th>
        <th> 加息天数(day)</th>
        <th> 起息/到账总时间(day)</th>
        <th> 收益(元)</th>
        <th> 加息收益(元)</th>
        <th> 实际投资金额(元)</th>
        <th> 实际收益(元)</th>
        <th> 实际年华收益率(x%)</th>
        <th> 备注</th>
        <th> 操作</th>
    </tr>
    </thead>
    <tbody>

    <% for (History history : list) {%>
    <tr bgcolor="aqua">
        <td><%=history.getPlatformName()                        %></td>
        <td><%=history.getInvest_amount()                      %></td>
        <td><%=history.getDiscount_amount()                        %></td>

        <td><%=history.getAnnualized_return()                        %></td>
        <td><%=history.getInvest_time()                        %></td>
        <td><%=history.getIncrease_rates()                        %></td>
        <td><%=history.getIncrease_time()                        %></td>
        <td><%=history.getPayment_time()                        %></td>

        <td><%=history.getInvest_income()                        %></td>
        <td><%=history.getIncrease_income()                        %></td>
        <td><%=history.getActual_invest_amount()                        %></td>

        <td><%=history.getActual_invest_income()                        %></td>
        <td><%=history.getActual_annualized_return()                        %></td>
        <td><%=history.getDesc()                        %></td>
        <td> <a  href="<%="/fc/history/delete?id="+history.getId()%>" >删除</a></td>
    </tr>


    <%} %>


    </tbody>
</table>


</body>
</html>
