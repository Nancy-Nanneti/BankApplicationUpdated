<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
header{
  display: block;
  padding: 60px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 30px;

}
.button {
  padding: 10px 10px;
  font-size: 20px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

#tick-mark {
	position: relative;
	display: inline-block;
	width: 30px;
	height: 30px;
	margin-right: 0.3em;
	text-align: center;
	color: #999;
}

#tick-mark::before {
	position: absolute;
	left: 0;
	top: 50%;
	height: 50%;
	width: 3px;
	background-color: #336699;
	content: "";
	transform: translateX(10px) rotate(-45deg);
	transform-origin: left bottom;
}

#tick-mark::after {
	position: absolute;
	left: 0;
	bottom: 0;
	height: 3px;
	width: 100%;
	background-color: #336699;
	content: "";
	transform: translateX(10px) rotate(-45deg);
	transform-origin: left bottom;
}
ol li {
  background: #ffe5e5;
  padding: 5px;
    max-width: 800px;
  margin-right: auto;
  margin-left: auto;
    display: flex;
  justify-content: center;

}
ol {
  background: #ff9999;
  padding: 20px;
}
      marquee {
        width: 100%;
        padding: 10px 0;
        background-color: lightblue;
      }

</style>

<body>
<header><h1>Successfully money is transferred</h1>
<div id="tick-mark"></div></header>
	<br>
	<ol>
	<li><h3><a href="transfer"><button class="button">Transfer</button></a></h3></li>
	<li><h3><a href="withdraw"><button class="button">Withdraw</button></a></h3></li>
	<li><h3><a href="Deposit"><button class="button">Deposit</button></a></h3></li>
	<li><button class="button">Logout</button></li>
	</ol>
<footer><marquee><h3>HCL Banking Application</h3>
<h5>Nancy</h5></marquee></footer>

</body>
</html>