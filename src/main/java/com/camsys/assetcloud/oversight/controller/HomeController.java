package com.camsys.assetcloud.oversight.controller;

import java.io.StringWriter;
import java.io.Writer;

import com.camsys.assetcloud.controller.BasePage;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@Path("/")
public class HomeController extends BasePage {
		
	private final SecurityContext sc;
	
	public HomeController(@Context SecurityContext sc) {
		this.sc = sc;
	}
	
	public String getUserName() {
		return sc.getUserPrincipal().getName();
	}
	
	/** 
	 * Called by template, HTML body for this page
	 * @return
	 */
	public String getBody() {
		return "Hi.";
	}
}