package home

import residueGenerator.ResidueGenerator
import user.User

class HomeController {

    def index()
    {
        render(view: "index");
    }

    def login()
    {
//        User user = new User();
//        render(view: "login", model: [user : user]);
    }

    def logar() {
    	 def user = ResidueGenerator.findWhere(cnpj: params['cnpj'], password: params['password']);

    	 if (user) 
    	 		redirect(controller:'dashboard',action:'index');
    	 
    	 else
    	 		redirect(controller:'home',action:'login');	
    	 		flash.message = "CNPJ ou Senha incorretos!";
    	 
    }
}
