package co.com.todo1.store.web.wrappers;

import java.io.Serializable;

import co.com.todo1.store.domain.dto.ProductoDTO;

public class ProductoRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private ProductoDTO producto;

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ProductoRequest [producto=" + producto + "]";
	}

}
