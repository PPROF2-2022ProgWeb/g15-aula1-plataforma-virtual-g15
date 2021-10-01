<?php
$destino= "jennunc2014@gmail.com";
$Nombre= $_POST["Nombre"];
$Correo= $_POST["Correo"];
$Telefono= $_POST["Telefono"];
$mensaje= $_POST["mensaje"];
$contenido= .$nombre . "\ncorreo: " . $correo . "\ntelefono: " . $telefono . "\nmensaje: " . $mensaje;
mail ($destino,"Contacto", $contenido);
header ("location:"gracias.html")
?>