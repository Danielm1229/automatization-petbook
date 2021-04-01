# language: es
Característica: Filtrar imagenes
  Como usuario web
  Quiero filtrar las imágenes
  Para ver fotos específicas

  Escenario: Filtrar perros
    Cuando Usuario filtra por Perro en petbook
    Entonces debe ver solo fotos de perro
    
  Escenario: Filtrar gatos
    Cuando Usuario filtra por Gato en petbook
    Entonces debe ver solo fotos de gato