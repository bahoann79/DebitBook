/* Active gender button */
var btnMale = document.querySelector("#input-male");
var btnFemale = document.querySelector("#input-female");

var inputMale = document.querySelector("#male");
var inputFemale = document.querySelector("#female");
btnMale.onclick = () => {
    btnMale.classList.add("active");
    btnFemale.classList.remove("active");
    inputMale.checked = true;
};
btnFemale.onclick = () => {
    btnFemale.classList.add("active");
    btnMale.classList.remove("active");
    inputFemale.checked = true;
};

/* Validate Register Form */
$(document).ready(function () {
    $("#registerForm").validate({
        rules: {
            name: {
                required: true
            },
            email: {
                required: true
            },
            password: {
                required: true
            },
            rePassword: {
                required: true,
                equalTo: "#password"
            },
            phoneNumber: {
                required: true
            },
            address: {
                required: true
            }
        },

        messages: {
            name: {
                required: "Name cannot empty !"
            },
            email: {
                required: "Email cannot empty !"
            },
            password: {
                required: "Password cannot empty !"
            },
            rePassword: {
                required: "Confirm password must equal to password !"
            },
            phoneNumber: {
                required: "Phone Number cannot empty !"
            },
            address: {
                required: "Address cannot empty !"
            }
        },

        errorPlacement: function (error, element) {
            if (element.attr("name") === "name") {
                error.appendTo("#name-error");
            } else if (element.attr("name") === "email") {
                error.appendTo("#email-error");
            } else if (element.attr("name") === "password") {
                error.appendTo("#password-error");
            } else if (element.attr("name") === "rePassword") {
                error.appendTo("#rePassword-error");
            } else if (element.attr("name") === "phoneNumber") {
                error.appendTo("#phoneNumber-error");
            } else if (element.attr("name") === "address") {
                error.appendTo("#address-error");
            } else {
                error.insertAfter(element);
            }
        }
    });
    $(document).on("click", "#register-btn", function () {
        $("#registerForm").valid();
    });
});

