package com.leo.component;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.leo.repository.LogJpaRepository;

@Component("requestTimeInterceptor") // por cada petición que se haga entra en
										// esta clase
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	@Qualifier("logJpaRepository")
	private LogJpaRepository logJpaRepository;

	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	// antes de entrar al método de la petición se ejecuta este método
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		LOG.info("parametros: " + request.getAttributeNames().toString());
		return true;
	}

	// Se ejecuta antes de escupir la vista al navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		String username = "";
		String url = request.getRequestURL().toString();
		long startTime = (long) request.getAttribute("startTime");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			username = authentication.getName();
		}
		try {
			logJpaRepository
					.save(new com.leo.entity.Log(new Date(), authentication.getDetails().toString(), username, url));
		} catch (Exception e) {
			LOG.error("\nError -> \nMessage: " + e.getMessage() + "\nCause: " + e.getCause());
		}

		LOG.info("--- URL to: " + request.getRequestURL().toString() + "--- in: "
				+ (System.currentTimeMillis() - startTime) + " ms");
	}
}
