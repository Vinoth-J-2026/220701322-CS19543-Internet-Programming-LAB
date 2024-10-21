<html>
<head>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery-3.7.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
</head>
<body>
<?php
    // Retrieve user inputs
    $userid = $_POST["userid"] ?? '';
    $mpin = $_POST["mpin"] ?? '';

    // Establish database connection
    $conn = new mysqli("localhost", "root", "", "bank");

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // Prepare and bind SQL statement to prevent SQL injection
    $stmt = $conn->prepare("SELECT mpin FROM LoginDetail WHERE userid = ?");
    $stmt->bind_param("s", $userid); // 's' indicates the type of the parameter is string
    $stmt->execute();
    $result = $stmt->get_result();

    // Check if user exists
    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();

        // Validate MPIN
        if ($mpin === $row["mpin"]) {
            echo '<center><div>';
            echo '<p>Login Successful</p>';
            echo '<form action="frontpage.php" method="post">';
            echo '<input type="hidden" name="userid" value="' . htmlspecialchars($userid) . '">';
            echo '<input type="hidden" name="mpin" value="' . htmlspecialchars($mpin) . '">';
            echo '<input type="submit" value="Next" class="btn btn-success">';
            echo '</form>';
            echo '</div></center>';
        } else {
            echo '<center><div>';
            echo '<p>Login Failed</p>';
            echo '<a href="login.php" class="btn btn-danger nextbutton">Try Again</a>';
            echo '</div></center>';
        }
    } else {
        echo '<p>User not found</p>';
    }

    // Close the statement and connection
    $stmt->close();
    $conn->close();
?>
</body>
</html>
