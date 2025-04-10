<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    	<%-- 이 순간부터 서블릿으로 요청을 보내고 그것을 service DAO DB를 통해 정보를 가져올 것이므로 html자체가 필요 없음--%>
    

<%-- /요청이 오면 /signin이라는 서블릿으로 요청을 위임하겠다--%>


    	<%-- / 라는 요청을 하나 보내면 그것이 signin페이지이며 index.jsp라는 이 jsp 화면이 보여질 것
    	여기서부터 다른 서블릿이 응답할 수 있도록 이미 요청을 다른 곳으로 위임.
    	그 signin자체를 동적으로 그냥 뿌려줄 것이다. 그래서 그냥 위 태그를 통해 servelt으로 위임을 처음부터 보내는 셈
    	--%>

<jsp:forward page="/signin"/>