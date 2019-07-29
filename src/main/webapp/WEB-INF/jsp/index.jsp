<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/jquery.form.js"></script>
    <title>导入</title>

    <script type="text/javascript">
        //JS校验form表单信息
        function checkData(){
            var fileDir = $("#upfile").val();
            var suffix = fileDir.substr(fileDir.lastIndexOf("."));
            if("" == fileDir){
                alert("选择需要导入的Excel文件！");
                return false;
            }
            if(".xls" != suffix && ".xlsx" != suffix ){
                alert("选择Excel格式的文件导入！");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<div>通过form表单提交方式上传文件 </div>
<form method="POST"  enctype="multipart/form-data" id="form1" action="excel/import.do">
    <table>
        <tr>
            <td>上传文件: </td>
            <td> <input id="uploadFile" type="file" name="uploadFile"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交" onclick="return checkData();"></td>
        </tr>
    </table>
</form>
<%--<form action="excel/import" name="Form" id="Form" method="post" enctype="multipart/form-data">
    <table id="table_report" class="table table-striped table-bordered table-hover">
        <tr>
            <td style="width:70px;text-align: right;padding-top: 13px;">选择Excel:</td>
            <td><input id="uploadFile" name="uploadFile" type="file" style="width:330px" οnchange="fileType(this)"/><br/><br/>　　
            </td>
        </tr>
        <tr>
            <td style="text-align: center;" colspan="10">
                <input id="btnImportSubmit" class="btn btn-small btn-success" type="submit" value="上传"/>
            </td>
        </tr>
    </table>
</form>--%>


</body>
</html>
<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%
    String importMsg="";
    if(request.getSession().getAttribute("msg")!=null){
        importMsg=request.getSession().getAttribute("msg").toString();
    }
    request.getSession().setAttribute("msg", "");
%>
<head>
    <title>批量导入数据</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<div><font color="bule">批量导入数据</font></div>
<form method="POST" enctype="multipart/form-data" id="form1" action="excel/import" onsubmit="return check();">
    <div style="margin: 30px;"><input id="excel_file" type="file" name="uploadFile" accept="xlsx" size="80"/>
        <input id="excel_button" type="submit" value="导入Excel"/></div>
    <font id="importMsg" color="red"><%=importMsg%></font><input type="hidden"/>
</form>
</body>
<script type="text/javascript">
    function check() {
        var excel_file = $("#excel_file").val();
        if (excel_file == "" || excel_file.length == 0) {
            alert("请选择文件路径！");
            return false;
        } else {
            return true;
        }
    }

    $(document).ready(function () {
        var msg="";
        if($("#importMsg").text()!=null){
            msg=$("#importMsg").text();
        }
        if(msg!=""){
            alert(msg);
        }
    });
</script>

</html>--%>
