<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Expire.aspx.vb" Inherits="Expire" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:Label ID="Label1" runat="server" Font-Bold="True" Font-Size="XX-Large" Text="Session Expired"></asp:Label><br />
        <br />
        Your Session has Expired. Please
        <asp:LinkButton ID="LinkButton1" runat="server">return to Home Page</asp:LinkButton>&nbsp;
        and login Again to Continue<br />
        accessing your Account<br />
        <br />
    </div>
    </form>
</body>
</html>
