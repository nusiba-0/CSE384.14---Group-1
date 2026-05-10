<?php
include("config.php");

$id = $_GET['id'];

mysqli_query(
    $conn,
    "DELETE FROM Reviews WHERE review_id='$id'"
);

header("Location: reviews.php");
exit();
?>
