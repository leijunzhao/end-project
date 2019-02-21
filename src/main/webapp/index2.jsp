<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
    });
    goEasy.subscribe({
        channel: "140",
        onMessage: function (message) {
            alert("Channel:" + message.channel + " content:" + message.content);
        }
    });
</script>
this is index2
</body>
</html>
