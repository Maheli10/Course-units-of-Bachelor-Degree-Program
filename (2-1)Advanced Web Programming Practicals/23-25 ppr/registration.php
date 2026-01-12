<?php
    require_once "includes/config.php";
    require_once "includes/validate.php";

    $values=[
        'name' =>'',
        'password'=>'',
        'confirmpssword'=>'',
        'firstname'=>'',
        'middlename'=> '',
        'lastname' => '',
        'age'=> '',
        'email'=> ''

    ];

    $error=[];

    if($_SERVER["REQUEST_METHOD"]==="POST"){
        foreach($values as $keys =>$_){
            $values[$keys]= trim($_POST[$keys]?? "");
        }

        $error['username']=validateusername($values['name']);
        $error['password'] =validatepassword($values['password']);
        $error['firstname']= validatefirstname($values['firstname']);
        $error['middlename']= validatemiddlename($values['middlename']);
        $error['lastname']= validatelastname($values['lastname']);
        $error['age']= validateage($values['age']);
        $error['email']= validateemail($values['email']);

        $error=array_filter($error);

        if(empty($error)){
            try{
                $hashed_password = password_hash($values['password'],PASSWORD_DEFAULT);

                $sql ="INSERT INTO  student (name,username,password)
                VALUES (:name,:usrname,:password)";

                $stmt= pdo -> prepare ($sql);

                $stmt -> bindParam(':name',$values['name']);
                $stmt ->bindParam(':password',$values['password']);
                $stmt -> bindParam(':email',$values['email']);

                $stmt -> execute();

                header('Location:login.php');
                exit;
            }
            catch(PDOException $e){
                die("Query failed.".$e->getMessage());
            }
        }

    }

?>



<!DOCTYPE html>
<html>
  <head>
    <title>Signup</title>
    <link rel="stylesheet" href="style.css" />
    <script src="js/jquery-3.7.1.min.js"></script>
    <script src="js/validate.js"></script>
  </head>
  <body>
    <table class="interface">
    <form method="post" action="registration.php" id="form">
      <tr><th colspan="2"><h2>Signup Form</h2></th></tr>
      <tr><td>Username</td>
          <td><input id="username" type="text" maxlength="16" name="name" value="<?= htmlspecialchars($values['name'])?>" placeholder="Name" required />
          <div class="error"><?= $error['name'] ?? ''?></div></td></tr>
          
      <tr><td>Password</td>
          <td><input type="password" minlength="8" name="password"value="<?=htmlspecialchars($values['password']) ?>" required />
          <div class="error"><?= $error['password']??'' ?></div>
      </td></tr>
      <tr><td>Confirm Password</td>
          <td><input type= "password" minlength="8" name="confirmpassword" value = "<?=htmlspecialchars($values['confirmpassword']) ?>" required />
          <div class="error"><?= $error['confirmpassword']??'' ?></div>
        </td></tr>
      <tr><td>First Name</td>
          <td><input type="text" maxlength="32" name="firstname" value="<?=htmlspecialchars($values['firstname']) ?>" required />
          <div class="error"><?= $error['firstname']??'' ?></div>
        </td></tr>
      <tr><td>Middle Name (Optional)</td>
          <td><input type="text" maxlength="32" name="middlename" value="<?=htmlspecialchars($values['middlename']) ?>" required />
          <div class="error"><?= $error['middlename']??'' ?></div></td></tr>
      <tr><td>Last Name</td>
          <td><input type="text" maxlength="32" name="lastname" value="<?=htmlspecialchars($values['lastname']) ?>" required />
          <div class="error"><?= $error['lastname']??'' ?></div></td></tr>
      <tr><td>Age</td>
          <td><input type="number" min="18" max="128" name="age" value="<?=htmlspecialchars($values['age']) ?>" required />
          <div class="error"><?= $error['age']??'' ?></div></td></tr>
      <tr><td>Email (Optional)</td>
          <td><input type="email" maxlength="254" name="email" value="<?= htmlspecialchars($values['email']) ?>" />
          <div class="error"><?= $error['email'] ??''?></div>
        </td></tr>
      <tr><td colspan="2" align="center"><input class="safe" type="submit" value="Register" /></td></tr>
      <tr><td colspan="2"><hr /></td></tr>
      <tr><td colspan="2">Already have an account? <a href="login.php">Login</a></td></tr>
    </form>
    </table>
    
  </body>
</html>
