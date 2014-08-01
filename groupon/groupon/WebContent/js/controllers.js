var grouponControl = angular.module('grouponControl', [ 'ui.router' ]);

grouponControl.config([ '$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {

			$urlRouterProvider.otherwise('/form');

			$stateProvider

			.state('form', {
				url : '/form',
				templateUrl : 'form.html',
				controller : 'mainController'
			})

			.state('login', {
				url : '/login',
				templateUrl : 'pages/login.html',
				controller : 'loginController'
			})

			.state('register', {
				url : '/register',
				templateUrl : 'pages/register.html',
				controller : 'registerController'
			})

			.state('create', {
				url : '/create',
				templateUrl : 'pages/createoffer.html',
				controller : 'createController'
			})

			.state('view', {
				url : '/view',
				templateUrl : 'pages/viewoffer.html',
				controller : 'viewController'
			});

		} ]);

grouponControl.controller('mainController', function($scope) {
	$scope.message = 'Homepage';
});

grouponControl.controller('loginController', function($scope,$http,$state) {
	$scope.user = {};
	$scope.checkuser = function(){
		$http({
			method : 'GET',
			url : '/person',
			data : data
		});
	if($scope.user.persontype = "corp")
		$state.go('create');
	else if ($scope.user.persontype = "user")
		$state.go('view');

	};
});

grouponControl.controller('registerController', function($scope,$http,$state) {
	$scope.user = {};
		var data = $scope.user = {};
	    $scope.createuser = function() {
	        $http({
	            method : 'POST',
	            url : '/person',
	            data : data
	        });
	    };

	$scope.changeState = function(){
		$state.go('login');
	}; 
});

grouponControl.controller('createController', function($scope,$http) {
	$scope.offer = {};
	var data = $scope.offer = {};
    $scope.createoffer = function() {
        $http({
            method : 'POST',
            url : '/offer',
            data : data
        });
    };


});

grouponControl.controller('viewController', function($scope,$http) {


});