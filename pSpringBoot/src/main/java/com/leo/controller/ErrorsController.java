package com.leo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice indica que Spring debe venir a este controlador cuando se produce un error
@ControllerAdvice
public class ErrorsController {
	private static String ISE_VIEW = "error/500";// encuentra la página
													// error.html en la carpeta
													// error

	@ExceptionHandler(Exception.class) // Indica el error a capturar
	public String showInternalServerError() {
		return ISE_VIEW;
	}
}
