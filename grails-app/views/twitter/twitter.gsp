<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Tweet Centre</title>
    <meta name="layout" content="main"/>
    <r:require module="twitter"/>
</head>

<body>
<section class="tweet">
    <header>
        <h1>What's in My Handbag</h1>
    </header>

    <g:if test="${flash.message}">
        <div class="error">
            ${flash.message}
        </div>
    </g:if>

    <form class="tweet" method="POST" action="statusupdate">
        <input name="brand" id="brand" placeholder="Brand" required />
        <input name="product" id="product" placeholder="Product" required />
        <input name="submit" type="submit" id="submit" value="Send to Twitter"/>
    </form>
</section>
</body>
</html>