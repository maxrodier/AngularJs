var app = angular.module("app", []);

app.config(function($httpProvider) {
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});

app.controller("Controller", function ($http, $scope) {
	
	top.$$scope = $scope;
	
	var self = this;
	
	this.$onInit = function () {
		$scope.showList = true;
		$scope.entity = { };
		self.getAll();
	}
	
	self.getAll = function() {
		$http.get("/api/pod/").then(function(response) {
			$scope.entityList = response.data;
		});
	}
	
	self.getOne = function(id) {
		$http.get("/api/pod/" + id ).then(function(response) {
			$scope.original = response.data;
			$scope.entity = Object.assign({}, response.data);
		});
	}
	
	self.create = function() {
		$http.post("/api/pod/create", $scope.entity).then(function(response) {
			$scope.showList = true;
			self.getAll();
		});
	}
	
	self.update = function() {
		$http.put("/api/pod/update/" + $scope.original.namePod, $scope.entity).then(function(response) {
			$scope.showList = true;
			self.getAll();
		});
	}
	
	self.remove = function() {
		$http.delete("/api/pod/delete/" + $scope.original.namePod).then(function(response) {
			$scope.showList = true;
			self.getAll();
		});
	}
	
	self.createClick = function() {
		$scope.action = 'Creation';
		$scope.showList = false;
		$scope.edit = true;
		$scope.entity = { };
	}
	
	self.detailsClick = function(id) {
		$scope.action = 'Details';
		$scope.showList = false;
		$scope.edit = false;
		self.getOne(id);
	}
	
	self.updateClick = function(id) {
		$scope.action = 'Update';
		$scope.showList = false;
		$scope.edit = true;
		self.getOne(id);
	}
	
	self.removeClick = function(id) {
		$scope.action = 'Removal';
		$scope.showList = false;
		$scope.edit = false;
		self.getOne(id);
	}
	
	self.cancelClick = function(id) {
		$scope.showList = true;
		self.getAll();
	}
});
