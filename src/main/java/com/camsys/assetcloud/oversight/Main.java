package com.camsys.assetcloud.oversight;

import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
	
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:8080/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {    	
    	
    	// create a resource config that scans for JAX-RS resources and providers
        // in com.camsys.assetcloud.inventory package
        final ResourceConfig rc = new ResourceConfig()
        		.packages("com.camsys.assetcloud")
        		.property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/templates")
	    		.register(MustacheMvcFeature.class);
        
        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        HttpServer httpServer =  GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        
    	HttpHandler httpHandler = new CLStaticHttpHandler(Main.class.getClassLoader(), 
    			"src/main/resources/static/", "static/");
    	httpServer.getServerConfiguration().addHttpHandler(httpHandler, "/static");
    	
    	return httpServer;
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started\nHit enter to stop it...", BASE_URI));
    }
}