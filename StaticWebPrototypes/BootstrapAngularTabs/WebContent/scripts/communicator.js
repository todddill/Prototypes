var communicator = angular.module('communicator', []);

communicator.factory('EventBusImpl', function($rootScope){
	var eventBus = {};
	
	eventBus.message = [];
	
	eventBus.sendBroadcast = function(publisher, payload)
	{
		this.message = payload;
		this.broadcastMessage(publisher);
	};
	
	eventBus.broadcastMessage = function(publisher){
		$rootScope.$broadcast(publisher);
	};
	
	eventBus.registerEventListener = function($scope, eventHandler, fn){
		$scope.$on(eventHandler, fn);
	}
	
	eventBus.registerEventPublisher = function($scope, eventHandler){
		$scope.handleEvent = function(payload){
			eventBus.sendBroadcast(eventHandler, payload);
		};
	}
	
	return eventBus;
});