angular.module('controllers')
    .controller('controllerRegisterSubject', ['$http', '$location', function ($http, $location) {

    }])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/RegisterSubject', {
                templateUrl: 'templates/registerSubject.html',
                controller: 'controllerRegisterSubject',
                controllerAs: 'AC'
            })
    }
    ]);