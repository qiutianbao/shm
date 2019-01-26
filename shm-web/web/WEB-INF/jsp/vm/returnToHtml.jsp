<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/init.jsp"%>
<script type="text/javascript">
    $(function(){
        location.href = "<%=request.getContextPath()%>/static/${vmName}.html";
    });
</script>