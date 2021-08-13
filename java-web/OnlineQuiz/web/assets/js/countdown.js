//When browser load will call counter
window.onload = counter;


function counter() {
    numberOfQuestions = document.getElementById("numberOfQuestions").value;
    timer = numberOfQuestions * 60;
    if (localStorage.getItem("minutes") === null) {
        minutes = parseInt(timer / 60) - 1;
        seconds = parseInt(timer % 60) + 59;
    } else {
        //get minutes and second from localStorage
        minutes = localStorage.getItem("minutes");
        seconds = localStorage.getItem("seconds");
    }
    countDown();
}


function countDown() {
    document.getElementById("minutes").innerHTML = minutes;
    document.getElementById("seconds").innerHTML = seconds;
    setTimeout("countDown()", 1000);
    if (minutes === 0 && seconds === 0)
    {
        // Facilitate submission of articles
        document.getElementById("pageAfter").value = parseInt(numberOfQuestions, 10) + 1;
        document.getElementById("quiz-form").submit();
        // Remove saved time
        localStorage.removeItem("minutes");
        localStorage.removeItem("seconds");
    } else
    {
        seconds--;
        if (seconds === 0 && minutes > 0)
        {
            minutes--;
            seconds = 60;
        }
    }
    //save time for next question
    localStorage.setItem("minutes", minutes);
    localStorage.setItem("seconds", seconds);
}

