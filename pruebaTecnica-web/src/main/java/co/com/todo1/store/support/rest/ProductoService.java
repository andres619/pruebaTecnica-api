package co.com.todo1.store.support.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.todo1.store.app.carga.dto.ResultadoRegistroDTO;
import co.com.todo1.store.domain.exceptions.PruebaTecnicaException;
import co.com.todo1.store.domain.model.Producto;
import co.com.todo1.store.domain.service.impl.ProductoServiceImpl;
import co.com.todo1.store.web.wrappers.MainResponse;
import co.com.todo1.store.web.wrappers.ProductoRequest;
import co.com.todo1.store.web.wrappers.RegistroResponse;

@Path("/producto")
public class ProductoService {

	@Inject
	private ProductoServiceImpl service;

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> findAllProductos() {
		return service.findAllProductos();
	}

	@GET
	@Path("/obtener-productos-referencia/{referencia}")
	@Produces(MediaType.APPLICATION_JSON)
	public Producto obtenerProductoReferencia(
			@PathParam("referencia") String referenciaProducto)
			throws PruebaTecnicaException {
		return service.obtenerProductoPorReferencia(referenciaProducto);
	}

	@POST
	@Path("/almacenar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RegistroResponse almacenarProducto(ProductoRequest request) {
		RegistroResponse response = new RegistroResponse();

		ResultadoRegistroDTO resultadoRegistro = service
				.registrarProducto(request.getProducto());
		MainResponse responseMain = new MainResponse();
		responseMain.setMessage("OK");
		responseMain.setCode(Response.ok().build().getStatus());
		response.setResponse(responseMain);
		response.setResultadoRegistro(resultadoRegistro);

		return response;
	}

}
