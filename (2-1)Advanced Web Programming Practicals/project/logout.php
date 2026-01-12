<?php
session_start();

if (isset($_SESSION['username'])) {
  $_SESSION = [];
  setcookie(session_name(), FALSE);
  session_destroy();
}

header('Location: index.php');
?>