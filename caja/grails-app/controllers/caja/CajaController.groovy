package caja

class CajaController {
	static scaffold = true
	def cajaService

	def listClient(){
		try{
			def criteria = Client.createCriteria();
			def records = criteria.list { }
			[clientList:records]
		}catch(Exception e){
		}
	}

	def selectPay() {
		def criteria = Pay.createCriteria();
		def records = criteria.list {  }
		[payList:records, clientId:params.client_id]
	}

	def moneyIn(){
		[clientId:params.client_id]
	}

	def caja(){
		try{
			String clientId=params.client_id
			long payId=params.pay_id? Long.parseLong(params.pay_id) : 0
			double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
			//println "el cliente es ${clientId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
			cajaService.addPay(clientId, payId, monto)
			redirect(uri:'/')
		}catch(Exception ex){
			println "la esesion es"+ex
			redirect(uri:'/')
		}
	}
	def movements(){
		try{
			def clientId=params.client_id
			def values = cajaService.listMovements(clientId)
			[objectArray:values]
		}catch(NumberFormatException ex){
			println "la esesion es"+ex
			redirect(uri:'/')
		}
	}
}
