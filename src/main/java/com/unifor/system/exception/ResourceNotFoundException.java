package com.unifor.system.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(Long id) {
        super(String.format("Não foi possivel encontrar o recurso com o id igual a %s.", id));
    }
}
