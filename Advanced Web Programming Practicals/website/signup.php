<?php
require_once "includes/config.php";
require_once "includes/validateform.php";

$username ='';
$firstname ='';
$lastname ='';
$password ='';

$errors = [];

?>

<!DOCTYPE html>
<html>
<head>
    <title> Sign Up </title>
</head>
<body>
    <h1> Sign Up </h1>
<form action="" method="post">

<?php
    if ($_POST){
        $username =$_POST['username'];
        $firstname =$_POST['firstname'];
        $lastname =$_POST['lastname'];
        $password =$_POST['password'];
        $errors = [];

        $error = validate_username($username);
        if($error) {
            $errors['username'] = $error;
        }

        $error = validate_firstname($firstname);
        if($error) {
            $errors['firstname'] = $error;
        }

        $error = validate_lastname($lastname);
        if($error) {
            $errors['lastname'] = $error;
        }

        $error = validate_password($password);
        if($error) {
            $errors['password'] = $error;
        }
        //var_dump($errors);


    if($errors){
        echo "Your form has following erros:";
        foreach ($errors as $msg){
            echo $msg. '<br/>';
        }
    } else {
        $stmt = $pdo->prepare("SELECT COUNT(*) FROM users WHERE username =:username");
        $stmt-> execute(['username' => $username]);
        $exists = $stmt->fetchColumn();
    
        if($exists){
            echo "The user already exist!";
        } else{
        $stmt = $pdo->prepare("INSERT INTO users VALUES (:username, :password, :firstname, :lastname)");
        $stmt->execute([
            'username' => $username,
            'password' => $password,
            'firstname' => $firstname,
            'lastname' => $lastname
        ]);
        }
    }
}
?>

<input type = "text" name = "username" maxlength="16" value ="<?php echo $username;?>"  placeholder ="User Name" required/> </br> </br>
<input type = "text" name = "firstname" maxlength="32" value ="<?php echo $firstname;?>"  placeholder ="First Name" required/> </br> </br>
<input type = "text" name = "lastname" maxlength="32" value ="<?php echo $lastname;?>"  placeholder ="Last Name"/> </br> </br>
<input type = "password" name = "password" minlength="8" value ="<?php echo $password;?>"  placeholder ="Password" required/> </br> </br>
<input type="submit" value="Sign Up"/>
</form>
</body>
</html>