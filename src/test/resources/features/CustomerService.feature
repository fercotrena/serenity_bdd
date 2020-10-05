# language: es
Característica: Servicio al Cliente.
  Como un usuario registrado en la aplicación quiero poder comunicarme con el servicio de atención
  al cliente para informar mi problema con la aplicación.


  Escenario:  Enviar un mensaje
    Dado un usuario contectado en la aplicacion
    Cuando accede a la vista de Servicio al cliente
    Y envia el mensaje de reclamos con los datos requeridos
    Entonces se notifica que el mensaje ha sido enviado con éxito

  Escenario:  Enviar un mensaje sin email de contacto
    Dado un usuario contectado en la aplicacion
    Cuando accede a la vista de Servicio al cliente
    Y envia el mensaje de reclamo sin incluir el email de contacto
    Entonces se notifica que el mensaje no se pudo enviar