<?php
function validate_username($field){
    if($field == ''){
        return "User Name is required!";
    } elseif (strlen($field)>16){
        return "User Name can't exceed 16 charecters";
    } else{
        return '';
    }
}

function validate_firstname($field){
    if($field == ''){
        return "First Name is required!";
    } elseif (strlen($field)>32){
        return "First Name can't exceed 32 charecters";
    } else{
        return '';
    }
}

function validate_lastname($field){
    if (strlen($field)>32){
        return "Last Name can't exceed 32 charecters";
    } else{
        return '';
    }
}

function validate_password($field){
    if($field == ''){
        return "Password is required!";
    } elseif (strlen($field)<8){
        return "Password must have at least 8 charcters.";
    } else{
        return '';
    }
}
?>

