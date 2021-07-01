<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="resources/static/js/app.js" /></script>
        <script src="resources/static/js/service/MGL_Task1.service.js"></script>
        <script src="resources/static/js/controller/MGL_Task1.controller.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library Task 1-Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            	
            }
            .marginLeft
            {
            	margin-left: 30px;
            }
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="MGL_Task1_app" class="ng-cloak">
        <nav id="MistLibrary-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
			<img src="resources/static/images/MGLlogo.png" width="90" height="60" alt="">
		</a>
            <a class="nav-item nav-link" href="games">Games</a>
            <a class="nav-item nav-link" href="review">Review</a>
        </nav>
        <br>
        <div class="container" ng-controller="MGL_Task1_Controller as MGL_T1_ctrl">
            <div class="panel panel-default">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="MGL_T1_ctrl.addGame()" name="gameForm" class="form-horizontal">
                        <input type="hidden" ng-model="MGL_T1_ctrl.game.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="name">Name*</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.name" id="name" class="name form-control input-sm" placeholder="Enter the name of the new game [required]" required ng-minlength="3" />
                                    <div class="has-error" ng-show="gameForm.$dirty">
                                        <span ng-show="gameForm.name.$error.required">This is a required field</span>
                                        <span ng-show="gameForm.name.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="gameForm.name.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="genre">Game Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.genre" id="genre" class="form-control input-sm" placeholder="Enter the genre of the new game" />
                                </div>
                            </div>
                        </div>
                       
                        <div class="row">
                            <div class="form-actions floatRight">
                                <input ng-if="!MGL_T1_ctrl.game.id" type="submit" value="Add" class="btn btn-primary btn-sm">
                                <button ng-if="MGL_T1_ctrl.game.id" data-ng-click= "MGL_T1_ctrl.addGame()" class ="btn btn-primary btn-sm"> Update</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
          
                <div class="tablecontainer">
                  <div class="panel-heading text-light"><span class="lead">Search for all current games</span></div>
                <input class= "form-control" id="gameInput" type="text" placeholder="Searching for a game type here....">
                    <table class="table table-dark table-striped text-light" id="gameTable">
                     <div class="panel-heading text-light"><span class="lead">List of all current games</span></div>
                        <thead>
                            <tr class="filters">
                                <th>Game Name</th>
                                <th>Game Genre</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                        <div>
                            <tr ng-repeat="currentGame in MGL_T1_ctrl.games">
                                <td><span ng-bind="currentGame.name"></span></td>|
                                <td><span ng-bind="currentGame.genre"></span></td>
                              </div> 
                                
                                <td width="30%"> 
                                <button class="btn btn-info" id={{currentGame}} ng-click= "MGL_T1_ctrl.updateGame(currentGame)"> Update</button>
                                <button class=" btn btn-info marginLeft"id={{currentGame}} ng-click= "MGL_T1_ctrl.deleteAGame(currentGame)">Delete</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript">
    const showingGame = name =>
    {
    	const updatedGame = JSON.stringify(name);
    	console.log(updatedGame);
    	
    } 
    </script>
    <script type="text/javascript">
    $(document).ready(function(){
    
    	$("#gameInput").on("keyup", function(){
    	
    		const valuatingvaluatingVals = $(this).val().toLowerCase();
    		$("#gameTable tr").filter(function(){
    		
    			$(this).toggle($(this).text().toLowerCase().indexOf(valuatingVals) > -1);
    		});
    	});
    });
   
    </script>
    </html>