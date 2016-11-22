package caja

import myException.InvalidParametersException
import grails.transaction.Transactional
@Transactional

class CajaService {
	def addPay(String client_id, long pay_id, double monto) throws InvalidParametersException{
		Date fecha = new Date();
		if(client_id==null || pay_id==null || monto==null || !client_id.isNumber() ){
			throw new InvalidParametersException ("parametros invalidos")
		}
		long clientId= Long.parseLong(client_id)
		if(pay_id!=0){
			monto*=-1
		}
		def nuevaCaja = new Caja(client_id:client_id,pay_id:pay_id,monto:monto,created:fecha)
		def criteria = Client.createCriteria()

		Client a = criteria { eq("id",clientId ) }.get(0)
		a.saldo=Math.round((a.saldo+monto) * 100) / 100

		if (!nuevaCaja.save()) {
			nuevaCaja.errors.each { println "errors: ${it}" }
		}
		if (!a.save()) {
			a.errors.each { println "errors: ${it}" }
		}
	}

	def listMovements(String client_id){

		def criteriaCaja = Caja.createCriteria()
		long clientId= Long.parseLong(client_id)
		def listMovements =criteriaCaja.list {   eq("client_id",clientId )   }

		def criteriaCliente = Client.createCriteria()
		Client cliente = criteriaCliente {  eq("id",clientId) }.get(0)

		def criteriaPay = Pay.createCriteria()
		def pagos = criteriaPay.list {
			inList("id",listMovements.pay_id)
		}
		ArrayList<Map> values = new ArrayList<Map>();

		for(Caja movement :listMovements){
			Map data = [:]
			def pago
			if( movement.pay_id!=0){
				pago = pagos.find{it.id==movement.pay_id}
			}
			data.putAt("cliente", cliente.doc)
			data.putAt("pago", movement.pay_id==0? "INFGRSO DE DINERO" : pago.nombre)
			data.putAt("vencimineto", movement.pay_id==0? "-" : pago.fecha)
			data.putAt("descripcion", movement.pay_id==0? "-" : pago.descripcion)
			data.putAt("registro", movement.created)
			data.putAt("monto", movement.monto)
			values.add(data)
		}

		return values
	}
	def setData(){
		//new Cliente(id:1,client_id: 1,nombre: "juan", apellido: "perez",doc: 12345678 ).save()
		//new Cliente(id:2,client_id: 2,nombre: "pedro", apellido: "gimenez",doc: 90123456 ).save()
		//new Servicio(service_id: 10,nombre: "energia",descripcion:"energia").save()
		//new Servicio(service_id: 20,nombre: "gas",descripcion:"agua").save()
	}
}
