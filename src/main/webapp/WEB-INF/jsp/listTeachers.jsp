<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="teachers" scope="request" type="java.util.List<com.entity.Teacher>"/>
<!doctype html>
<html lang="en">
<head>
    <c:url var="base" value="/" />
    <base href="${base}" />
    <meta charset="UTF-8">
    <title>ListTeachers</title>
</head>
<body>
    <div>
        <table>
            <thead>
                <tr>
                    <th>#            </th>
                    <th><p>"姓名"</p></th>
                    <th><p>"时间戳"</p></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${teachers}" var="uniqueTeacher" varStatus="s">
                    <tr>
                        <td><p>"${s.count}"                 </p></td>
                        <td><p><a href="updateTeacher?tid=${uniqueTeacher.id}">"${uniqueTeacher.name}"</a></p></td>
                        <td><p>"${uniqueTeacher.insertTime}"</p></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>