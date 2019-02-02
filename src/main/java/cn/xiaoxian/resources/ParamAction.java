package cn.xiaoxian.resources;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

@Path("/param")
public class ParamAction {
	@GET
	@Path("/query")
	@Produces(MediaType.APPLICATION_JSON)
	public String query(@QueryParam("msg") String msg) {
		return "ECHO:" + msg;
	}

	@POST
	@Path("/queryForm")
	@Produces(MediaType.TEXT_PLAIN)
	public String queryForm(@FormParam("msg") String msg) {
		return "ECHO:" + msg;
	}

	@GET
	@Path("/{pathParam}")
	@Produces(MediaType.TEXT_PLAIN)
	public String echo(@PathParam("pathParam") String msg) {
		return "ECHO:" + msg;
	}
	
	
	@GET
	@Path("/query/{condition}")
	@Produces(MediaType.TEXT_PLAIN)
	public String echo(@PathParam("condition") PathSegment cond) {
		MultivaluedMap<String,String> matrixParameters = cond.getMatrixParameters();
		return "ECHO:" + matrixParameters;
	}
	
	
	
	@GET
	@Path("/{province:.+}/beijing/{dist:\\w+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String show(@PathParam("province") String province,@PathParam("dist")String dist) {
		return "province:" +province+ ",dist:"+dist;
	}
}
