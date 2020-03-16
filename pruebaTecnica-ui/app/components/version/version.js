'use strict';

angular.module(
		'pruebaTecnicaApp.version',
		[ 'pruebaTecnicaApp.version.interpolate-filter',
				'pruebaTecnicaApp.version.version-directive' ])

.value('version', '0.1');
