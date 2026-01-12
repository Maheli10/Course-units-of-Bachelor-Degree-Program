<?php

    require_once "config2.php";


    function validateName($field){
            $field= trim($field);

            if($field==='') return "Please enter a value";
            if(strlen($field)>32) return "name should not exceed 32 characters.";
            return;
    }

    function validateUsername($username){
        $username= trim($username);
        if($username=== '')return "Username must be valid";

        if(!preg_match("/^[a-zA-Z0-9\$_]+$/",$username))
            return "Use only characters from a-z and 0-9 and _";
        if(strlen($username)<3) return "Username must ba at least 3 characters";
    return "";
    }

    function validatePassword($field){
        if($field==='') return "Please enter a value !";
        if(strlen($field)<8) return "Pasword must be at least 8 characters";
        return "";

    }

    /*function vailidateConfirmPass($field1,$field2){
        if($field==='') return "please enter a value";
        if($field1 !== $field2) return "password does nor match";
        return ;
    }*/


    function validateEmail($email){
        $email= trim($email);
        if($email==='') return "Email cannot be empty";
        if(!filter_var($email,FILTER_VALIDATE_EMAIL)) return "Enter a valid email.";
        return "";
    }

    function validateAge($field){

        if($field==='') return "Please enter a value";
        else if(!filter_var($field,FILTER_VALIDATE_INT,['options'=> ['min_range'=>18,'max_range'=>128]]))
            return "";
        }




/*require_once "config2.php";

function validateName($field) {
    $field = trim($field);
    if ($field === '') return "Please enter a value";
    if (strlen($field) > 32) return "Name should not exceed 32 characters";
    return "";
}

function validateUsername($username) {
    $username = trim($username);
    if ($username === '') return "Username cannot be empty";
    if (!preg_match("/^[a-zA-Z0-9_]+$/", $username))
        return "Use only letters, numbers and underscore";
    if (strlen($username) < 3)
        return "Username must be at least 3 characters";
    return "";
}

function validatePassword($field) {
    if ($field === '') return "Please enter a password";
    if (strlen($field) < 8) return "Password must be at least 8 characters";
    return "";
}

function validateEmail($email) {
    $email = trim($email);
    if ($email === '') return "Email cannot be empty";
    if (!filter_var($email, FILTER_VALIDATE_EMAIL))
        return "Enter a valid email";
    return "";
}

function validateAge($field) {
    if ($field === '') return "Please enter age";
    if (!filter_var($field, FILTER_VALIDATE_INT,
        ['options' => ['min_range' => 18, 'max_range' => 128]]))
        return "Age must be between 18 and 128";
    return "";
}*/
?>