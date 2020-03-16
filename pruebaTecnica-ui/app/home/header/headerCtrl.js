'use strict';

angular.module('pruebaTecnicaApp')

.controller('HeaderCtrl', [ '$scope', '$state', function($scope, $state) {

	$scope.changeFocus = function(event, element) {
		return event.keyCode == 13 && focus(element);
	};

	$scope.init = function() {
		$scope.time = new Date();
	};

	$scope.init();
} ]);
