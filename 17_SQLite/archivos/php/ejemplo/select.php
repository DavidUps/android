<?php
$user = 'root';
$password = 'root';
$db = 'db_prueba';
$host = 'localhost';
$port = 3306;

$json = array();

$conn = mysqli_init();
$success = mysqli_real_connect($conn,$host,$user,$password,$db,$port);
/*
if ($success) {
  $sql = "SELECT id,email, name, password FROM registry";
  $result = $conn->query($sql);
  if($result->num_rows >0){
    while ($row = $result->fetch_assoc()) {
      $json[$row["id"]]['user']["email"]=$row["email"];
      $json[$row["id"]]['user']["name"]=$row["email"];
      $json[$row["id"]]['user']["password"]=$row["email"];
    }

    echo json_encode($json);
  }
  else {
    echo "0 reults";
  }
}
else {
  echo "No hay conexion";
}
*/
//SELECT DE EMAIL QUE METAS PARA DARTE CONTRASEÑA
if ($success) {
  if (isset($_POST["id"])) {
    $id = $_POST["id"];
    $sql = "SELECT id,email,name, password FROM registry WHERE id = '$id'";
    $result = $conn->query($sql);
    if($result->num_rows >0){
      while ($row = $result->fetch_assoc()) {
        $json['user']["id"]=$row["id"];
        $json['user']["email"]=$row["email"];
        $json['user']["name"]=$row["name"];
        $json['user']["password"]=$row["password"];
      }
      echo json_encode($json);
    }
    else {
      echo "0 reults";
    }
  }else {
    echo "no se ha insertado nada";
  }
}
else {
  echo "No hay conexion";
}
 ?>
