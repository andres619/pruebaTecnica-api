package co.com.todo1.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.cdi.Eager;

import co.com.todo1.store.domain.model.TipoMovimiento;

@Eager
public interface ITipoMovimientoRepository extends
		JpaRepository<TipoMovimiento, String>,
		JpaSpecificationExecutor<TipoMovimiento> {

	TipoMovimiento findByTipo(String referencia);
}
