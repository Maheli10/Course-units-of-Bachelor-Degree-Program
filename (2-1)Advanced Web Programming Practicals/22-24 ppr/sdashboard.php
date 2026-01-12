<?php
require_once "includes/config2.php";

/* DELETE RECORD */
if (isset($_GET['delete'])) {
    $id = (int) $_GET['delete'];

    $stmt = $pdo->prepare("DELETE FROM student WHERE id = :id");
    $stmt->execute([':id' => $id]);

    header("Location: index.php");
    exit;
}

/* FETCH RECORDS */
$stmt = $pdo->query("SELECT name, username, email, age FROM student");
$students = $stmt->fetchAll(PDO::FETCH_ASSOC);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<p class="interface">
    <h2>E-Library System</h2>
    <h3>Student Dashboard</h3>
    <br>
    <table border="1" cellpadding="8">
        <tr>
            
            <th>Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Age</th>
            <th>Action</th>
        </tr>

        <?php if ($students): ?>
            <?php foreach ($students as $row): ?>
                <tr>

                    <td><?= htmlspecialchars($row['name']) ?></td>
                    <td><?= htmlspecialchars($row['username']) ?></td>
                    <td><?= htmlspecialchars($row['email']) ?></td>
                    <td><?= htmlspecialchars($row['age']) ?></td>
                    <td>
    <form method="get" action="index.php" onsubmit="return confirm('Are you sure you want to delete this record?');">
        <input type="hidden" name="delete" value="<?= $row['id'] ?>">
        <button type="submit" class="danger">Delete</button>
    </form>
</td>

                </tr>
            <?php endforeach; ?>
        <?php else: ?>
            <tr>
                <td colspan="6">No records found</td>
            </tr>
        <?php endif; ?>
    </table>

    <br>
    <a href="logout.php">
        <button>Logout</button>
    </a>
        </p>

</body>
</html>
