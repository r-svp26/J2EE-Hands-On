<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Class Example</title>
</head>
<body bgcolor="#E6E6FA" align="center" margin-top="40px">

	<h2>Scriptlet Example Using Class</h2>

	<%
		class Employee {

			int emp_code;
			float sal;
			float pf;

			Employee(int emp_code, float sal, float pf) {
				this.emp_code = emp_code;
				this.sal = sal;
				this.pf = pf;
			}

			float netSalary() {
				float ns = sal - pf;
				return ns;
			}

		}
	%>

	<h2>Object Creation!!</h2>

	<%
		Employee emp = new Employee(101, 20000, 2500);

		//emp.emp_code=101;
		//emp.sal=20000;
		//emp.pf=2500;

		out.println("Net Salary of Employee:" + emp.netSalary());
	%>
</body>
</html>