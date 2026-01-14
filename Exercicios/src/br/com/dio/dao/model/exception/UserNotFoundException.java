package br.com.dio.dao.model.exception;

public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException(final String messsage) {super(messsage);
    }
}
