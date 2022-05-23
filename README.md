# Api-Booking

## 1) Gestionar los products para utilizarlos en el sitio
### Como administrador quiero poder gestionar los products para utilizarlos en el sitio.


	1	Crear tabla “products” en la BD. Los atributos son:
	
		◦	id
		◦	nombre
		◦	descripción
		
	2	El controller de products tiene que permitirnos
	
		◦	Crear products
		◦	Buscar y retornar products por ID

## 2) Agregar categoría a un product
### Como administrador quiero poder agregar una categoría a un product para organizar los products similares.


	1	Agregar relación ManyToOne entre la clase categoría y product.
	
		◦	Utilizar hibernate o realizarlo desde la base de datos y luego mapearlo en la clase product.
		◦	La clase product deberá tener un atributo que indique la categoría a la que pertenece, para implementarlo vamos a usar una relación muchos (product) a uno (categoría).
	
## 3) Características para products
### Como administrador quiero poder gestionar las características para describir products


	1	Crear tabla “features” en la base de datos, que deberá tener como atributos:
	
		◦	id
		◦	nombre
		◦	ícono
	
## 4) Gestión de ciudades
### Como administrador quiero poder gestionar las ciudades para poder relacionarlas a products.


	1	Crear tabla “ciudades” en la base de datos. Deberá tener como atributos:
	
		◦	id
		◦	nombre
		◦	nombre_pais
		
	2	Mapear las tablas “ciudades”, “products” e “imagenes” con clases del modelo.
	
	3	Agregar ciudades en la BD (opcional)
	
## 5) Indicar la ciudad de un product
## Como administrador quiero poder indicar la ciudad de un product para que los usuarios puedan conocer su ubicación y buscar por este dato.


	1	Agregar relación ManyToOne entre ciudad y product.
	
		◦	Utilizar hibernate o realizarlo desde la base de datos y luego mapearlo en la clase product.
		◦	La clase product deberá tener un atributo que indique la ciudad a la que pertenece, para implementarlo vamos a usar una relación muchos (product) a uno (ciudad).

## 6) Gestionar las imágenes del product
### Como administrador quiero poder gestionar las imágenes del product para ilustrarlo.


	1	Crear tabla “imagenes” en la base de datos, que deberá tener como atributos:
	
		◦	id
		◦	título
		◦	url
	2	Mapear las tablas “ciudades”, “products” e “imagenes” con clases del modelo
	
		◦	Crear las clases necesarias dentro de nuestro paquete ”Model” para mapear con las tablas de la base de datos.
