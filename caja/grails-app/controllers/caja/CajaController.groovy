package caja
import myException.InvalidParametersException

class CajaController {
	static scaffold = true
	def beforeInterceptor = [action:this.&auth]
	def cajaService

	def auth(){
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
			return false
		}
	}

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
			flash.message = "Movimiento generado"
		}catch(InvalidParametersException e){
			println e
			flash.message = "Error, parametros invalidos!"
		}catch(NumberFormatException ex){
			println "Exception: debe enviarse un numero entero como client id ${ex}"
			flash.message = "Error al guardar"
		}
		catch(Exception ex){
			ex.printStackTrace()
			flash.message = "Error al guardar"
		}finally{
			redirect(uri:'/')
		}
	}
	def movements(){
		try{
			def clientId=params.client_id
			def values = cajaService.listMovements(clientId)
			[objectArray:values]
		}catch(Exception ex){
			println "Exception:  "+ex
			flash.message = "Error al listar movimientos!"
			redirect(uri:'/')
		}
	}

	def graphBalance(){
		try{
			def clientId=params.client_id
			def balance = cajaService.getBalance(clientId)
			[objectArray:balance]
		}catch(Exception ex){
			println "Exception:  "+ex
			flash.message = "Error trantando de generar la grafica!"
			redirect(uri:'/')
		}
	}
}
