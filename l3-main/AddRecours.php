<?php 
require 'class.php' ;
$std=new StudentRecours();
if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['add']) ) {
  $m = $_POST['module'];
  $n = $_POST['nature'];
  $na = $_POST['note_affiche'];
  $nr = $_POST['note_reel'];
  $fn = $_POST['firstname'];
  $ln = $_POST['lastname'];
  $gp = $_POST['group'];
  $std->addRecourse($m,$n,$na,$nr,$fn,$ln,$gp);
  }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--use bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="shortcut icon" href="img/index.png" type="image/x-icon">
    <title>Add Recours</title>
</head>
<body  class="fst-italic" data-bs-theme="dark">
<!--navigation bar-->
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="z-index:5">
    <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="img/index.png" width="50" height="50"></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
<!--link to Home-->
            <a href="index.php" class="nav-link" aria-current="page">Home</a>   
            </li>  
<!--link to Add recourse form-->
<li class="nav-item">
                <a class="nav-link active"  href="AddRecours.php">Add Recourse</a>   
            </li>
<!--link to responses of recources-->
             <li class="nav-item">
                <a class="nav-link" id="form2-tab" data-toggle="tab" href="recourseResponses.php">Responses of Recourses</a>
            </li> 
        </ul>
        </div>
    </div>
    <div class="form-check form-switch mx-4">
        <input type="checkbox" class="form-check-input p-2"
        id="flexSwitchCheckChecked" checked onclick="switchModes()">
        <p>Dark</p></div>
    </div>
    </nav>
    <form  class="form-horizontal" method="post">
            <div  style="position:absolute; margin:5%;left:20%;width:50%">
                <div class="form-group " style="margin-left:30%">
                <h2>Add Recourse</h2>
                </div>
                <!--first name label+input-->
                <div class="form-group" style="margin-left:25%">
                    <label class="control-label">First Name</label>
                    <div class="col-sm-8"  >
                    <input type="text" class="form-control" placeholder="enter your first name..." name="firstname" required>
                    </div></div>
            <!--last name label+input-->
                <div class="form-group" style="margin-left:25%">
                    <label class="form-label">last Name</label>
                    <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="enter your last name..." name="lastname" required>
                </div></div>
            <!--group label+input-->
                <div class="form-group" style="margin-left:25%">
                    <label class="form-label">Group</label>
                    <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="enter your Group..." name="group" required>
                </div></div>
                <div class="form-group" style="margin-left:25%">
                    <label class="form-label">Module</label>
                    <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="enter the module..." name="module" required>
                </div></div>
            
                <div class="form-group" style="margin-left:25%">
                    <label class="form-label">Nature</label>
                    <div class="col-sm-8">
                    <select class="form-select" aria-label="Default select example" name="nature">
                    <option value="CC">CC</option>
                    <option value="Examen">Examen</option>
                </select>
                </div></div>
            
                <div class="form-group" style="margin-left:25%">
                    <label class="form-label">Note Displayed</label>
                    <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="enter the Note Displayed..." name="note_affiche" required>
                </div></div>
                
            
                <div class="form-group" style="margin-left:25%">
                    <label class="form-label">Reel Note</label>
                    <div class="col-sm-8">
                    <input type="text" class="form-control" placeholder="enter the Reel Note..." name="note_reel" required>
                </div></div>

                
                
           
                <button type="submit" class="btn btn-success" name="add" style="margin-top:15px;margin-left:25%">Add</button>
                
            </div>
            </form>

<!--switch mode function-->
    <script>
    function switchModes(){
        var element=document.body;
        element.dataset.bsTheme=
        element.dataset.bsTheme == "light" ? "dark" : "light" ;
    }
    </script>
</body>
</html>