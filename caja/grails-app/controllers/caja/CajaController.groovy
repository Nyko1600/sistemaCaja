package caja
class CajaController {
	static scaffold = true

	def cajaService

	def selectService() {
		def criteria = Servicio.createCriteria();
		def records = criteria.list {  }
		[serviceList:records, clinetId:params.client_id]
	}
	def moneyIn(){
		[clinetId:params.client_id]
	}

	def caja(){
		def clinetId=params.clinetId
		def serviceId =null
		if(params.servicioId){
			serviceId=params.servicioId
		}
		double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
		//println "el cliente es ${clinetId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
		cajaService.addPay(clinetId, serviceId,monto)
		redirect(uri:'/')
		
	}
	def listClient(){
		def criteria = Cliente.createCriteria();
		def records = criteria.list {
		}
		[clientList:records]
	}
}
