<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/cssNewClient.css">
        <title>Add Meeting</title>
    </head>
    <body>
        <div class="icon">
            <h1 class="dashboardh1">Add a new meeting</h1>
        </div>
        <div class="nav">
            <ul class="nav">
                <li class="nav"><a href="Dashboard.jsp">Home</a></li>
                <li class="nav"><a href="addClient.html">Add a new client</a></li>
                <li class="nav"><a class="active" href="addMeeting.jsp">Add a new meeting</a></li>
                <li class="nav" style="float:right"><a href="#about">About</a></li>    
                <li class="nav" style="float:right"><a href="register.html">Register</a></li>
            </ul>
        </div>

        <main class="addNewClient">
            <div class="background">
                <div id="screenCenter">
                    <div class = "layer">
                        <h1>Add Meeting</h1>
                        <form action="meetingServlet" method="post">
                            <label for="title">Title</label><br/>
                            <input type="text" id="title" name="title" placeholder="Title" required>
                            <br/><br/>
                            <label for="meetingDate">Date</label><br/>
                            <input type="date" id="meetingDate" name="date" placeholder="Date..." required>
                            <br/><br/>
                            <label for="place">Name place or phone call</label><br/>
                            <input type="text" id="place" name="place" placeholder="Name or phone call..." required>
                            <br/><br/>
                            <label>Select a client</label><br/>
                            <select class="selector" name="clients">
                                <c:forEach items="${clients}" var="item">
                                    <option class="choice" value="${item.getLastName()} ${item.getFirstName()}">${item.getLastName()} ${item.getFirstName()}</option>
                                </c:forEach>
                            </select>
                            <br><br>
                        </form>
                        <label>Select a staff member</label><br/>
                        <select class="selector" name="staff">
                            <c:forEach items="${staff}" var="item">
                                <option class="choice" value="${item.getLastName()} ${item.getFirstName()}">${item.getLastName()} ${item.getFirstName()}</option>
                            </c:forEach>
                        </select>
                        <br><br>
                        </form>
                        <h3>Discussion Topics</h3>
                        <label for="title">Title</label><br/>
                        <input type="text" id="topicTitle" name="topicTitle" placeholder="Title" required>
                        <label for="title">Content</label><br/>
                        <textarea class="comment" name="topicComments" placeholder="Add a comment !" cols="40" rows="5" ></textarea>
                        <br/>
                        <h3>Actions</h3>
                        <label for="titleAction">Title</label><br/>
                        <input type="text" id="title" name="titleAction" placeholder="Title" required>
                        <label for="title">Text</label><br/>
                        <textarea class="comment" name="textAction" placeholder="Add a text !" cols="40" rows="5" ></textarea>
                        <label>Select a staff member</label><br/>
                        <select class="selector" name="staffAction">
                            <c:forEach items="${staff}" var="item">
                                <option class="choice" value="${item.getLastName()} ${item.getFirstName()}">${item.getLastName()} ${item.getFirstName()}</option>
                            </c:forEach>
                        </select>
                        <label for="deadline">Deadline</label><br/>
                        <input type="date" name="deadlineDate" placeholder="Deadline" required>

                        <br/><br/>
                        <input class="button" type="submit">
                        </form>  
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
