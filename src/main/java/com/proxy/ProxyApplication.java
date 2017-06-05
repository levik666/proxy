package com.proxy;

import org.littleshoot.proxy.impl.DefaultHttpProxyServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ProxyApplication.class);

	public static void main(String[] args) {
        final String portValue = getProperties("server.port");
        if (portValue == null) {
            System.out.println("Application is failed to started server.port don't exist");
            return ;
        }

        int port = Integer.parseInt(portValue);
        System.out.println("Application is started server.port : " + port);
        DefaultHttpProxyServer.bootstrap().withPort(port).start();
	}

	private static String getProperties(String key) {
        String value = System.getProperty(key);
        if (value != null) {
            return value;
        }

        return System.getProperty(key);
    }
}
