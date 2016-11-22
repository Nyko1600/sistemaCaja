package caja
class ClientController {
	static scaffold = true
	def beforeInterceptor = [action:this.&auth]
	
	def auth(){
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
			return false
		}
	}
}
