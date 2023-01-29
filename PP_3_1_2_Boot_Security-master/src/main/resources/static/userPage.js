$(async function () {
    await thisUser();
});

async function thisUser() {
    fetch("http://localhost:8080/api/user")
        .then(res => res.json())
        .then(data => {

            $('#headerUsername').append(data.email);
            const roles = data.roles.map(role => role.role.substring(5).concat(" ")).toString().replaceAll(`,`, ``);
            $('#headerRoles').append(roles);

            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.surname}</td>
                <td>${data.age}</td>
                <td>${data.email}</td>
                <td>${data.username}</td>
                <td>${roles}</td>)`;
            $('#userPanelBody').append(user);
        })
}



