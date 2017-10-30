<%@ page import="com.bing.lan.fc.domian.History" %>
<%@ page import="com.bing.lan.fc.domian.Platform" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cal_history_list</title>

    <style type="text/css">
        @import url("/css/fc_history_list.css");
    </style>

</head>
<body>

<%
    List<History> histories = (List<History>) request.getAttribute("histories");
    History formHistory = histories.get(0);

    List<Platform> platforms = (List<Platform>) request.getAttribute("platforms");
%>
<%--<%= historys %>--%>
<h1>理财计算器</h1>

<form target="_self"
      action="${pageContext.request.contextPath}/fc/history"
      method="post">

    <table>
        <tbody>
        <tr>
            <td> 平台</td>
            <td>
                <select name="platform_id" title="请选择平台">
                    <% for (Platform platform : platforms) {%>
                    <option value="<%=platform.getId()%>">
                        <%=platform.getPlatformName()%>
                    </option>
                    <%} %>
                </select>

            </td>
        </tr>
        <tr>
            <td> 投资金额(元):</td>
            <td>
                <input type="text" name="invest_amount" value="10000" placeholder="请输入投资金额"
                       required>
            </td>
        </tr>
        <tr>
            <td> 优惠券(元)</td>
            <td>
                <input type="text" name="discount_amount" value="10" placeholder="请输入优惠券金额"
                       required>
            </td>
        </tr>
        <tr>
            <td> 年化收益率(x%)</td>
            <td>
                <input type="text" name="annualized_return" value="5" placeholder="请输入年化收益率"
                       required>
            </td>
        </tr>
        <tr>
            <td> 计息时间(day)</td>
            <td>
                <input type="text" name="invest_time" value="30" placeholder="请输入计息时间" required>
            </td>
        </tr>
        <tr>
            <td> 加息券年化收益率(x%)</td>
            <td>
                <input type="text" name="increase_rates" value="2" placeholder="请输入加息券年化收益率"
                       required>
            </td>
        </tr>
        <tr>
            <td> 加息券天数(day)</td>
            <td>
                <input type="text" name="increase_time" value="10" placeholder="请输入加息券天数" required>
            </td>
        </tr>
        <tr>
            <td> 起息/到账总时间(day)</td>
            <td>
                <input type="text" name="payment_time" value="2" placeholder="请输入起息/到账总时间" required>
            </td>
        </tr>
        <tr>
            <td> 备注</td>
            <td>
                <input type="text" name="desc" value="新手专享" placeholder="请输入备注" required>
            </td>
        </tr>


        <tr>
            <td colspan="2" align="right">
                <input type="hidden" value="save" name="cmd">
                <input type="submit">
                <input type="reset">
            </td>
        </tr>


        </tbody>
    </table>
</form>


<hr>
<table>
    <tbody>

    <tr>
        <td> 收益(元)</td>
        <td>
            <input type="text" name="invest_income" placeholder="收益" disabled>
        </td>
    </tr>
    <tr>
        <td> 加息券收益(元)</td>
        <td>
            <input type="text" name="increase_income" placeholder="加息券收益" disabled>
        </td>
    </tr>
    <tr>
        <td> 实际投资金额(元)</td>
        <td>
            <input type="text" name="actual_invest_amount" placeholder="实际投资金额" disabled>
        </td>
    </tr>
    <tr>
        <td> 实际收益(元)</td>
        <td>
            <input type="text" name="actual_invest_income" placeholder="实际收益" disabled>
        </td>
    </tr>
    <tr>
        <td> 实际年化收益率(x%)</td>
        <td>
            <input type="text" name="actual_annualized_return" placeholder="实际年化收益率" disabled>
        </td>
    </tr>

    </tbody>
</table>


<h3>理财计算历史记录</h3>
<hr>
<table cellpadding="5" cellspacing="0" border="5">
    <%--<caption class="table_title">理财计算历史记录</caption>--%>
    <thead>
    <tr bgcolor="#e9967a">
        <th> 平台</th>
        <th> 投资金额(元)</th>
        <th> 优惠券(元)</th>
        <th> 年化收益率(x%)</th>
        <th> 计息时间(day)</th>
        <th> 加息券年化收益率(x%)</th>
        <th> 加息券天数(day)</th>
        <th> 起息/到账总时间(day)</th>
        <th> 收益(元)</th>
        <th> 加息券收益(元)</th>
        <th> 实际投资金额(元)</th>
        <th> 实际收益(元)</th>
        <th> 实际年化收益率(x%)</th>
        <th> 备注</th>
        <th> 操作</th>
    </tr>
    </thead>
    <tbody>

    <% for (History history : histories) {%>
    <tr bgcolor="aqua">
        <td><%=history.getPlatformName()                        %>
        </td>
        <td><%=history.getInvest_amount()                      %>
        </td>
        <td><%=history.getDiscount_amount()                        %>
        </td>
        <td><%=history.getAnnualized_return()                        %>
        </td>
        <td><%=history.getInvest_time()                        %>
        </td>
        <td><%=history.getIncrease_rates()                        %>
        </td>
        <td><%=history.getIncrease_time()                        %>
        </td>
        <td><%=history.getPayment_time()                        %>
        </td>
        <td><%=history.getInvest_income()                        %>
        </td>
        <td><%=history.getIncrease_income()                        %>
        </td>
        <td><%=history.getActual_invest_amount()                        %>
        </td>
        <td><%=history.getActual_invest_income()                        %>
        </td>
        <td><%=history.getActual_annualized_return()                        %>
        </td>
        <td><%=history.getDesc()                        %>
        </td>
        <td><a href="<%="/fc/history?cmd=delete&id="+history.getId()%>">删除</a></td>
    </tr>


    <%} %>


    </tbody>
</table>


</body>
</html>
