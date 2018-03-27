<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/css.css" />
    <title>Dashboard</title>
</head>
<body>

    <h1 class="dashboardh1">Welcome: <%= session.getAttribute("user") %></h1>

<main>
<div class="leftside pageitemp">
        <div class="indexdiv">

        <a class="buttonaddmeetingup" href="addMeeting.jsp">Add meeting</a>
        
        <c:forEach items="${meetings}" var="item">
            <div class="flexAccordion">
                <button class="accordion">${item.getTitle()}</button>
                <div class="panel">
                    <p>${item.getDate()}</p>
                    <p>${item.getPlace()}</p>
                    <div id="listTopics1">
                        <p>Staff</p>
                        <c:forEach items="${item.getStaff()}" var="item">
                            <p style="font-style: italic">${item.getLastName()} ${item.getFirstName()}</p>
                        </c:forEach>
                    </div>
                    <div id="listTopics1">
                        <p>Topics</p>
                        <c:forEach items="${item.getTopics()}" var="item">
                            <p style="font-style: italic">${item.getTitle()}</p>
                            <p style="font-style: italic">${item.getContent()}</p>
                        </c:forEach>
                    </div>
                    <div id="listActions1">
                        <p>Actions</p>
                        <p style="font-style: italic">${item.getAction().getText()}</p>
                        <p style="font-style: italic">${item.getAction().getAssignee()}</p>
                        <p style="font-style: italic">${item.getAction().getDeadline()}</p>
                        <p style="font-style: italic">${item.getAction().getComment()}</p>
                        <p style="font-style: italic">${item.getAction().getActionstatus()}</p>
                    </div>
                </div>
        </c:forEach>

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
            <a class="buttonaddmeetingup" href="addMeeting.jsp">Add meeting</a>
        </div>
    </div>

    <div class="rightside pageitemp">
        <a class="buttonaddclient" href="addClient.html">Add client</a>
        <div class="listclient">
            <ul>
                <li>Client1</li>
                <li>Client2</li>
                <li>Client3</li>
                <li>Client4</li>
            </ul>
        </div>
        <a class="buttonaddclient" href="addClient.html">Add client</a>
    </div>
</main>
</body>

</html>