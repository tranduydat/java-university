function checkForm(form) {
    //Questions cannot be left blank
    var tags = document.getElementsByTagName("textarea");
    if (tags[0].value.trim().length === 0) {
        alert("Question cannot empty!");
        form.question.focus();
        return false;
    }

    //Answers cannot be left blank
    for (var i = 1; i <= 4; i++) {
        if (tags[i].value.trim().length === 0) {
            alert("Option cannot empty");
            form.question.focus();
            return false;
        }
    }

    var count = 0;

    if (form.op1.checked) {
        count = count + 1;
    }
    if (form.op2.checked) {
        count = count + 1;
    }
    if (form.op3.checked) {
        count = count + 1;
    }
    if (form.op4.checked) {
        count = count + 1;
    }

    if (count === 0 || count === 4) {
        alert("Number of answers must be in range of (0, 4)");
        form.op1.focus();
        return false;
    }
    return true;


}