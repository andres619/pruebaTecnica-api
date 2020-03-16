package co.com.todo1.store.support.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.todo1.store.domain.exceptions.PruebaTecnicaException;
import co.com.todo1.store.domain.model.TipoMovimiento;
import co.com.todo1.store.domain.service.impl.TipoMovimientoServiceImpl;

@Path("/tipo-movimiento")
public class TipoMovimientoService {

	@Inject
	private TipoMovimientoServiceImpl service;

	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoMovimiento> findAllTiposMovimientos() {
		return service.findAllTipoMovimientos();
	}

	@GET
	@Path("/obtener-por-tipo/{tipo}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoMovimiento obtenerPorTipo(@PathParam("tipo") String tipo)
			throws PruebaTecnicaException {
		return service.obtenerPorTipo(tipo);
	}

}
