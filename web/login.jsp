<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>管理员登录</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function refreshCode() {
            //获取图片对象
            var elementById = document.getElementById("vcode");
            //设置属性
            elementById.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
        }
    </script>

    <script>
        window.onload = function () {
            //加载页面后操作


        }
    </script>



</head>
<body>
<div class="container" style="...">
    <div>
        <h3 style="text-align: center;">管理员登录</h3>
    </div>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="text" name="password" class="form-control" id="password" placeholder="请输入密码">
        </div>
        <div class="form-inline">
            <label for="vcode">验证码:</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码">
            <a href="javascript:refreshCode();">
                <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"></a>
        </div>
        <hr/>
        <div class="form-group" style="...">
            <input type="submit" value="登录" class="btn btn btn-primary">
        </div>

    </form>
    <%--出错显示信息框--%>
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span>x</span>
        </button>
        <strong>${login_error}</strong>
    </div>


</div>

</body>
</html>
