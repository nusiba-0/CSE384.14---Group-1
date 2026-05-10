<?php
include("config.php");

$result = mysqli_query($conn, "SELECT * FROM Volunteers");
?>

<h2>Volunteer Management</h2>

<a href="add_volunteer.php">Add Volunteer</a>

<br><br>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Assigned Area</th>
        <th>Schedule</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <?php while($row = mysqli_fetch_assoc($result)) { ?>

    <tr>

        <td><?= $row['volunteer_id'] ?></td>
        <td><?= $row['user_id'] ?></td>
        <td><?= $row['assigned_area'] ?></td>
        <td><?= $row['schedule'] ?></td>
        <td><?= $row['availability_status'] ?></td>

        <td>

            <a href="edit_volunteer.php?id=<?= $row['volunteer_id'] ?>">
                Edit
            </a>

            |

            <a href="delete_volunteer.php?id=<?= $row['volunteer_id'] ?>">
                Delete
            </a>

        </td>

    </tr>

    <?php } ?>

</table>
