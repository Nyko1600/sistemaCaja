package caja

class Caja {
	long pay_id
	long client_id
	double monto
	Date created = new Date()
	static constraints = {
		
	}
	String toString(){
		return "caja id: $id, id del cleinte ${client_id}, id del servicio ${pay_id}, monto ${monto}, fecha ${created.toString()}"
	}
}
