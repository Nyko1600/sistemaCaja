package caja
class CajaController {
	static scaffold = true

	def cajaService
	def index() {
		[clienteInstanceList: Cliente.list()]
	}
	def seleccionarServicio() {
		def criteria = Servicio.createCriteria();
		def records = criteria.list {  }
		[serviceList:records, clinetId:params.client_id]
	}

	def caja(){
		cajaService.addPay(1, 0,100)
		cajaService.addPay(1, 10, -50)
		cajaService.addPay(1, 20, -43)
	}
	def listClientes(){
		def criteria = Cliente.createCriteria();
		def records = criteria.list {  }
		[clientList:records]
	}
}
