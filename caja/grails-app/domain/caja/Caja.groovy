package caja

class Caja {
	int service_id
	int client_id
	double monto
	Date created = new Date()
	static constraints = {
		client_id(blank:true)
		service_id(nulleable:true)
		//client_id(maxSize:1000, blank:false)
	}
	String toString(){
		return "id del cleinte ${client_id}, id del servicio ${service_id}, monto ${monto}, fecha ${created.toString()}"
	}
}
