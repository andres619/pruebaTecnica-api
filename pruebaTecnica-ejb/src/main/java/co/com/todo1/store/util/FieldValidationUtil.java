package co.com.todo1.store.util;

public abstract class FieldValidationUtil {

	private FieldValidationUtil() {

	}

	public static final String ERROR_PRODUCTO_SIN_STOCK = "El producto no tiene stock disponible";
	public static final String ERROR_STOCK_SIN_CANTIDAD_SUFICIENTES = "No hay cantidad suficientes para la salida";
	public static final String ERROR_REFERENCIA_DUPLICADA = "El producto con la referencia ya se encuentra registrado";

}
