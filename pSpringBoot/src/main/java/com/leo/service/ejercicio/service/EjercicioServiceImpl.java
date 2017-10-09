package com.leo.service.ejercicio.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService {
	private static Log LOG = LogFactory.getLog(EjercicioServiceImpl.class);

	@Override
	public void getMensajeLog() {
		LOG.info("Welcome to EjercicioService!");
	}

}
