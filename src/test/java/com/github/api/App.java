package com.github.api;

import javax.persistence.Index;
import javax.servlet.ServletException;
import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.server.handlers.resource.ResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ServletSessionConfig;

/**
 * Hello world!
 *
 */
public class App {

	private static final int DEFAULT_PORT = 8080;
	private static final String DEFAULT_HOST = "0.0.0.0";

	private final UndertowJaxrsServer server = new UndertowJaxrsServer();

	public App(Integer port, String host) {
		Undertow.Builder serverBuilder = Undertow.builder().addHttpListener(port, host);

		server.start(serverBuilder);
	}

	public DeploymentInfo deployApplication(String appPath, Class<? extends Application> applicationClass) {
		ResteasyDeployment deployment = new ResteasyDeployment();
		deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");
		deployment.setApplicationClass(applicationClass.getName());
		return server.undertowDeployment(deployment, appPath);
	}

	public void deploy(DeploymentInfo deploymentInfo) throws ServletException {
		server.deploy(deploymentInfo);
	}

	public static void startServer() throws ServletException {
		int port = DEFAULT_PORT;
		if (System.getProperty("port") != null) {
			port = Integer.parseInt(System.getProperty("port"));
		}

		String host = DEFAULT_HOST;
		if (System.getProperty("host") != null) {
			host = System.getProperty("host");
		}

		App myServer = new App(port, host);
		ServletSessionConfig sessionConfig = new ServletSessionConfig();
		sessionConfig.setName("JSESSIONID");
		sessionConfig.setSecure(false);
		sessionConfig.setMaxAge(3600);
		sessionConfig.setPath("/");

		ResourceManager manager = new ClassPathResourceManager(App.class.getClassLoader(), Index.class.getPackage());
		DeploymentInfo di = myServer.deployApplication("/api", ServiceRegistry.class)
				.setClassLoader(App.class.getClassLoader()).setContextPath("/")
				.setDeploymentName("Java Application Compiler").setResourceManager(manager)
				.setServletSessionConfig(sessionConfig)
				.addListeners(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));

		myServer.deploy(di);
	}
}
