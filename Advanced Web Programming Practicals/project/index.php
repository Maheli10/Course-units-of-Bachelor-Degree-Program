<?php
require_once 'includes/config.php';

session_start();

if (isset($_SESSION['username'])) {
  $stmt = $pdo->prepare("SELECT * FROM items");
  $stmt->execute();
  $result = $stmt->fetchAll();
} else {
  $username = '';
  $error    = '';

  if ($_POST) {
    if (isset($_POST['username'])) {
      $username = trim($_POST['username']);

      if (isset($_POST['password'])) {
        $stmt = $pdo->prepare('SELECT username, password, firstname, middlename, lastname FROM users WHERE username=:username');
        $stmt->execute(['username' => $username]);
        $result = $stmt->fetchAll();

        if (1 === count($result) && password_verify($_POST['password'], $result[0]['password'])) {
          session_regenerate_id();

          $_SESSION['username'] = $result[0]['username'];
          $_SESSION['firstname'] = $result[0]['firstname'];
          $_SESSION['middlename'] = $result[0]['middlename'];
          $_SESSION['lastname'] = $result[0]['lastname'];
          header('Location: index.php');
          exit;
        }
      }
    }
    
    $error = 'Invalid login attempt.';
  }
}
?>
<!DOCTYPE html>
<html>
  <head>
    <title>Store</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <table class="interface">
    <?php if (isset($_SESSION['username'])) { ?>
      <tr><td colspan="3">Hi <?php echo htmlentities($_SESSION['firstname']) . ' ' . htmlentities($_SESSION['lastname']); ?>!</td>
          <td align="right"><a href="logout.php"><button class="danger" type="button">Logout</button></a></td></tr>
      <tr><td colspan="4"><hr /></td></tr>
      <form method="post" action="additem.php">
        <tr>
          <td colspan="4">
            <input type="text" maxlength="32" name="item" placeholder="Item" required />
            &nbsp;Rs. <input type="number" min="0.00" max="10000.00" name="price" step="0.01" value="0.00" required />
            <input class="safe" type="submit" value="➕" />
          </td>
        </tr>
      </form>
      <tr><td colspan="4"><hr /></td></tr>
      <tr><td align>Id</td><td align>Item</td><td align="right">Price (Rs.)</td><td></td></tr>
      <?php foreach ($result as $row) { ?><tr>
        <td><?php echo htmlentities($row['id']); ?></td>
        <td><?php echo htmlentities($row['item']); ?></td>
        <td align="right"><?php echo htmlentities(number_format($row['price'] / 100, 2)); ?></td>
        <td>
          <form method="post" action="deleteitem.php">
            <input type="hidden" name="id" value="<?php echo htmlentities($row['id']); ?>" />
            <input class="danger" type="submit" value="❌" />
          </form>
        </td></tr>
      <?php } ?>
    <?php } else { ?>
      <form method="post" action="">
        <?php if (isset($_GET['success'])) { ?>
        <tr><td colspan="2"><p><i class="success">Account created. Please login.</i></p></td></tr>
        <?php }?>
        <?php if ($error) { ?>
        <tr><td colspan="2"><p><i class="error"><?php echo $error; ?></i></p></td></tr>
        <?php } ?>
        <tr><td>Username</td>
            <td><input type="text" maxlength="16" name="username" value="<?php echo htmlentities($username); ?>" required /></td></tr>
        <tr><td>Password</td>
            <td><input type="password" name="password" required /></td></tr>
        <tr><td colspan="2" align="center"><input class="safe" type="submit" value="Login" /></td></tr>
        <tr><td colspan="2"><hr /></td></tr>
        <tr><td colspan="2">Don't have an account? <a href="signup.php">Signup</a></td></tr>
      </form>
    <?php } ?>
    </table>
  </body>
</html>
