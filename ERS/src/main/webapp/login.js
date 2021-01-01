async function loginSubmit(e){
    e.preventDefault();

    let username = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    //enhanced object literals
    const credentials = {
        username,
        password
    }

    try{
        let res = await fetch("http://localhost:8080/ERS/login",{
            method:"POST",
            redirect: "follow",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })
        let user = await res.json()
        console.log(user);
        console.log(user.tpe);
        if(user.tpe === "employee"){
            sessionStorage.setItem('userId', user.userId);
            console.log(`this is sessionStorage: ${sessionStorage.getItem('userId')}`);
            window.location = "./employee/employeeMain.html"
        }else if(user.tpe === "manager"){
            sessionStorage.setItem('userId', user.userId);
            window.location = "./manager/managerMain.html"
        }
    } catch(e) {
        console.log(e);
    }
}
document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)



