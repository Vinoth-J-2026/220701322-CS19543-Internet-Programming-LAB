<html>
    <head>
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="login.css">
        <script src="jquery-3.7.1.min.js"></script>
        <script src="bootstrap.min.js"></script>
    </head>
    <body>
        <div class="main">
        <div><img src="images.png" class="logo" alt="image not found" width="100"></div>
            <div class="center-box">            
                <h1>Y BANK</h2>
                <h3>Login</h3><br>
                <form action="verify.php" method="post">
                UserId: &nbsp;<input type="text" name="userid" placeholder="Enter Your UserId"><br><br>
                Mpin:&nbsp; &nbsp; <input type="password" name="mpin" placeholder="Enter Your Mpin"><br><br>
                <input type="submit" class="submit" value="Login"><br><hr>
                <bold><a href="">Forgot UserId or Mpin</a></bold>
                </form>
            </div>
            </center>
        </div>
    </body>
</html>