package br.com.sabrina.api.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import br.com.sabrina.api.model.ProviderModel;


@Path("/provider")
public class ProviderController {
	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/list")
	@Produces("application/json")
	public List<ProviderModel> list() {
		try {
			String query = "SELECT c FROM ProviderModel c ";
			List<ProviderModel> providers = objEM.createQuery(query, ProviderModel.class).getResultList();
			objEM.close();
			return providers;
		} catch(Exception e) {
			throw new WebApplicationException(500);	
		}
	}

	@GET
	@Path("/search/{id}")
	@Produces("application/json")
	public ProviderModel search(@PathParam("id") int id) {
		try {
			ProviderModel provider = objEM.find(ProviderModel.class, id);
			objEM.close();
			return provider;
		} catch(Exception e) {
			throw new WebApplicationException(500);	
		}
	}

	@POST
	@Path("/register")
	@Consumes("application/json")
	public Response register(ProviderModel objProvider) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objProvider);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("Cadastro realizado!").build();
		} catch(Exception e) {
			throw new WebApplicationException(500);	
		}
	}

	@PUT
	@Path("/update")
	@Consumes("application/json")
	public Response update(ProviderModel objProvider) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objProvider);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("Cadastro alterado!").build();
		} catch(Exception e) {
			throw new WebApplicationException(500);	
		}
	}

	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") int id) {
		try {
			ProviderModel objProvider = objEM.find(ProviderModel.class, id);
			objEM.getTransaction().begin();
			objEM.remove(objProvider);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("Cadastro excluido!").build();
		} catch(Exception e) {
			throw new WebApplicationException(500);	
		}
	} 

	//http://www.ricardoluis.com/wp-content/uploads/2015/08/Artigo-DevMedia-Rest.pdf
	//http://localhost:8080/ApiRest/service/provider/list
}

