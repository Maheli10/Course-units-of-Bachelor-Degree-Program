<?php
require_once 'includes/config.php';
require_once 'includes/validate.php';

session_start();

if (isset($_POST['username'])) {
  $username = trim($_POST['username']);

  if (validate_username($username)) {
    $data = [
      'class' => 'error',
      'text' => '❌ The username is not available.',
    ];
  } else {
    $data = [
      'class' => 'success',
      'text' => '✔️ The username is available.',
    ];
  }

  echo json_encode($data);
} else {
  header('Location: index.php');
}
?>