package caja
import org.codehaus.jettison.json.JSONArray
import org.codehaus.jettison.json.JSONObject

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
		String clientId=params.client_id
		long payId=params.pay_id? Long.parseLong(params.pay_id) : 0
		double monto=(Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100)
		//println "el cliente es ${clientId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
		cajaService.addPay(clientId, payId, monto)
		redirect(uri:'/')
	}
	def movements(){
		def clientId=params.client_id
		JSONArray values = new JSONArray();
		values = cajaService.listMovements(clientId)
		[jsonArray:values]
	}
}
