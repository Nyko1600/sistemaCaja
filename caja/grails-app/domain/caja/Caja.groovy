package caja

class Caja {
	int service_id
	int client_id
	double monto
	Date created = new Date()
	static constraints = {
		
	}
	String toString(){
		return "caja id: $id, id del cleinte ${client_id}, id del servicio ${service_id}, monto ${monto}, fecha ${created.toString()}"
	}
}
