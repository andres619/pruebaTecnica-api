angular.module('pruebaTecnicaApp')

.directive('alertasDirective', [ function() {
	return {
		restrict : 'E',
		templateUrl : 'directives/Alertas/alertas.html',
		require : '^alertas',
		scope : {
			alertas : '='
		},
		controller : 'AlertasController'
	}
} ]);
