package caja
class PayController {
	static scaffold = true
	def loadData(){
		new Pay(nombre:"MONOTRIBUTO ",fecha:"20 C/MES TODOS LOS CUIT",descripcion:"sin comentario",id:1).save()
		new Pay(nombre:"AUTONOMOS",fecha:"10 C/MES TODOS LOS CUIT",descripcion:"sin comentario",id:2).save()
		new Pay(nombre:"INGRESOS BRUTOS",fecha:"13 AL 16 SEGÚN CUIT",descripcion:"0-1-2 VTO / 13 3-4-5 VTO 14  / 6-7 VTO 15 / 8 -9 VTO 16",id:3).save()
		new Pay(nombre:"I.V.A.",fecha:"18 AL 22 C/MES",descripcion:"0 1 / 2 3 / 4 5 / 6 7 / 8 9 VTO 22",id:4).save()
		new Pay(nombre:"ANTICIPO GANANCIAS",fecha:"13/06 - 13/08- 13/10 - 13/12 - 13/02 AÑO PROXIMO",descripcion:"SON CINCO ANTICIPOS EN EL AÑO ",id:5).save()
		new Pay(nombre:"ANTICIPO BIENES PERSONALES",fecha:"IDEM GANANCIAS ",descripcion:"sin comentario",id:6).save()
		new Pay(nombre:"FORMULARIO 931 AFIP",fecha:"07 A 11 DE CADA MES ",descripcion:"0 1 / 2 3 / 4 5 / 6 7 / 8 9 VTO 11",id:7).save()
		new Pay(nombre:"SINDICATO",fecha:"VTO 15 CADA MES ",descripcion:"sin comentario",id:8).save()
	}
}
