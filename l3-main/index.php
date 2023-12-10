<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--use bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="shortcut icon" href="img/index.png" type="image/x-icon">
    <title>Home</title>
</head>
<body class="fst-italic" data-bs-theme="dark">
<!--navigation bar-->
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="z-index:5">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="img/index.png" width="50" height="50"></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
<!--link to Home-->
            <a href="index.php" class="nav-link active" aria-current="page">Home</a>   
            </li>

        </ul>
        </div>
    <div class="form-check form-switch me-2">
        <input type="checkbox" class="form-check-input p-2"
        id="flexSwitchCheckChecked" checked onclick="switchModes()">
        <p>Dark</p></div>
    </div>
    </nav>
<!--Home Code-->
<div class="row position-absolute top-50 start-50 translate-middle " id="id1">
    <div class="col-sm-6 mb-3 mb-sm-0 ">
        <div class="card">
            <img src="img/student.png" class="card-img-top">
        <div class="card-body text-center">
            <h5 class="card-title">Are you a Student?</h5>
            <a href="student.php" class="btn btn-primary">Go</a>
        </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="card">
            <img src="img/manager.png" class="card-img-top" alt="...">
        <div class="card-body text-center">
            <h5 class="card-title">Are you the responsible?</h5>
            <a href="responsible.php" class="btn btn-primary">Go</a>
        </div>
        </div>
    </div>
    </div>
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