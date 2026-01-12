<?php
require_once "includes/config2.php";
require_once "includes/validate.php";

/* ------------------ INITIAL VALUES ------------------ */
$values = [
    'name' => '',
    'username' => '',
    'password' => '',
    'email' => '',
    'age' => ''
];

$error = [];

function isUnique($username) {
    global $pdo;

    $sql = "SELECT COUNT(*) FROM student WHERE username = :username";
    $stmt = $pdo->prepare($sql);
    $stmt->bindParam(':username', $username);
    $stmt->execute();

    return $stmt->fetchColumn() == 0;
}


/* ------------------ FORM SUBMISSION ------------------ */
if ($_SERVER["REQUEST_METHOD"] === "POST") {

    foreach ($values as $key => $_) {
        $values[$key] = trim($_POST[$key] ?? "");
    }

    /* ------------------ VALIDATION ------------------ */
    $error['name']     = validateName($values['name']);
    $error['password'] = validatePassword($values['password']);
    $error['email']    = validateEmail($values['email']);
    $error['age']      = validateAge($values['age']);

    /* Username validation + uniqueness */
    $error['username'] = validateUsername($values['username']);

if ($error['username'] === "") {
    if (!isUnique($values['username'])) {
        $error['username'] = "Username already exists!";
    }
}


    /* Remove empty errors */
    $error = array_filter($error);

    /* ------------------ INSERT DATA ------------------ */
    if (empty($error)) {
        try {
            $hashed_password = password_hash($values['password'], PASSWORD_DEFAULT);

            $sql = "INSERT INTO student (name, username, password, email, age)
                    VALUES (:name, :username, :password, :email, :age)";

            $stmt = $pdo->prepare($sql);

            $stmt->bindParam(':name', $values['name']);
            $stmt->bindParam(':username', $values['username']);
            $stmt->bindParam(':password', $hashed_password);
            $stmt->bindParam(':email', $values['email']);
            $stmt->bindParam(':age', $values['age']);

            $stmt->execute();

            header("Location: login.php");
            exit;
        }
        catch (PDOException $e) {
            die("Query failed: " . $e->getMessage());
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<form class="interface" action="register.php" method="post">
    <table>
        <tr>
            <th colspan="2"><h2>E-Library System</h2></th>
        </tr>

        <tr>
            <th>Name</th>
            <td>
                <input type="text" name="name" value="<?= htmlspecialchars($values['name']) ?>">
                <div class="error"><?= $error['name'] ?? '' ?></div>
            </td>
        </tr>

        <tr>
            <th>Username</th>
            <td>
                <input type="text" name="username" value="<?= htmlspecialchars($values['username']) ?>">
                <div class="error"><?= $error['username'] ?? '' ?></div>
            </td>
        </tr>

        <tr>
            <th>Password</th>
            <td>
                <input type="password" name="password">
                <div class="error"><?= $error['password'] ?? '' ?></div>
            </td>
        </tr>

        <tr>
            <th>Email</th>
            <td>
                <input type="email" name="email" value="<?= htmlspecialchars($values['email']) ?>">
                <div class="error"><?= $error['email'] ?? '' ?></div>
            </td>
        </tr>

        <tr>
            <th>Age</th>
            <td>
                <input type="text" name="age" value="<?= htmlspecialchars($values['age']) ?>">
                <div class="error"><?= $error['age'] ?? '' ?></div>
            </td>
        </tr>

        <tr>
            <th colspan="2">
                <button type="submit">Register</button>
            </th>
        </tr>
    </table>
</form>

</body>
</html>
