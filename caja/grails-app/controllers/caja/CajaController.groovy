package caja
class CajaController {
	static scaffold = true

	def cajaService

	def seleccionarServicio() {
		def criteria = Servicio.createCriteria();
		def records = criteria.list {  }
		println params.client_id
		[serviceList:records, clinetId:params.client_id]
	}

	def caja(){
		def clinetId=params.clinetId
		def serviceId=params.serviceId
		double monto=Integer.parseInt(params.entero)+Integer.parseInt(params.decimal)/100
		println "el cliente es ${clinetId}, el servicio es ${serviceId}, el monto ingresado ${monto} "
		
				cajaService.addPay(1, 0,100)
		cajaService.addPay(1, 10, -50)
		cajaService.addPay(1, 20, -43)
	}
	def listClientes(){
		def criteria = Cliente.createCriteria();
		def records = criteria.list {
		}
		[clientList:records]
	}
}
