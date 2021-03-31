var app=angular.module("myMap",[]);
app.controller("storyCtrl",function ($scope,$http) {
    $scope.getStory=function (){
        $http.get("/photo/map").then(function (response){
            $scope.story=response.data;
            console.log($scope.story);

        });

    };
    $scope.getStory();
})

