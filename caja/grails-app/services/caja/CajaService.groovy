package caja

import grails.transaction.Transactional
import org.codehaus.jettison.json.JSONArray
import org.codehaus.jettison.json.JSONObject
@Transactional
class CajaService {
	def addPay(String client_id, long pay_id, double monto){
		Date fecha = new Date();
		long clientId= Long.parseLong(client_id)
		if(pay_id!=0){
			monto*=-1
		}
		def nuevaCaja = new Caja(client_id:client_id,pay_id:pay_id,monto:monto,created:fecha)
		if (!nuevaCaja.save()) {
			nuevaCaja.errors.each { println "errors: ${it}" }
		}
		def criteria = Client.createCriteria()
		Client a = criteria { eq("id",clientId ) }.get(0)
		a.saldo=Math.round((a.saldo+monto) * 100) / 100
		if (!a.save()) {
			a.errors.each { println "errors: ${it}" }
		}
	}
	def listMovements(String client_id){
		JSONArray values = new JSONArray();
		
		def criteriaCaja = Caja.createCriteria()
		long clientId= Long.parseLong(client_id)
		def listMovements =criteriaCaja.list {  
			eq("client_id",clientId )  
		}
		
		def criteriaCliente = Client.createCriteria()
		Client cliente = criteriaCliente { 
			eq("id",clientId) 
		}.get(0)
		
		def criteriaPay = Pay.createCriteria()
		def pagos = criteriaPay.list { 
			inList("id",listMovements.pay_id) 
		}
				
		for(Caja movement :listMovements){
			JSONObject data = new JSONObject()
			def pago
			if( movement.pay_id!=0){
				pago = pagos.find{it.id==movement.pay_id}
			}
			data.put("cliente", cliente.doc)
			data.put("pago", movement.pay_id==0? "INFGRSO DE DINERO" : pago.nombre) 
			data.put("cierre", movement.pay_id==0? "-" : pago.fecha) 
			data.put("descripcion", movement.pay_id==0? "-" : pago.descripcion) 
			data.put("registro", movement.created)
			data.put("monto", movement.monto)
			values.put(data);
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
