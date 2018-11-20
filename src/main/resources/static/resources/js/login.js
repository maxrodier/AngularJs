var app = angular.module("app", []);

app.config(function($httpProvider) {
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
})

app.controller("Controller", function ($http, $window, $scope) {
	var self = this;
	self.credentials = { };
	
	self.login = function() {
		$scope.redirect = findParameter('redirect');
		$http.post(
			"/login", 
			$.param({ 
				username: self.credentials.username, 
				password: self.credentials.password 
			}),
        	{ headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).then(function successCallback(response) {
			if($scope.redirect == null)
				$window.location.replace('/');
			else
				$window.location.replace(atob($scope.redirect));
		}, function errorCallback(response) {
			$scope.search = $window.location.pathname + '?error=true';
			if($scope.redirect != null)
				$scope.search = $scope.search + '&redirect=' + $scope.redirect;
			$window.location.replace($scope.search);
		});
	};
	self.error = findParameter("error");
});

function findParameter(parameterName) {
    var result = null, tmp = [];
    location.search .substr(1).split("&").forEach(function (item) {
          tmp = item.split("=");
          if (tmp[0] === parameterName) result = decodeURIComponent(tmp[1]);
        });
    return result;
}
