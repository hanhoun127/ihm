<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--use bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="shortcut icon" href="img/index.png" type="image/x-icon">
    <title>Search</title>
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
<!--link to AddStudent page-->
            <li class="nav-item"><a href="AddStudent.php" class="nav-link" aria-current="page">Add Student</a>   
            </li>
<!-- link to search student page  -->
            <li class="nav-item"><a href="searchStudent.php" class="nav-link active" aria-current="page">Search Student</a>   
            </li>
<!--link to Studentlist page-->
            <li class="nav-item"><a href="listStudents.php" class="nav-link">Students List</a></li>          
<!--link to Recourselist-->
            <li class="nav-item"><a href="listRecours.php" class="nav-link" aria-current="page">Recourse List</a>   
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
<div style="position:fixed; top:30%; width:30%" class="position-absolute top-10 start-50 translate-middle">
<!--search icon-->
    <img src="img/search.png" width="90" height="90" style="margin-left:45%" class="mb-2">   
    <p class="fst-italic text-center" style="top:15%;font-size:2em ">Search Students</p>
<!--search student form -->
    <form class="d-flex "  action="searchStudent.php" method="post" style="margin-left:1cm;width:100%" >
        <!--search input-->
            <input type="search" class="form-control" placeholder="enter first-name or last-name or email......." name="student">
        <!--Add button-->
            <button type="submit" class="btn  btn-outline-success" name="search"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
            </svg></button>
    </form>
</div>
<!--search results-->
<div style="margin-top:20%">
    <table class="table">
        <tbody>
            <?php 
                require 'class.php' ;
                $std=new StudentRecours();
                if(isset($_POST['search'])){
                
                    $input= $_POST['student'];
                    $data=$std->searchStudent($input); 
                    foreach($data as $val){
                        echo"<tr>
                        <td style='width:60px'><img style='width:60px' src='img/student.png'></td>
                        <td><label>".'&nbsp'.'&nbsp'."</label>".$val['nom']."</br></td>
                        <td><label>".'&nbsp'.'&nbsp'."</label>".$val['prenom']."</br></td>
                        <td><label>".'&nbsp'.'&nbsp'."</label>".$val['email']."</br></td>
                        <td><label>".'&nbsp'.'&nbsp'."</label>".$val['groupe']."</br></td>
                        <td>"
                    ?>
                        <a href="updateStudent.php?updateid=<?php echo $val['id'] ?>" class="btn btn-success"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                        </svg></a></td>
                        <td><a href="listStudents.php?id=<?php echo $val['id'] ?>" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-x " viewBox="0 0 16 16">
                        <path d="M11 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0M8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4m.256 7a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1z"/>
                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m-.646-4.854.646.647.646-.647a.5.5 0 0 1 .708.708l-.647.646.647.646a.5.5 0 0 1-.708.708l-.646-.647-.646.647a.5.5 0 0 1-.708-.708l.647-.646-.647-.646a.5.5 0 0 1 .708-.708"/>
                        </svg></a>
                        </td>
                        </tr>
                   <?php }}
                ?>
        </tbody>
    </table>
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