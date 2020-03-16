package co.com.todo1.store.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.cdi.Eager;

import co.com.todo1.store.domain.model.MovimientoProducto;

@Eager
public interface IMovimientoProductoRepository extends
		JpaRepository<MovimientoProducto, String>,
		JpaSpecificationExecutor<MovimientoProducto> {

	List<MovimientoProducto> findByProducto_Referencia(String referencia);
}
