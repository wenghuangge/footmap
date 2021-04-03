var app=angular.module("myMap",[]);
app.controller("storyCtrl",function ($location,$scope,$http){

    $scope.getStory=function (){
        $http.get("/photo/count").then(function (response){
            $scope.story=response.data.data;
            console.log($scope.story);
        });
    }
    $scope.detail=function (id){
        var hre="/map/article.html?id="+id;
        location.href=hre;
    }


    $scope.getStory();
})