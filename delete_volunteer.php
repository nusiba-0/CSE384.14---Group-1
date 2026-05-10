<?php
include("config.php");

$id = $_GET['id'];

mysqli_query(
    $conn,
    "DELETE FROM Volunteers WHERE volunteer_id='$id'"
);

header("Location: volunteers.php");
exit();
?>
