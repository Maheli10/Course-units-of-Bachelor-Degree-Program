<?php

session_start();

if(isset($_SESSION['username'])){
    $_SESSION=[];
    set_cookie(session_name(),FALSe);

    session_destroy();
}

header('Location: index.php');

?>