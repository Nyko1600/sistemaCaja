package caja

import grails.transaction.Transactional

@Transactional
class CajaService {
	def addPay(int client_id, int service_id=null, double monto){
		Date fecha = new Date();

		def nuevaCaja = new Caja(client_id:client_id,service_id:service_id,monto:monto,created:fecha)
		if (!nuevaCaja.save()) {
			nuevaCaja.errors.each { println "errors: ${it}" }
		}

		def criteria = Cliente.createCriteria();
		def records = criteria.list { eq("client_id",client_id ) }
		//Cliente a = records.find{1}
		Cliente a = records.get(0)
		a.saldo=a.saldo+monto
		if (!a.save()) {
			a.errors.each { println "errors: ${it}" }
		}		//Cliente lookup = criteria.list.find { println it.client_id}
		println "Exito"
	}

	def setData(){
		//new Cliente(id:1,client_id: 1,nombre: "juan", apellido: "perez",doc: 12345678 ).save()
		//new Cliente(id:2,client_id: 2,nombre: "pedro", apellido: "gimenez",doc: 90123456 ).save()
		//new Servicio(service_id: 10,nombre: "energia",descripcion:"energia").save()
		//new Servicio(service_id: 20,nombre: "gas",descripcion:"agua").save()
	}
}
