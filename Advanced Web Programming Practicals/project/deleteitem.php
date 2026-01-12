<?php
require_once 'includes/config.php';

session_start();

if (isset($_SESSION['username']) && isset($_POST['id'])) {
  $stmt = $pdo->prepare('DELETE FROM items WHERE id=:id');
  $stmt->execute(['id' => $_POST['id']]);
}

header('Location: index.php');
?>