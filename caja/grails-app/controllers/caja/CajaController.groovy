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
		[clinetId:params.client_id]
	}

	def caja(){
		def clientId=params.clinet_id
		def serviceId =null
		if(params.service_id){
			serviceId=params.service_id
		}
		double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
		//println "el cliente es ${clinetId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
		cajaService.addPay(clientId, serviceId, monto)
		redirect(uri:'/')
	}
}
