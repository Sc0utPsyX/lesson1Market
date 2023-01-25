angular.module('market', []).controller('indexController', function ($scope, $http) {
    const contextPathProducts = 'http://localhost:8189/market/api/v1/products'
    const contextPathCart = 'http://localhost:8189/market/api/v1/cart'

    $scope.fillTable = function () {
        $http.get(contextPathProducts)
            .then(function (response) {
                $scope.products = response.data;
                // console.log(response);
            });
    };

    $scope.deleteProduct = function (id) {
        $http.delete(contextPathProducts + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post(contextPathProducts, $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }

    $scope.loadCart = function () {
        $http.get(contextPathCart)
            .then(function (response) {
                $scope.cart = response.data;
            });
    }

    $scope.addProductToCart = function (id) {
        $http.get(contextPathCart + '/' + id)
            .then(function (response) {
                $scope.loadCart();
            });
    }

    $scope.fillTable();
    $scope.loadCart();
});