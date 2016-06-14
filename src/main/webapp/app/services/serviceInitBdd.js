angular.module('controllers').factory('InitBddService', ['$http', function ($http) {

    var collaborator1 = {
        personnalIdNumber: "TLE",
        lastName: "Lecomte",
        firstName: "Thomas"
    };
    var collaborator2 = {
        personnalIdNumber: "NKA",
        lastName: "Kalmouni",
        firstName: "Nada"
    };

    return {
        init: function () {
            return $http.post("api/collaborateurs", collaborator1).then(function (data) {
                collaborator1.id = 1;
                if (data.data)console.log("ajout collaborator1", collaborator1);
                return $http.post("api/collaborateurs", collaborator2);
            }).then(function (data) {
                collaborator2.id = 2;
                if (data.data)console.log("ajout collaborator2", collaborator2);
            });
        }
    };
}]);