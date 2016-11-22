package caja

class Pay {
	String descripcion
	String fecha
	String nombre
	static constraints = {
		fecha(nulleable:true)
	}
}
