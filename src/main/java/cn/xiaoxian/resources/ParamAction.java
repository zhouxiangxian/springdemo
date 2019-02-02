package cn.xiaoxian.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("/param")
public class ParamAction {
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public String query(@QueryParam("msg")String msg) {
		return "ECHO:"+msg;
	}
	
	
	@POST
	@Path("/queryForm")
	@Produces(MediaType.TEXT_PLAIN)
	public String queryForm(@FormParam("msg")String msg) {
		return "ECHO:"+msg;
	}

}
