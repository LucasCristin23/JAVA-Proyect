function validateForm(event) {
    
    event.preventDefault()
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var error = document.getElementById("error");

    if (email === "" || password === "") {
        
        error.style.display = "block";
        return false;
    } else {
        error.style.display = "none";
        redirigir();
        return true;
    }
  
}

function redirigir()
{
    var meta = document.querySelector("#redirect");
    meta.setAttribute("http-equiv", "refresh");
    meta.setAttribute("content","2;url=./apiConexiones.html");
}