package com.leo.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	// por cada petición que se haga entra en esta clase

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	// antes de entrar al método de la petición se ejecuta este método
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	// Se ejecuta antes de escupir la vista al navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("--- Request URL: " + request.getRequestURL().toString() + "--- Total time: "
				+ (System.currentTimeMillis() - startTime) + " ms");
	}
}
