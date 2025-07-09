<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="teacher" scope="request" type="com.entity.Teacher"/>
<jsp:useBean id="titles" scope="request" type="java.util.List<com.entity.Title>"/>
<jsp:useBean id="courses" scope="request" type="java.util.List<com.entity.Course>"/>
<!doctype html>
<html lang="en">
<head>
    <c:url var="base" value="/" />
    <base href="${base}" />
    <meta charset="UTF-8">
    <title>getTeacher</title>
</head>
<body>
<form action="updateTeacher" method="post">
    <input type="hidden" name="tid" value="${teacher.id}" />
    <label>
        姓名：<input type="text" name="name" value="${teacher.name}">
    </label><br>
    职称：
    <select name="titleId" id="">
        <c:forEach items="${titles}" var="uniqueTitle">
            <c:set var="sel" value=""/>
            <c:if test="${uniqueTitle.id == teacher.title.id}">
                <c:set var="sel" value="selected"/>
            </c:if>
            <option value="${uniqueTitle.id} ${sel}" selected>${uniqueTitle.name}</option>
        </c:forEach>
    </select>
    <br>
    授课：<br>
    <c:forEach items="${courses}" var="uniqueCourse">
        <c:set var="ch" value=""/>
        <c:forEach items="${teacher.courses}" var="teacherCourse">
            <c:if test="${uniqueCourse.id == teacherCourse.id}">
                <c:set var="ch" value="checked"/>
            </c:if>
        </c:forEach>
        <label>
            <input type="checkbox" ${ch} name="courseId">
            ${uniqueCourse.name}<br>
        </label>
    </c:forEach>
    <br>
    <button type="submit">提交修改</button>
</form>
</body>
</html>