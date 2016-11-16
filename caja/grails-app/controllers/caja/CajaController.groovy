package caja
class CajaController {
	static scaffold = true

	def cajaService
	def index() {
		
	}
	def home() {
		def algo = cajaService.setData()
	}

	def caja(){
		cajaService.addPay(1, 0,100)
		cajaService.addPay(1, 10, -50)
		cajaService.addPay(1, 20, -43)
	}
}
