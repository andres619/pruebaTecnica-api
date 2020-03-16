'use strict';

angular.module('pruebaTecnicaApp')

.controller('menuCtrl', [ '$scope', function($scope) {

	$scope.modules = [];
	var moduloProductos = {
		"description" : "Productos",
		"options" : [ {
			"config" : "app.home.registrar-producto",
			"description" : "Registrar Producto"
		}, {
			"config" : "app.home.consultar-producto",
			"description" : "Consultar Producto"
		} ]
	}
	$scope.modules.push(moduloProductos);
	var moduloMovimientos = {
		"description" : "Movimiento Producto",
		"options" : [ {
			"config" : "app.home.movimiento-producto",
			"description" : "Registrar Entrada/Salida"
		}, {
			"config" : "app.home.consultar-movimiento",
			"description" : "Consultar Movimientos"
		} ]
	}
	$scope.modules.push(moduloMovimientos);

	$scope.accordion = {
		closeOthers : true
	};

} ]);
