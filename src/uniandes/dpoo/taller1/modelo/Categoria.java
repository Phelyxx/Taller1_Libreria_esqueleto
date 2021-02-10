package uniandes.dpoo.taller1.modelo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import uniandes.dpoo.taller1.modelo.Libro;

/**
 * Esta clase representa a una categoría de libros dentro de la librería. Cada
 * categoría tiene un nombre único y además sabe si es una categoría a la que
 * pertenecen libros de ficción o no.
 */
public class Categoria
{
	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * Nombre de la categoría
	 */
	private String nombre;

	/**
	 * Indica si la categoría corresponde a libros de ficción o no
	 */
	private boolean ficcion;

	/**
	 * Lista de libros que hacen parte de la categoría
	 */
	private ArrayList<Libro> libros;
	/*
	 * TODO Parte 3 - agregar una asociación a la clase Libro llamada libros, que
	 * sea una lista de Libro
	 */

	// ************************************************************************
	// Constructores
	// ************************************************************************

	public Categoria(String nombre, boolean ficcion)
	{
		this.nombre = nombre;
		this.ficcion = ficcion;
		this.libros = new ArrayList<Libro>();
		/*
		 * TODO Parte 3 - inicializa la lista de libros con una lista vacía. Si esto no
		 * se hace al construir la categoría, la lista de libros sería null y todas las
		 * instrucciones para agregar libros fallarían.
		 */
	}

	// ************************************************************************
	// Métodos para consultar los atributos
	// ************************************************************************

	/**
	 * Consulta el nombre de la categoría
	 * 
	 * @return Categoria
	 */
	public String darNombre()
	{
		return nombre;
	}

	/**
	 * Consulta si esta es una categoría de ficción o no, con base en el atributo
	 * ficcion.
	 * 
	 * @return ficcion
	 */
	public boolean esFiccion()
	{
		return ficcion;
	}

	/**
	 * Retorna la lista de libros que hacen parte de la categoría
	 * 
	 * @return libros
	 * 
	 *
	 */
	public ArrayList<Libro> darLibros()
	{
		// cambien el valor de retorno de ArrayList<Libro> a List<Libro>
		//PENDIENTE
		// TODO Parte 3 - completar el método de acuerdo a la documentación
		return libros;
	}

	// ************************************************************************
	// Otros métodos
	// ************************************************************************

	/**
	 * Agrega un nuevo libro a la categoría
	 * 
	 * @param nuevoLibro El nuevo libro que se va a agregar.
	 */
	public void agregarLibro(Libro nuevoLibro)
	{
		libros.add(nuevoLibro);
		// LISTO
		// TODO Parte 3 - completar el método de acuerdo a la documentación
	}

	
	
	/**
	 * Cuenta la cantidad de libros en la categoría
	 * 
	 * @return Cantidad de libros
	 */
	
	public int contarLibrosEnCategoria()
	{
		return libros.size();
		//Set<Libro> numlibros = new HashSet<>();
		//for (Libro book : libros)
		//{
			//if (!numlibros.contains(book))
				//numlibros.add(book);
		//}
		// TODO Parte 3 - completar el método de acuerdo a la documentación
		// En este punto no debería tener que hacer ningún recorrido
		//return numlibros.size();
	}

	/**
	 * Calcula la calificación promedio de los libros que pertenecen a la categoría
	 * 
	 * @return Calificación promedio
	 */
	public double calificacionPromedio()
	{
		double promedio = 0.0;
		double calificaciones = 0.0;
		int numerocalificaciones = 0;
		while (numerocalificaciones < libros.size())
			{
				calificaciones += libros.get(numerocalificaciones).darCalificacion();
				numerocalificaciones ++;
			}
		promedio = calificaciones/numerocalificaciones;
		
		// TODO Parte 3 - completar el método de acuerdo a la documentación
		// En este punto tendrá que recorrer la lista de libros
		return promedio;
	}

	

	/**
	 * Consulta si en la categoría hay algún libro escrito por el autor indicado.
	 * 
	 * La búsqueda del autor se hace de forma exacta (tiene que ser idéntico al
	 * valor indicado en el parámetro nombreAutor).
	 * 
	 * @param nombreAutor El nombre del autor para el que se quiere hacer la
	 *                    búsqueda.
	 * @return Retorna true si hay al menos un libro cuyo autor es el autor buscado.
	 *         Retorna false de lo contrario.
	 */
	public boolean hayLibroDeAutor(String nombreAutor)
	{
		boolean exist = false;
		for (Libro book : libros)
			{
				if(book.darAutor().equals(nombreAutor) == true)
				{
					exist = true;
				}
			}
		// TODO Parte 3 - completar el método de acuerdo a la documentación
		return exist;
	}

	
	
	
	/**
	 * Busca en la categoría los libros escritos por el autor indicado.
	 * 
	 * El nombre del autor puede estar incompleto, y la búsqueda no debe tener en
	 * cuenta mayúsculas y minúsculas. Por ejemplo, si se buscara por "ulio v"
	 * deberían encontrarse los libros donde el autor sea "Julio Verne".
	 * 
	 * @param cadenaAutor La cadena que se usará para consultar el autor. No
	 *                    necesariamente corresponde al nombre completo de un autor.
	 * @return Una lista con todos los libros cuyo autor coincida con la cadena
	 *         indicada
	 */
	public ArrayList<Libro> buscarLibrosDeAutor(String nombreAutor)
	{
		ArrayList<Libro> librosautor = new ArrayList<Libro>();
		for (Libro li:libros)
		{
			if (li.darAutor().toLowerCase().contains(nombreAutor.toLowerCase()));
			{
				librosautor.add(li);
			}
		
		}
		//PENDIENTE SE PUEDE AÑADIR EL MÉTODO EQUALIGNORECASE
		// TODO Parte 3 - completar el método de acuerdo a la documentación
		// Recuerde retornar una lista nueva (no la lista del atributo libros)
		return librosautor;
	}

	// ************************************************************************
	// Métodos sobrecargados
	// ************************************************************************

	/**
	 * Este método permite representar una categoría como una cadena de caracteres
	 */
	@Override
	public String toString()
	{
		return nombre;
	}

}
