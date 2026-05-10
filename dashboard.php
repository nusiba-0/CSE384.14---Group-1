<?php
require_once 'config.php';

if (!isset($_SESSION['user_id'])) {
    header("Location: index.php");
    exit();
}

$name = htmlspecialchars($_SESSION['user_name']);
$role = htmlspecialchars($_SESSION['user_role']);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - MeoWoof</title>
</head>

<body style="font-family: Arial; background: whitesmoke; display:flex; justify-content:center; align-items:center; height:100vh;">

<div style="background:white; padding:40px; border-radius:20px; text-align:center; width:400px; box-shadow:0 4px 20px rgba(0,0,0,0.1);">

    <div style="font-size:50px;">Pet</div>

    <h2 style="color:darkgreen;">Welcome, <?= $name ?>!</h2>

    <p style="color:gray;">You have successfully logged in to MeoWoof.</p>

    <div style="margin-top:15px; display:inline-block; padding:6px 16px; background:lightgreen; color:green; border:1px solid green; border-radius:20px;">
        Role: <?= $role ?>
    </div>

    <br><br>

    <a href="logout.php"
       style="display:inline-block; padding:12px 25px; background:seagreen; color:white; text-decoration:none; border-radius:12px; font-weight:bold;">
       Logout
    </a>

</div>

</body>
</html>
