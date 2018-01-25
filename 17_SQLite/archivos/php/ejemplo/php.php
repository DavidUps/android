<?php
$user = 'root';
$password = 'root';
$db = 'alimentadoranimales';
$host = 'localhost';
$port = 3306;

$json = array();

$link = mysqli_init();
$conexion = mysqli_real_connect($link,$host,$user,$password,$db,$port);

if ($conexion)
{
  if (isset($_POST["email"]) && isset($_POST["name"]) && isset($_POST["password"]))
  {
    $email = $_POST['email'];
    $name = $_POST['name'];
    $password = $_POST['password'];
    
    $sqlInsert="INSERT INTO userlogin(email, name, password) VALUES ('$email','$name','$password')";

    //$resultado_insert=mysqli_query($insert);
    $result = $link->query($sqlInsert);
    if ($result == TRUE) {
        $json['createUser']["result"]=TRUE;
        //Devolver id
    } else {
        $json['createUser']["result"]=FALSE;
        $json['createUser']["message"]=mysqli_error($link);
    }
    echo json_encode($json);

    mysqli_close($conexion);
  }
}
else
{
  echo "No se ha conetado";
}

 ?>
