package restAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/example")
public class Example {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "hello rest";
	}
	
	// post mapping 테스트는 postman에서 실시한다. 쿼리 스트링으로 전달할 수 없기 때문에.
	@POST
	public String sayHello(@QueryParam("msg") String msg) {
		return "hello " + msg;
	}
}
