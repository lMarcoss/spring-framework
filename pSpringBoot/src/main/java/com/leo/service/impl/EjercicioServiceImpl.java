package com.leo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.leo.service.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService {
	private static Log LOG = LogFactory.getLog(EjercicioServiceImpl.class);

	@Override
	public void getMensajeLog() {
		LOG.info("Welcome to EjercicioService!");
	}

}
