function Hello($scope, $http) {
    $http.get('/getTop20').
        success(function(data) {
            $scope.apps = data;
        });
}