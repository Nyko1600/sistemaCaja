package caja

class User {
  String login
  String password
  String name
	String rol = "user"
  	
	static constraints = {
		login(unique:true)
		password(password:true)
		rol(inList:["user", "admin"])
	}
	String toString(){
		name
	}
}
