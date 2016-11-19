package caja
class CajaController {
	static scaffold = true

	def cajaService
	def index() {
		def criteria = Cliente.createCriteria();
		def records = criteria.list {  }
		[clientList:records]
	}
	def home() {
		def algo = cajaService.setData()
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
