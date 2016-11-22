package caja



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def UserService

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

	def index(Integer max) {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}
		params.max = Math.min(max ?: 10, 100)
		respond User.list(params), model:[userInstanceCount: User.count()]
	}

	def show(User userInstance) {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}
		respond userInstance
	}

	def create() {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}
		respond new User(params)
	}

	@Transactional
	def save(User userInstance) {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}

		if (userInstance == null) {
			notFound()
			return
		}

		if (userInstance.hasErrors()) {
			respond userInstance.errors, view:'create'
			return
		}

		userInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'user.label', default: 'User'),
					userInstance.id
				])
				redirect userInstance
			}
			'*' { respond userInstance, [status: CREATED] }
		}
	}

	def edit(User userInstance) {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}

		respond userInstance
	}

	@Transactional
	def update(User userInstance) {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}

		if (userInstance == null) {
			notFound()
			return
		}

		if (userInstance.hasErrors()) {
			respond userInstance.errors, view:'edit'
			return
		}

		userInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'User.label', default: 'User'),
					userInstance.id
				])
				redirect userInstance
			}
			'*'{ respond userInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(User userInstance) {
		if(!session.user){
			flash.message = "Debe inciar session"
			redirect(controller:"User", action:"login")
		}

		if (userInstance == null) {
			notFound()
			return
		}

		userInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'User.label', default: 'User'),
					userInstance.id
				])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'user.label', default: 'User'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
