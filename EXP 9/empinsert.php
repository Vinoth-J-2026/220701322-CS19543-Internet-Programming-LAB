<html>
<head><title>Insert Employee Detail</title></head>
<body>
<?php
    $empid = $_POST["empid"];
    $ename = $_POST["ename"];
    $desig = $_POST["desig"];
    $dept= $_POST["dept"];
    $doj= $_POST["doj"];
    $salary = $_POST["salary"];

    $conn = new mysqli("localhost", "root", "", "vinoth");
    $stmt = $conn->prepare("INSERT INTO empdetails (empid,ename,desig,dept,doj,salary) VALUES (?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("ssssss",$empid,$ename,$desig,$dept,$doj,$salary);
    if ($stmt->execute()) {
        echo "New record created successfully.";
    } else {
        echo "Error: " . $stmt->error;
    }
    $stmt->close();
    $conn->close();
?>
</body>
</html>