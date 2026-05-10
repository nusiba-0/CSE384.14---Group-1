<?php
include("config.php");

$id = $_GET['id'];

$result = mysqli_query(
    $conn,
    "SELECT * FROM Reviews WHERE review_id='$id'"
);

$row = mysqli_fetch_assoc($result);


if(isset($_POST['update'])){

    $user_id = $_POST['user_id'];
    $rating = $_POST['rating'];
    $comment = $_POST['comment'];

    mysqli_query(
        $conn,

        "UPDATE Reviews SET

        user_id='$user_id',
        rating='$rating',
        comment='$comment'

        WHERE review_id='$id'"
    );

    header("Location: reviews.php");
    exit();
}
?>

<h2>Edit Review</h2>

<form method="POST">

    User ID:
    <input
        type="text"
        name="user_id"
        value="<?= $row['user_id'] ?>"
        required
    >
    <br><br>

    Rating:
    <input
        type="number"
        name="rating"
        value="<?= $row['rating'] ?>"
        min="1"
        max="5"
        required
    >
    <br><br>

    Comment:
    <textarea name="comment" required><?= $row['comment'] ?></textarea>
    <br><br>

    <input type="submit" name="update" value="Update">

</form>
