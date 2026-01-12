<?php   
    $dsn="mysql:host=localhost;dbname=librarydb;charset=utf8mb4";
    $user="root";
    $pass="";

    try{
        $pdo=new pdo($dsn,$user,$pass);

        $pdo->setAttribute(PDO:: ATTR_ERRMODE, PDO:: ERRMODE_EXCEPTION);
    }
    catch(PDOException $e){
        die("connection failed".$e->getMessage());
    }
?>

