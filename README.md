# Api-Booking

## Gestionar los productos para utilizarlos en el sitio
### Como administrador quiero poder gestionar los productos para utilizarlos en el sitio.

Tareas (2)
	1	Crear tabla “productos” en la BD. Los atributos son:
	
		◦	id
		◦	nombre
		◦	descripción
		
	2	El controller de productos tiene que permitirnos
		◦	Crear productos
		◦	Buscar y retornar productos por ID

## Agregar categoría a un producto
### Como administrador quiero poder agregar una categoría a un producto para organizar los productos similares.

Tareas (1)
	1	Agregar relación ManyToOne entre la clase categoría y producto.
	◦	Utilizar hibernate o realizarlo desde la base de datos y luego mapearlo en la clase producto.
	◦	La clase producto deberá tener un atributo que indique la categoría a la que pertenece, para implementarlo vamos a usar una relación muchos (producto) a uno (categoría).
	
## Características para productos
### Como administrador quiero poder gestionar las características para describir productos

Tareas (1)
	1	Crear tabla “caracteristicas” en la base de datos, que deberá tener como atributos:
	◦	id
	◦	nombre
	◦	ícono
	
## Gestión de ciudades
### Como administrador quiero poder gestionar las ciudades para poder relacionarlas a productos.

Tareas (3)
	1	Crear tabla “ciudades” en la base de datos. Deberá tener como atributos:
	◦	id
	◦	nombre
	◦	nombre_pais
	2	Mapear las tablas “ciudades”, “productos” e “imagenes” con clases del modelo.
	3	Agregar ciudades en la BD (opcional)
	
## Indicar la ciudad de un producto
## Como administrador quiero poder indicar la ciudad de un producto para que los usuarios puedan conocer su ubicación y buscar por este dato.

Tareas (1)
	1	Agregar relación ManyToOne entre ciudad y producto.
	◦	Utilizar hibernate o realizarlo desde la base de datos y luego mapearlo en la clase producto.
	◦	La clase producto deberá tener un atributo que indique la ciudad a la que pertenece, para implementarlo vamos a usar una relación muchos (producto) a uno (ciudad).

## Gestionar las imágenes del producto
### Como administrador quiero poder gestionar las imágenes del producto para ilustrarlo.

Tareas (2)
	1	Crear tabla “imagenes” en la base de datos, que deberá tener como atributos:
	◦	id
	◦	título
	◦	url
	2	Mapear las tablas “ciudades”, “productos” e “imagenes” con clases del modelo
	◦	Crear las clases necesarias dentro de nuestro paquete ”Model” para mapear con las tablas de la base de datos.
