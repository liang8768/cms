<!DOCTYPE>  
<html>  
  <head>      
    <title>My JSP 'index.jsp' starting page</title>  
 <meta http-equiv="pragma" content="no-cache">  
 <meta http-equiv="cache-control" content="no-cache">  
 <meta http-equiv="expires" content="0">      
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
 <meta http-equiv="description" content="This is my page">  
  </head>  
  <body>  
   <#assign upper = "com.liang.UpperDirective"?new()>
   <@upper count=1>
   		liangliangliangliang
   </@upper>
   
   ${liang?replace('亮亮','颖娟')}
   <@compress/>
   
   ${static['com.liang.Test2'].test()}
  </body>  
</html>  