console.log("Enter to GetRequest");
document.addEventListener("DOMContentLoaded", function() {

    const usersTable = document.getElementById("users");
    const usersList = [];

    function loadUsersList() {
        console.log("Enter to loadUsersList");
        fetch("/OpenHelp-Web/users?action=getAll")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Network response was not ok: ${response.status} - ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log("data : ", data);
                if (Array.isArray(data)){
                data.forEach(users =>{
                    usersList.push(users);
                    usersTable.innerHTML += `
            <tr>
              <td>${users.username}</td>
              <td>${users.password}</td>
              <td>${users.email}</td>
              <td>${users.name}</td>
            </tr>
          `
                });
                } else {
                    console.error("Invalid data format:", data);
                }
            })
    .catch(error => console.error("Error fetching data: ", error));
    }
    loadUsersList();
});