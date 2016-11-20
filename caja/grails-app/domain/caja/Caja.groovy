package caja

class Caja {
	int service_id
	int client_id
	double monto
	Date created = new Date()
	static constraints = {
		client_id(blank:true)
		service_id(nulleable:true)
	}
	String toString(){
		return "id del cleinte ${client_id}, id del servicio ${service_id}, monto ${monto}, fecha ${created.toString()}"
	}
}
