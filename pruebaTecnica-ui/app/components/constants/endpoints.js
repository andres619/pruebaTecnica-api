/**
 * 
 * Endpoints to backend
 * 
 */

angular
		.module('pruebaTecnicaApp.constants.endpoints', [])
		.constant(
				'endpoints',
				{
					'LOGIN' : '/SecurityServicesWeb/rest/security/authenticate',
					'REGISTRAR_PRODUCTO' : '/producto/almacenar',
					'CONSULTAR_PRODUCTO_REFERENCIA' : '/producto/obtener-productos-referencia',
					'CONSULTAR_TODOS_PRODUCTOS' : '/producto/findAll',
					'CONSULTAR_MOVIMIENTO_PRODUCTO_REFERENCIA' : '/movimiento-producto/obtener-movimientos-referencia-producto',
					'CONSULTAR_TIPOS_MOVIMIENTOS' : '/tipo-movimiento/findAll',
					'REGISTRAR_MOVIMIENTO' : '/movimiento-producto/almacenar-movimiento'
				});
