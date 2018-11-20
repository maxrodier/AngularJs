var app = angular.module("app", []);

app.config(function($httpProvider) {
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});

app.controller("Controller", function ($http, $scope) {
	var self = this;

	this.$onInit = function () {
		self.refresh();
	}
	
	self.refresh = function() {
		self.authenticated = false;
		$http.get("/secured").then(function(response) {
			self.secured = response.data;
		});
	};
});
