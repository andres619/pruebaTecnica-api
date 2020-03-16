'use strict';

angular.module('pruebaTecnicaApp')

.filter('paging', [ function() {
	return function(input, start) {
		if (input) {
			start = +start;
			if (angular.isArray(input) && input.length > 0) {
				return input.slice(start);
			}
			return input;
		}
		return input;
	};
} ]);
