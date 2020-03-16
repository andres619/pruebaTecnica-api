'use strict';

angular.module('pruebaTecnicaApp')

.factory('AlertService', [ function() {
	var alerts = [], service = {
		get : get,
		size : size,
		clear : clear,
		close : closeElement,
		info : info,
		warning : warning,
		error : error,
		success : success
	};

	function get() {
		return alerts;
	}

	function size() {
		return alerts.length;
	}

	function add(type, message) {
		return alerts.push({
			type : type,
			message : message,
			close : function() {
				return close(this);
			}
		});
	}

	function clear() {
		alerts.length = 0;
	}

	function close(alert) {
		return closeElement(alerts.indexOf(alert));
	}

	function closeElement(index) {
		alerts.splice(index, 1);
	}

	function info(message) {
		alerts.length = 0;
		return add('info', message);
	}

	function warning(message) {
		alerts.length = 0;
		return add('warning', message);
	}

	function error(message) {
		alerts.length = 0;
		return add('danger', message);
	}

	function success(message) {
		alerts.length = 0;
		return add('success', message);
	}

	return service;
} ]);
