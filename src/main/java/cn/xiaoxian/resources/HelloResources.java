package cn.xiaoxian.resources;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
@Path("/hello")
public class HelloResources {
	@Context
	private Request request;
	@Context
	private UriInfo uriInfo;
	@Context
	private ServletContext context;
	
	
	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String info() {
		System.out.println("******request********"+this.request.getMethod());
		System.out.println("********uriInfo************"+this.uriInfo.getPath());
		System.out.println("*********context************"+this.context.getRealPath("/"));
		return "www.xiaoxian.com";
	}

}
