<html>
<head>
    <link rel="stylesheet" href="login.css">
    <script src="jquery-3.7.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <style>
        .main{
            display:grid;
            grid-template-columns: 1fr auto 1fr;
        }
        .center-box{
            grid-column:2;
            grid-row:1;
            display:grid;
            background-color:white;
            text-align:left;
            
        }
        .balance{
            grid-column:1;
            grid-row:2;
            background-color:#DDF093;
            padding-left:10px;
            padding-right:10px;
     
        }
        .card{
            grid-column:2;
            grid-row:2;
            background-color:#F6D0B1;
            padding-left:10px;
            
            padding-right:10px;
        }
    </style>
</head>
<body>
    <?php
    $userid = $_POST["userid"];
    $mpin=$_POST["mpin"];
    $conn=new mysqli("localhost","root","","bank");
    $sql="select balance,cardno,holdername,expiredate from cardDetail where userid='$userid'";
    $result=$conn->query($sql);
    $row = $result->fetch_assoc();
    $balance = $row["balance"];
    $cardno=$row["cardno"];
    $holdername=$row["holdername"];
    $expire=$row["expiredate"];
    
    ?>
    <div class="main">
        <div class="center-box">
            <?php echo "<div><h2>Welcome".htmlspecialchars($holdername)."</h2></div>";
            echo '<div class="balance">                    
                    <h3>🏦Account Blance:$'.htmlspecialchars($balance).'</h3>
                  </div>';

            echo  '<div class="card">
                    <h3>Card Details<br>Card No.'.htmlspecialchars($cardno).'<br>Card Expire Date'.htmlspecialchars($expire).'</h3>
                  </div>';
            ?>

        </div>

    </div>

</body>
</html>