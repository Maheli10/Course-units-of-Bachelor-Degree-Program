<?php
require_once 'includes/config.php';

session_start();

if (isset($_SESSION['username']) && isset($_POST['item']) && isset($_POST['price'])) {
  $item  = trim($_POST['item']);
  $price = filter_var($_POST['price'], FILTER_VALIDATE_FLOAT, ['options' => ['min_range' => 0.00, 'max_range' => 10000.00]]);

  if ($price !== FALSE && strlen($item) <= 32) {
    $stmt = $pdo->prepare('INSERT INTO items VALUES (NULL, :item, :price)');
    $stmt->execute([
      'item'  => $item,
      'price' => (int) ($price * 100)
    ]);
  }
}

header('Location: index.php');
?>