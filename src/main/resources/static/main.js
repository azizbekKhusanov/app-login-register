function login() {
    const user = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(response => response.json())
        .then(data => redirectResponse(data))
        .catch(error => {
            console.error('Error :', error);
            alert('Login failed. Please try again.');
        });
}

function register() {

    const data = {
        name: document.getElementById('name').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        prePassword: document.getElementById('prePassword').value
    };

    fetch('http://localhost:8080/api/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => redirectResponse(data))
        .catch(error => {
            console.error('Error:', error);
            alert('Registration failed. Please try again.');
        });
}

function redirectResponse(data) {
    if (data.success) {
        console.log(data.message);
        redirectToHomePage();
    } else {
        console.error('Error: ', data.message);
        if (data.errorDataList) {
            data.errorDataList.forEach(error => {
                console.error('Error :', error.message);
                alert('Error :' + error.message);
                console.error('Status kodi:', error.status);
            });
        }

    }
}

function redirectToHomePage() {
    window.location.href = '../templates/home.html';
}
