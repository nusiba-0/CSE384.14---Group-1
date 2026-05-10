<?php
include("config.php");

$id = $_GET['id'];

$result = mysqli_query(
    $conn,
    "SELECT * FROM Volunteers WHERE volunteer_id='$id'"
);

$row = mysqli_fetch_assoc($result);


if(isset($_POST['update'])){

    $user_id = $_POST['user_id'];
    $area = $_POST['assigned_area'];
    $schedule = $_POST['schedule'];
    $status = $_POST['status'];

    mysqli_query(
        $conn,

        "UPDATE Volunteers SET

        user_id='$user_id',
        assigned_area='$area',
        schedule='$schedule',
        availability_status='$status'

        WHERE volunteer_id='$id'"
    );

    header("Location: volunteers.php");
    exit();
}
?>

<h2>Edit Volunteer</h2>

<form method="POST">

    User ID:
    <input
        type="text"
        name="user_id"
        value="<?= $row['user_id'] ?>"
        required
    >
    <br><br>

    Assigned Area:
    <input
        type="text"
        name="assigned_area"
        value="<?= $row['assigned_area'] ?>"
        required
    >
    <br><br>

    Schedule:
    <input
        type="text"
        name="schedule"
        value="<?= $row['schedule'] ?>"
        required
    >
    <br><br>

    Status:
    <input
        type="text"
        name="status"
        value="<?= $row['availability_status'] ?>"
        required
    >
    <br><br>

    <input type="submit" name="update" value="Update">

</form>
