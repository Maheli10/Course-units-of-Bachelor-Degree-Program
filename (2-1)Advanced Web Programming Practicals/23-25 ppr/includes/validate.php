<?php

    require_once "config.php";

    function validatename($field){
        $field= trim($field);
        if($field ==='') return "enter a value !";


        if(!preg_match("/^[a-zA-Z0-9\$_]+$/",$field)) return "Use only chaacters from a-z and 0-9 or _";

        if(strlen($field)>32) return "nae should not exceed 32 chaacters" ;
        return "";
    }

    function validatepassword($field){
        
        if($field ==='') return "enter a value !";

        //if(!preg_match("/^[a-zA-Z0-9\$_]+$/",$field)) return "Use only chaacters from a-z and 0-9 or _";

        if(strlen($field)<8) return " pass should have at least 8 chaacters" ;
        return "";
    }

    function validateconfirmpassword($field1,$field2){
        
        if($field ==='') return "enter a value !";

        if($field !== $field2) return "Password does not match !";

        return ;
    }

    function validatefirstname($field){
        $field= trim($field);
        if($field ==='') return "enter a value !";


        if(!preg_match("/^[a-zA-Z0-9\$_]+$/",$field)) return "Use only chaacters from a-z and 0-9 or _";

        if(strlen($field)>32) return "nae should not exceed 32 chaacters" ;
        return "";
    }

    function validatmiddleename($field){
        $field= trim($field);
        if($field ==='') return "enter a value !";


        if(!preg_match("/^[a-zA-Z0-9\$_]+$/",$field)) return "Use only chaacters from a-z and 0-9 or _";

        if(strlen($field)>32) return "nae should not exceed 32 chaacters" ;
        return "";
    }

    function validatelastname($field){
        $field= trim($field);
        if($field ==='') return "enter a value !";


        if(!preg_match("/^[a-zA-Z0-9\$_]+$/",$field)) return "Use only chaacters from a-z and 0-9 or _";

        if(strlen($field)>32) return "nae should not exceed 32 chaacters" ;
        return "";
    }

    function validateage($field){
        $field= trim($field);
        if($field ==='') return "enter a value !";
        if(!filter_var($field, FILTER_VALIDATE_EMAIL))  return "enter a valid email";
        return "";
    }

    function validateemail($field){
        $field= trim($field);
        if($field ==='') return "enter a value !";
        if(!filter_var($field,FILTER_VALIDATE_INT)) return "enter a valid value";
        return "";
    }


?>