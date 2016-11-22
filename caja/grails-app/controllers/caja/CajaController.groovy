package caja
import myException.InvalidParametersException

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
		[clientId:params.client_id]
	}

	def caja(){
		try{
			String clientId=params.client_id
			long payId=params.pay_id? Long.parseLong(params.pay_id) : 0
			double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
			//println "el cliente es ${clientId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
			cajaService.addPay(clientId, payId, monto)
		}catch(InvalidParametersException e){
			println e
		}catch(NumberFormatException ex){
			println "Exception: debe enviarse un numero entero como client id ${ex}" 
		}
		catch(Exception ex){
			ex.printStackTrace()
		}finally{
			redirect(uri:'/')
		}
	}
	def movements(){
		try{
			def clientId=params.client_id
			def values = cajaService.listMovements(clientId)
			[objectArray:values]
		}catch(NumberFormatException ex){
			println "Exception:  "+ex
			redirect(uri:'/')
		}
	}
}
