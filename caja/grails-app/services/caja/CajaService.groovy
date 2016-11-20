package caja

import grails.transaction.Transactional

@Transactional
class CajaService {
	def addPay(String client_id, String service_id=null, double monto){
		Date fecha = new Date();
		long clientId= Long.parseLong(client_id)
		if(service_id!=null){
			monto*=-1
		}
		def nuevaCaja = new Caja(client_id:client_id,service_id:service_id,monto:monto,created:fecha)
		if (!nuevaCaja.save()) {
			nuevaCaja.errors.each { println "errors: ${it}" }
		}
		def criteria = Client.createCriteria()
		Client a = criteria { eq("id",clientId ) }.get(0)
		a.saldo=Math.round((a.saldo+monto) * 100) / 100
		if (!a.save()) {
			a.errors.each { println "errors: ${it}" }
		}
	}

	def setData(){
		//new Cliente(id:1,client_id: 1,nombre: "juan", apellido: "perez",doc: 12345678 ).save()
		//new Cliente(id:2,client_id: 2,nombre: "pedro", apellido: "gimenez",doc: 90123456 ).save()
		//new Servicio(service_id: 10,nombre: "energia",descripcion:"energia").save()
		//new Servicio(service_id: 20,nombre: "gas",descripcion:"agua").save()
	}
}
