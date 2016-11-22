package caja

class User {
  String login
  String password
  String name
  	
	static constraints = {
		login(unique:true)
		password(password:true)
	}
	String toString(){
		name
	}
}
