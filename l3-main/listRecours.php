
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--use bootstrap-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="shortcut icon" href="img/index.png" type="image/x-icon">
    <title>Recours list</title>
</head>
<body  class="fst-italic" data-bs-theme="dark">
<!--navigation bar-->
    <nav class="navbar navbar-expand-lg bg-body-tertiary"style="z-index:5">
    <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="img/index.png" width="50" height="50"></a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
<!--link to Home-->
<a href="index.php" class="nav-link" aria-current="page">Home</a>   
            </li>
<!--link to AddStudent page-->
            <a href="AddStudent.php" class="nav-link" aria-current="page">Add Student</a>   
            </li>
<!-- link to search student page  -->
            <li class="nav-item"><a href="searchStudent.php" class="nav-link" aria-current="page">Search Student</a>   
            </li>
<!--link to Studentlist page-->
            <li class="nav-item"><a href="listStudents.php" class="nav-link">Students List</a></li>          
<!--link to Recourselist-->
            <a href="listRecours.php" class="nav-link active" aria-current="page">Recourse List</a>   
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
    <?php  
require 'class.php';
$std = new StudentRecours();
 if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['add'])) {
    $id = isset($_POST['id']) ? $_POST['id'] : '';
    $status = $_POST['status'];
    $std->status($status, $id);
}

?> 
    <div class="container">
        <div class="row">
           <div class="col">
            <div class="card mt-5">
                <div class="card-header">
                    <h2 class="display-6 text-center">Recourse list </h2>
                </div>
            <div class="card-body">
            <table class="table table-border text-center">
                        <tr class="bg-dark text-white">
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Group</td>
                            <td>Module</td>
                            <td>Nature</td>
                            <td>Note Displayed</td>
                            <td>Reel Note</td>
                            <td>Status</td>
                            <td></td>
                        </tr>
                        <tbody>
                         <?php
                        $data = $std->getRecourses();
                        foreach ($data as $val) {
                        echo "
                            <tr>
                            <td>$val[nom]</td>
                            <td>$val[prenom]</td>
                            <td>$val[groupe]</td>
                            <td>$val[module]</td>
                            <td>$val[nature]</td>
                            <td>$val[note_affiche]</td>
                            <td>$val[note_reel]</td>
                            <td>";?>
                        <form method='post' action='listRecours.php'>
                            <select class="form-select" aria-label="Default select example" name="status">
                               <option value="favorable">favorable</option>
                               <option value="unfavorable">unfavorable</option>
                            </select></td>
                           <?php echo "<input type='hidden' name='id' value='$val[id]'>"?>
                            <td>
                                <button class="btn btn-success" type="submit" name="add">Save</button>
                            </td>
                        
                         </form></tr>
                        <?php 
                        }
                        ?>
                            
                        </tbody>
                    </table>
               
                </div>
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