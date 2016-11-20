package caja
class CajaController {
	static scaffold = true
	def cajaService

	def listClient(){
		def criteria = Client.createCriteria();
		def records = criteria.list { }
		[clientList:records]
	}

	def selectPay() {
		def criteria = Pay.createCriteria();
		def records = criteria.list {  }
		[payList:records, clientId:params.client_id]
	}

	def moneyIn(){
		println params.client_id
		[clientId:params.client_id]
	}

	def caja(){
		def clientId=params.client_id
		int payId=params.pay_id? Integer.parseInt(params.pay_id) : 0
		double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
		//println "el cliente es ${clientId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
		cajaService.addPay(clientId, payId, monto)
		redirect(uri:'/')
	}
}
