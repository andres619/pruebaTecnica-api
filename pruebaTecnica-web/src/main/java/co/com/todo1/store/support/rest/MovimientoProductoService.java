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
import co.com.todo1.store.app.dto.MovimientoReferenciaProductoDTO;
import co.com.todo1.store.domain.exceptions.PruebaTecnicaException;
import co.com.todo1.store.domain.model.MovimientoProducto;
import co.com.todo1.store.domain.service.impl.MovimientoProductoServiceImpl;
import co.com.todo1.store.web.wrappers.MainResponse;
import co.com.todo1.store.web.wrappers.MovimientoProductoRequest;
import co.com.todo1.store.web.wrappers.RegistroResponse;

@Path("/movimiento-producto")
public class MovimientoProductoService {

	@Inject
	private MovimientoProductoServiceImpl service;

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovimientoProducto> findAllCedentes() {
		return service.findAllMovimientos();
	}

	@GET
	@Path("/obtener-movimientos-referencia-producto/{referenciaProducto}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MovimientoReferenciaProductoDTO> obtenerProductoReferencia(
			@PathParam("referenciaProducto") String referenciaProducto)
			throws PruebaTecnicaException {
		return service.obtenerMovimientosReferenciaProducto(referenciaProducto);
	}

	@POST
	@Path("/almacenar-movimiento")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RegistroResponse almacenarMovimiento(
			MovimientoProductoRequest request) throws PruebaTecnicaException {
		RegistroResponse response = new RegistroResponse();

		ResultadoRegistroDTO resultadoRegistro = service
				.registrarMovimientoProducto(request.getMovimientoProducto());

		MainResponse responseMain = new MainResponse();
		responseMain.setMessage("OK");
		responseMain.setCode(Response.ok().build().getStatus());

		response.setResponse(responseMain);
		response.setResultadoRegistro(resultadoRegistro);

		return response;
	}

}
