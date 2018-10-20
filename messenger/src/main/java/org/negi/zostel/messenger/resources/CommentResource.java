/**
 * 
 */
package org.negi.zostel.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Jitender
 *
 */
@Path("/")
public class CommentResource {
	
	@GET
	public String test() {
		return "New Sub Resource";
	}
	
	@GET
	@Path("/{commentId}")
	public  String test2(@PathParam("methodId") long methodId,@PathParam("commentId") long commentId) {
		return "New Sub 2 Resource" + commentId + methodId;
	}

}
