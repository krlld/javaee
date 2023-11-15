<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/handle-form" method="post">
    <label for="name">Name</label>
    <input type="text" name="name" id="name"/><br/>
    <label for="description">Description</label>
    <textarea name="description" id="description"></textarea>
    <button type="submit">Send</button>
</form>
<h1>${requestScope.message}</h1>
</body>
</html>
