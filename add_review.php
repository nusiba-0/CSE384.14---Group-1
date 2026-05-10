<?php
include("config.php");

if(isset($_POST['submit'])){

    $user_id = $_POST['user_id'];
    $rating = $_POST['rating'];
    $comment = $_POST['comment'];

    mysqli_query(
        $conn,

        "INSERT INTO Reviews
        (user_id, rating, comment, date)

        VALUES
        ('$user_id','$rating','$comment',NOW())"
    );

    header("Location: reviews.php");
    exit();
}
?>

<h2>Add Review</h2>

<form method="POST">

    User ID:
    <input type="text" name="user_id" required>
    <br><br>

    Rating:
    <input type="number" name="rating" min="1" max="5" required>
    <br><br>

    Comment:
    <textarea name="comment" required></textarea>
    <br><br>

    <input type="submit" name="submit" value="Save">

</form>
