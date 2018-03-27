<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css.css" />
    <title>Dashboard</title>
</head>
<body>

    <h1 class="dashboardh1">Welcome: <%= session.getAttribute("user") %></h1>

<main>
<div class="leftside pageitemp">
        <div class="indexdiv">

        <a class="buttonaddmeetingup" href="Client.html">Add meeting</a>

        <div class="flexAccordion">
        <button class="accordion">Meeting 1</button>
        <div class="panel">
            <p>Title</p>
            <p>Date</p>
            <p>Place</p>
            <p>Presents</p>
            <div id="listTopics1">
                <p>Topics</p>
                <p style="font-style: italic">Title</p>
                <p style="font-style: italic">Content</p>
            </div>
            <div id="listActions1">
                <p>Actions</p>
                <p style="font-style: italic">Text</p>
                <p style="font-style: italic">Assignee</p>
                <p style="font-style: italic">Deadline</p>
                <p style="font-style: italic">Comment</p>

            </div>
        </div>


            <script>
                var acc = document.getElementsByClassName("accordion");
                var i;

                for (i = 0; i < acc.length; i++) {
                    acc[i].addEventListener("click", function() {
                        this.classList.toggle("active");
                        var panel = this.nextElementSibling;
                        if (panel.style.maxHeight){
                            panel.style.maxHeight = null;
                        } else {
                            panel.style.maxHeight = panel.scrollHeight + "px";
                        }
                    });
                }
            </script>

            </div>
            <a class="buttonaddmeetingup" href="Client.html">Add meeting</a>
        </div>
    </div>

    <div class="rightside pageitemp">
        <a class="buttonaddclient" href="Client.html">Add client</a>
        <div class="listclient">
            <ul>
                <li>Client1</li>
                <li>Client2</li>
                <li>Client3</li>
                <li>Client4</li>
            </ul>
        </div>
        <a class="buttonaddclient" href="Client.html">Add client</a>
    </div>
</main>
</body>

</html>