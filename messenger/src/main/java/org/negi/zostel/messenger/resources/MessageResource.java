package org.negi.zostel.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.negi.zostel.messenger.model.Message;
import org.negi.zostel.messenger.resources.beans.MessgaFilterBean;
import org.negi.zostel.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size) {
		if(year >0) {
			return messageService.getAllMessagesForYear(year);
		}
		if(start >= 0 && size >= 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
			return messageService.getAllMessages();
		
	}
	
	@GET
	@Path("/getAllMessages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@BeanParam MessgaFilterBean filterBean) {
		if(filterBean.getYear() >0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() >= 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
			return messageService.getAllMessages();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long Id,@Context UriInfo uriInfo) {
		Message message = messageService.getMessage(Id);
		String uri = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(Long.toString(message.getId())).build().toString();
		message.addLink(uri, "self");
		return message;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(message.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
		//return messageService.addMessage(message);
		
	}
	
	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long Id,Message message) {
		message.setId(Id);
		return messageService.updateMessage(message);
		
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long Id) {
		messageService.removeMessage(Id);
	}
	
	

	@Path("/{messageId}/commemts")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
	

}
