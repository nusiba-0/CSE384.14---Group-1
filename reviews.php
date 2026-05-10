<?php
include("config.php");

$result = mysqli_query($conn, "SELECT * FROM Reviews");
?>

<h2>Review Management</h2>

<a href="add_review.php">Add Review</a>

<br><br>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th>
        <th>User ID</th>
        <th>Rating</th>
        <th>Comment</th>
        <th>Date</th>
        <th>Action</th>
    </tr>

    <?php while($row = mysqli_fetch_assoc($result)) { ?>

    <tr>

        <td><?= $row['review_id'] ?></td>
        <td><?= $row['user_id'] ?></td>
        <td><?= $row['rating'] ?></td>
        <td><?= $row['comment'] ?></td>
        <td><?= $row['date'] ?></td>

        <td>

            <a href="edit_review.php?id=<?= $row['review_id'] ?>">
                Edit
            </a>

            |

            <a href="delete_review.php?id=<?= $row['review_id'] ?>">
                Delete
            </a>

        </td>

    </tr>

    <?php } ?>

</table>
