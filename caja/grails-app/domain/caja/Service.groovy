package caja

class Service {
	String descripcion
	String fecha
	String nombre
	static constraints = {
		fecha(nulleable:true)
	}
}
