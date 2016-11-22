package caja

class UserController {
	static scaffold = true

	def login() {}

	def authenticate() {
		def user = User.findByLoginAndPassword(params.login, params.password)
		if(user){
			session.user = user
			flash.message = "Bienvenido ${user.name}!"
			redirect(controller:"caja", action:"listClient")
		}else{
			flash.message = "Usuario y/o contraseña invalidos"
			redirect(action:"login")
		}
	}

	def logout() {
		flash.message = "Session ${session.user.name} cerrada"
		session.user = null
		redirect(action:"login")
	}
}
