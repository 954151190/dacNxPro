<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>河北大厂农村商业银行股份有限公司</title>
<meta name="keywords" content="河北大厂农村商业银行股份有限公司" />
<meta name="description" content="河北大厂农村商业银行股份有限公司" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/webskys.js"></script>
<script type="text/javascript" src="js/ie6png.js"></script>
<script type="text/javascript" src="js/gun.js"></script>
</head>
<body>
	<div class="top">
		<div class="topright">
			<ul>
				<li class="li01"><a href='toIndex'>首页</a></li>
				<li class="li02"><a href='javascript:void();'
					onClick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.mycodes.net');"
					rel="nofollow">设为首页</a></li>
				<li class="li03"><a
					onclick="window.external.addFavorite(location.href,document.title)"
					href="javascript:void();" rel="nofollow">加入收藏</a></li>
			</ul>
		</div>
		<div class="logo">
			<a href="toIndex" title="-河北大厂农村商业银行股份有限公司"><img
				src="images/logo.png" width="502" height="71" alt="河北大厂农村商业银行股份有限公司" /></a>
		</div>
		<div class="righttel">
			<img src="images/tel.png" width="200" height="30" alt="前端设计联系电话" />
		</div>
		<div class="webnav">
			<ul>
				<li><a href="toIndex" title="网站首页">网站首页</a></li>
				<li><a href=toAricleList?articleType=BL&page.number=1&page.count=15" title="公示公告">公示公告</a></li>
				<li class="licur"><a href="toAricleList?articleType=NL&page.number=1&page.count=15" title="农信要闻">农信要闻</a></li>
				<li><a href="toAricleList?articleType=PL&page.number=1&page.count=15" title="产品展示">产品展示</a></li>
				<li><a href="toAricleList?articleType=SL&page.number=1&page.count=15" title="业务介绍">业务介绍</a></li>
				<!-- 
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				<li><a href="#" title="其他模块">其他模块</a></li>
				 -->
			</ul>
		</div>
	</div>
	<div class="banner">
		<div id="banlbar"></div>
		<div id="banrbar"></div>
		<div id="banh">
			<ul>
				<s:iterator value="photoList" var="photos">
					<li><img src="showPhoto?photoType=0&photo.id=${ photos.id }" /></li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<div class="index_con">
		<div class="page_left">
			<h2 class="left_title">农信要闻</h2>
			<div class="leftbg borl_r">
				<ul class="classul">
					<li><a href="#">农信要闻系列</a></li>
				</ul>
			</div>
			<div class="left_bot"></div>
		</div>
		<div class="page_right">
			<div class="pagetop">
				<span class="web_navi">当前位置：<a href="#">首页</a> &gt;&gt; 农信要闻</span>
				<h2>
					<a href="#">农信要闻</a>
				</h2>
			</div>
			<div class="borl_r singpage">
				<ul class="newslist">
					<s:iterator value="newsList" var="os">
					<li><a href="toAricle?articleType=NL&news.id=${ os.id }" target="_blank">${ os.title }</a><span>${ os.create_time }</span></li>
					</s:iterator>
				</ul>
				<div class="epages">
					<b class="totle">共${ page.allCount }条记录 当前显示第&nbsp;${ page.number }&nbsp;页 总&nbsp;${ page.allPage }&nbsp;页</b>
					<a href="javascript:goLastPage();">首页</a>
					<a href="javascript:pageLast();">上一页</a>
					<b>${page.number }</b>
					<a href="javascript:pageNext();">下一页</a>
					<a href="javascript:goNextPage();">尾页</a>
					<input type="text" id="pageNumber" value="${ page.number }" style="width: 31px;height: 25px;border: 2px solid #000000; margin-left: 2px;  margin-right: 2px;"/>
					<a href="javascript:pageGo();">跳转</a>
				</div>
			</div>
			<div class="page_bot"></div>
		</div>
		<div class="clear"></div>
		<div class="blank10"></div>
	</div>
	<div class="bottom">
		<div class="patecopy">
			<p>
				Powered by <strong>河北大厂农村商业银行股份有限公司</strong> &copy; 2011-2015 All Right
				Reserved.
			</p>
			<p>
				<a href="#" target="_blank">浙ICP备11005891号</a>
			</p>
		</div>
	</div>
</body>
<script>
	var number = "<s:property value='%{page.number}'/>";
	var count = "<s:property value='%{page.count}'/>";
	var allPage = "<s:property value='%{page.allPage}'/>";
	
	function pageGo() {
		var goNumber = document.getElementById("pageNumber").value;
		goNumber = parseInt(goNumber);
		if( isNaN(goNumber) ||  goNumber <= 0 || goNumber > allPage ) {
			alert("请输入有效页码")
		}else{
			window.location.href="toAricleList?articleType=NL&page.number="+goNumber+"&page.count="+count+"";			
		}
	}

	function pageLast() {
		var goNumber = parseInt( number ) - parseInt(1);
		if( goNumber > 0 ) {
			window.location.href="toAricleList?articleType=NL&page.number="+ goNumber +"&page.count="+count+"";
		}else{
			alert("没有了，已经是第一页了。");
		}
	}
	
	function pageNext() {
		var goNumber = parseInt(number)+parseInt(1);
		if( goNumber <= allPage) {
			window.location.href="toAricleList?articleType=NL&page.number="+ goNumber +"&page.count="+count+"";
		}else{
			alert("没有了，已经是最有一页了。");
		}
	}
	
	function goLastPage() {
		window.location.href="toAricleList?articleType=NL&page.number=1&page.count="+count+"";
	}
	
	function goNextPage() {
		window.location.href="toAricleList?articleType=NL&page.number="+allPage+"&page.count="+count+"";
	}
</script>
</html>
