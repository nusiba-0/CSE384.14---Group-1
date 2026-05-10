<?php
include("config.php");

if(isset($_POST['submit'])){

    $user_id = $_POST['user_id'];
    $area = $_POST['assigned_area'];
    $schedule = $_POST['schedule'];
    $status = $_POST['status'];

    mysqli_query(
        $conn,

        "INSERT INTO Volunteers
        (user_id, assigned_area, schedule, availability_status)

        VALUES
        ('$user_id','$area','$schedule','$status')"
    );

    header("Location: volunteers.php");
    exit();
}
?>

<h2>Add Volunteer</h2>

<form method="POST">

    User ID:
    <input type="text" name="user_id" required>
    <br><br>

    Assigned Area:
    <input type="text" name="assigned_area" required>
    <br><br>

    Schedule:
    <input type="text" name="schedule" required>
    <br><br>

    Status:
    <input type="text" name="status" required>
    <br><br>

    <input type="submit" name="submit" value="Save">

</form>
