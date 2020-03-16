package co.com.todo1.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.cdi.Eager;

import co.com.todo1.store.domain.model.Producto;

@Eager
public interface IProductoRepository extends JpaRepository<Producto, String>,
		JpaSpecificationExecutor<Producto> {

	Producto findByReferencia(String referencia);
}
