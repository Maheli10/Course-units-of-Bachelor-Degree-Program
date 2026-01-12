<?php 

$dsn= "mysql: host=localhost; dbname=it2133; charset=utf8mb4";
$user="root";
$pass="";

try{

    $pdo= new pdo($dsn,$user,$pass);
    $pdo-> setAttribute(PDO :: ATTR_ERRMODE,PDO ::ERRMODE_EXCEPTION);
}
catch(PDOException $e)
{
    die( "Connection Failed! ".$e-> getMessage());
}

?>