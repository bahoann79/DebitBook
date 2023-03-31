$(document).ready(function () {
    $("#verifyEmailForm").validate({
        rules: {
            code: {
                required: true
            }
        },

        messages: {
            code: {
                required: "Code cannot empty !"
            }
        },

        errorPlacement: function (error, element) {
            if (element.attr("name") === "code") {
                error.appendTo("#code-error");
            } else {
                error.insertAfter(element);
            }
        }
    });
    $(document).on("click", "#active-btn", function () {
        $("#verifyEmailForm").valid();
    });
});
