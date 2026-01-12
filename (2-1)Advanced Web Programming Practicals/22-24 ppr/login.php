<?php

require_once "includes/config2.php";
require_once "includes/validate.php";

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
     
    
        <form  class="interface" action="index.php" method="post">
            <table>
                <tr>
                    <th>
                        <h2>E-Library System</h2> 
                    </th>
                </tr>
                 <tr>
                    <th>
                        Username: 
                    </th>
                    <th>
                        <input type=text name=username id=username placeholder="Username" required>
                    </th>
                </tr>
                 <tr>
                    <th>
                       Pasword: 
                                           </th>
                    <th>
                        <input type=password name=password id=password placeholder="password" required>
                    </th>
                </tr>
                <tr >
                    <th colspan="2">
                        <button><a href="sdashboard.php">Login</a></button>
                    </th>
                </tr>
             </table>
        </form>
</body>
</html>