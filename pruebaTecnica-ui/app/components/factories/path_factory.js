angular.module('pruebaTecnicaApp.factories.generators', []).factory(
		'pathsFactory',
		[ function() {

			mode = 'development';

			// configurations
			config = {
				DEFAULT_PATH : '/pruebaTecnica/rest',
				production : {
					DEFAULT_SERVER : '',
					DEFAULT_PORT : ''
				},
				development : {
					DEFAULT_SERVER : 'http://localhost',
					DEFAULT_PORT : '8080'
				}
			};

			return {

				generatePath : function(relativePath) {
					if (mode == 'development') {
						return this.developmentPath(relativePath);
					} else {
						return this.productionPath(relativePath);
					}
				},

				developmentPath : function(relativePath) {
					return config.development.DEFAULT_SERVER + ':'
							+ config.development.DEFAULT_PORT
							+ config.DEFAULT_PATH + relativePath;
				},

				productionPath : function(relativePath) {
					return config.production.DEFAULT_SERVER + ':'
							+ config.production.DEFAULT_PORT
							+ config.DEFAULT_PATH + relativePath;
				}
			}

		} ]);