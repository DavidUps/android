<?php
$user = 'root';
$password = 'root';
$db = 'db_prueba';
$host = 'localhost';
$port = 3306;

$con = mysqli_init();
$success = mysqli_real_connect($con,$host,$user,$password,$db,$port);

  if ($success) {
    if (isset($_POST['email']) && isset($_POST['name']) && isset($_POST['password'])) {
      $email = $_POST['email'];
      $name = $_POST['name'];
      $password = $_POST['password'];

      $sql = "INSERT INTO registry (email, name, password) VALUES ('$email', '$name', '$password')";
      $result = $con->query($sql);
      if ($result === TRUE) {
        echo "Usuario Añadido";
      }
      else {
        echo "Error: " .$sql . "<br>" . $con->error;
      }
      mysqli_close($conexion);
    }
    else {
      echo "No se han insertado datos";
    }
  }
  else {
    echo "No se ha conectado";
  }
 ?>
