function newUser() {
    var userTable = document.getElementById("userDropdown");
    userTable.style.visibility = "visible";
    var rows = userTable.getElementsByTagName("tr").length;
    
    var newRow = userTable.insertRow(rows-1);
    var name, pswd, email;
    name = prompt("Username: ");
    pswd = prompt("Password: ");
    email = prompt("Email: ");

    newRow.insertCell(0).innerHTML = name;
    newRow.insertCell(1).innerHTML = pswd;
    newRow.insertCell(2).innerHTML = email;
}