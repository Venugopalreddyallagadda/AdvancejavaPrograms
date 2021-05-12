<%
    int fno = Integer.parseInt(request.getParameter("fno"));
    int sno = Integer.parseInt(request.getParameter("sno"));
   
    String bValue = request.getParameter("b1");
    if(bValue.equalsIgnoreCase("ADD")) {
        out.println("SUM ="+(fno + sno));
    }
    else if(bValue.equalsIgnoreCase("SUB")) {
        out.println("SUB ="+(fno - sno));
    }
    else if(bValue.equalsIgnoreCase("MUL")) {
        out.println("MUL ="+(fno * sno));
    }
    else if(bValue.equalsIgnoreCase("DIV")) {
        out.println("DIV ="+(fno / sno));
    }
   
%>