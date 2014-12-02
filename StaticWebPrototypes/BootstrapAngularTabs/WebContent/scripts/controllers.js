var customerEvent = "customerEvent";
var addressEvent = "addressEvent";
var servicesEvent = "servicesEvent";

var customerController = function($scope, eventBus){
	eventBus.registerEventPublisher($scope, customerEvent);
	createAddressEventListener(eventBus, $scope);
};

var addressController = function($scope, eventBus){
	eventBus.registerEventPublisher($scope, addressEvent);
	createCustomerEventListener(eventBus, $scope);
};

var servicesController = function($scope, eventBus){
	eventBus.registerEventPublisher($scope, servicesEvent);
	createCustomerEventListener(eventBus, $scope);
};

var summaryController = function($scope, eventBus){
	createCustomerEventListener(eventBus, $scope);
	createServicesEventListener(eventBus, $scope);
	createAddressEventListener(eventBus, $scope);
};

customerController.$inject = ['$scope', 'EventBusImpl'];
addressController.$inject = ['$scope', 'EventBusImpl'];
servicesController.$inject = ['$scope', 'EventBusImpl'];
summaryController.$inject = ['$scope', 'EventBusImpl'];

function createAddressEventListener(eventBus, $scope){
	eventBus.registerEventListener($scope, addressEvent, function(){
		$scope.addressObject = eventBus.message;
	});
}

function createCustomerEventListener(eventBus, $scope){
	eventBus.registerEventListener($scope, customerEvent, function(){
		$scope.customerObject = eventBus.message;
	});
}

function createServicesEventListener(eventBus, $scope){
	eventBus.registerEventListener($scope, servicesEvent, function(){
		$scope.servicesObject = eventBus.message;
	});
}