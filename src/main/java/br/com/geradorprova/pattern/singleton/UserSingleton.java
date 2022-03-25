package br.com.geradorprova.pattern.singleton;

import java.util.Objects;

import br.com.geradorprova.model.enumeration.TipoUsuario;

public class UserSingleton {

	private static UserSingleton instance;
	
	private TipoUsuario tipo;
	
	private UserSingleton() {
		
	}
	
	//singleton
	public static UserSingleton getInstance() {
		if(Objects.isNull(instance)) {
			instance = new UserSingleton();
		}
		
		return instance;
	}

	public static void destroyInstance() {
		
		instance = null;
	}
	
	public TipoUsuario getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

}
