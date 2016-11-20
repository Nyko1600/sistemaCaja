package caja
class CajaController {
	static scaffold = true
	def cajaService

	def listClient(){
		def criteria = Client.createCriteria();
		def records = criteria.list { }
		[clientList:records]
	}

	def selectService() {
		def criteria = Service.createCriteria();
		def records = criteria.list {  }
		[serviceList:records, clientId:params.client_id]
	}

	def moneyIn(){
		println params.client_id
		[clientId:params.client_id]
	}

	def caja(){
		def clientId=params.client_id
		int serviceId=params.service_id? Integer.parseInt(params.service_id) : 0
		double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
		//println "el cliente es ${clientId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
		cajaService.addPay(clientId, serviceId, monto)
		redirect(uri:'/')
	}
}
