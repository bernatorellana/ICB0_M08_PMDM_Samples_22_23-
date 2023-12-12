
    function onClick(){
        var contactes = JavaInterface.getContacts();
        document.getElementById("titol").innerHTML=contactes;
    }

    window.onload = function() {
        var btnGo = document.getElementById("btnGo");
        btnGo.addEventListener("click", onClick);
    }