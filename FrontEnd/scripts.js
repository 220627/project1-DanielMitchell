const url = "http://localhost:3000";
document.getElementById("loginButton").onclick = loginFunction;

async function loginFunction() {
  //gather user credentials here from login box input
  let user = document.getElementById("username").value;
  let pass = document.getElementById("password").value;

  //creating JS object to send login data
  let userCreds = {
    username: user,
    password: pass,
  };

  let response = await fetch(url + "/login", {
    method: "POST",
    body: JSON.stringify(userCreds),
    credentials: "include",
  });

  console.log(response.status);

  //Control flow based on successful login
  if (response.status === 202) {
    let data = await response.json();

    //wipe our login row and welcome the user
    document.getElementById("welcomeHead").innerText = "Welcome ";
    if (user === "Employee") {
      window.location.href = "/employee.html";
    } else if (user == "Manager") {
      window.location.href = "/manager.html";
    }
  } else {
    //the header will change if the login fails
    document.getElementById("welcomeHead").innerText =
      "Login failed! Try Again..";
  }
}

//recommended to have one login page and based on user_role_id, switch pages
//so if user_role_id is equal to "employee", send them to the employee page
//and then the same kind of logic for managers
//have to google how to switch pages form a JS function
