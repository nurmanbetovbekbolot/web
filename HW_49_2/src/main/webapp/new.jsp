<p>Fill in, please</p>
<form action="${pageContext.request.contextPath}/boo" method="post">
    Login: <input type="text" required name="login"/>
    <br>

    Password: <input type="password" required name="password">
    <br>
    Email: <input type="email" required name="email">
    <br>
    <select name="gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
    </select>

    <input type="submit" value="Confirm"/>
</form>