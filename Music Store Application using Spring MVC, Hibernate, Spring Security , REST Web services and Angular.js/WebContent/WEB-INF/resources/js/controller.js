var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", 
		function($scope, $http){

	
    $scope.refreshCart = function(cartId){
       alert("inside refresh cart"+cartId);
       $http.get('/Project1/rest/cart/' + cartId).success(function (data){
    $scope.cart = data;
    console($scope.cart);
           
           
           
       });
    };

    $scope.clearCart = function(){
    	alert("CLEAR CART");
        $http.del('/Project1/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function(cartId){
    	alert(cartId);
        $scope.cartId = cartId;
        //alert("Cart is  " + $scope.cartId);
        $scope.refreshCart(cartId);
    };
    
    
  
    $scope.addToCart = function(productId){
        $http.put('/Project1/rest/cart/add/'+productId).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(productId){
        $http.put('/Project1/rest/cart/remove/'+productId).success(function(data){
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
    	alert($scope.cart);
    	var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
       
    };
});
