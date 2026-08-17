<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Robot.aspx.vb" Inherits="Robot" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-5" />
<link rel="stylesheet" type="text/css" href="style.css" />
<script language="javascript" type="text/javascript">
// <!CDATA[

function IMG1_onclick() {

}

function LI1_onclick() {

}

function IMG3_onclick() {

}

// ]]>
</script>
</head>
<body>
    <form id="form1" runat="server">
        <div id="header">
		<div class="block1">
		</div>
		<div class="block2">
			<ul>
				<li><a href="#">Specials</a></li>
				<li><a href="Search.aspx">Search</a></li>
				<li><a href="#">Contact Us</a></li>
				<li><a href="Signin.aspx">Create an account</a></li>
				<li><a href="Login.aspx">Customer Login</a></li>
			</ul>
		</div>
		<div class="block3" style="width: 168px">
			<a href="#"></a>
            <asp:ImageButton ID="ImageButton17" runat="server" ImageUrl="~/images/cart.jpg" />
            <span>Shopping Cart<asp:Label ID="cart" runat="server" Font-Size="Small" ForeColor="Red"
                Text="*"></asp:Label></span> &nbsp;&nbsp;</div>
		<a href="#"><img src="images/name.jpg" alt="" width="396" height="117" /></a><img src="images/pic1.jpg" alt="" height="117" style="width: 360px" /><br />
		<ul class="menu" style="width: 784px">
			<li><a href="view.aspx?ref=true"><img src="images/but1.jpg" alt="Home" width="135" height="36" id="IMG2" onclick="return IMG2_onclick()" /></a></li>
			<li><a href="Login.aspx"><img src="images/but2.jpg" alt="" width="130" height="36" /></a></li>
			<li><a href="#"><img src="images/but3.jpg" alt="" width="130" height="36" id="IMG3" onclick="return IMG3_onclick()" /></a></li>
			<li><a href="#"><img src="images/but4.jpg" alt="" width="130" height="36" id="IMG1" onclick="return IMG1_onclick()" /></a></li>
			<li><a href="#"><img src="images/but5.jpg" alt="" width="130" height="36" /></a></li>
			<li><img src="images/butclean.jpg" alt="" width="111" height="36" /></li>
		</ul>
	</div>
	<div id="content">
        &nbsp;<div class="left">
			<img src="images/title1.jpg" alt="" width="198" height="30" /><br />
			<ul>
				<li class="dots"><a href="Robot.aspx">Robot Electronics</a></li>
				<li class="dots"><a href="Remote.aspx">Remote Controls</a></li>
				<li class="dots"><a href="Programers.aspx">Programers</a></li>
				<li class="dots"><a href="Boards.aspx">Boards</a></li>
				<li class="dots"><a href="Motors.aspx">Motors</a></li>
				<li class="dots"><a href="Batteries.aspx">Batteries</a></li>
				<li class="dots"><a href="Robots.aspx">Robots</a></li>
				<li class="dots"><a href="Micro.aspx">Micro Controllers</a></li>
				<li class="dots"><a href="Components.aspx">Components</a></li>
				<li class="dots"><a href="Sensor.aspx">Sensor</a></li>
				<li class="dots"><a href="other.aspx">Other</a></li>
				<li class="dots"><a href="Specials.aspx">Specials..</a></li>
				<li class="dots"><a href="Newproduct.aspx">New Product</a></li>
			</ul>
			<img src="images/title2.jpg" alt="" width="198" height="30" /><br />
            <br />
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Now In Your Cart<br />
            <br />
            <br />
            <asp:Label ID="lblcart" runat="server" Text="1"></asp:Label><br />
            <br />
            <br />
            <br />
            <br />
		</div>
		<div class="right">
			<asp:Panel ID="Panel1" runat="server">
			<div class="item">
				<img src="images/bordtop.gif" alt="" width="274" height="2" />
				<div>
                    <asp:Image ID="Image1" runat="server" width="104px" height="56px" />
		           <span>
                        <asp:Label ID="lbl1" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode1" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb01" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                   <asp:Label ID="lbl3" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;<a href="#"></a>
                    <asp:ImageButton ID="ImageButton1" runat="server" ImageUrl="~/images/button1.gif" /><asp:ImageButton
                        ID="ImageButton2" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
                </asp:Panel>
            <asp:Panel ID="Panel2" runat="server">
            <div class="item">
				<img src="images/bordtop.gif" alt="" width="274" height="2" />
				<div>
					<asp:Image ID="Image2" runat="server" width="102" height="56px"/>
                    <span>
                        <asp:Label ID="lbl4" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode2" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb02" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl6" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label>&nbsp;
                    <asp:ImageButton ID="ImageButton4" runat="server" ImageUrl="~/images/button1.gif" /><asp:ImageButton
                        ID="ImageButton3" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
            </asp:Panel>
            <asp:Panel ID="Panel3" runat="server">
            <div class="item">
				<img src="images/bordtop.gif" alt="" width="274" height="2" />
				<div>
					<asp:Image ID="Image3" runat="server" width="102" height="56px"/>
                    <span>
                        <asp:Label ID="lbl7" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode3" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb03" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl9" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;<asp:ImageButton
                        ID="ImageButton5" runat="server" ImageUrl="~/images/button1.gif" /><a href="#"></a><asp:ImageButton
                            ID="ImageButton6" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
             </asp:Panel>
             <asp:Panel ID="Panel4" runat="server">
            <div class="item">
				<img src="images/bordtop.gif" alt="" width="274" height="2" />
				<div>
					<asp:Image ID="Image4" runat="server" width="102" height="56px"/>
                    <span>
                        <asp:Label ID="lbl10" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="Navy"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode4" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb04" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl12" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;<asp:ImageButton
                        ID="ImageButton7" runat="server" ImageUrl="~/images/button1.gif" /><a href="#"></a><asp:ImageButton
                            ID="ImageButton8" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
            </asp:Panel>
             <asp:Panel ID="Panel5" runat="server">
            <div class="item">
				<img src="images/bordtop.gif" alt="" width="274" height="2" />
				<div>
					<asp:Image ID="Image5" runat="server" width="102" height="56px" />
                    <span>
                        <asp:Label ID="lbl13" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode5" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb05" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl15" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;
                    <asp:ImageButton ID="ImageButton9" runat="server" ImageUrl="~/images/button1.gif" /><asp:ImageButton
                        ID="ImageButton10" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
            </asp:Panel>
            <asp:Panel ID="Panel6" runat="server">
            <div class="item">
                <img src="images/bordtop.gif" alt="" width="274" height="2" />
                <div>
                    <asp:Image ID="Image6" runat="server" width="102" height="56px"/>
                    <span>
                        <asp:Label ID="lbl16" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode6" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb06" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl18" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;<a href="#"></a>
                    <asp:ImageButton ID="ImageButton11" runat="server" ImageUrl="~/images/button1.gif" /><asp:ImageButton
                        ID="ImageButton12" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
             </asp:Panel>
             <asp:Panel ID="Panel7" runat="server">
             <div class="item">
                <img src="images/bordtop.gif" alt="" width="274" height="2" />
                <div>
                   <asp:Image ID="Image7" runat="server" width="102" height="56px"/>
                    <span>
                        <asp:Label ID="lbl19" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode7" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb07" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl21" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;<a href="#"></a>
                    <asp:ImageButton ID="ImageButton13" runat="server" ImageUrl="~/images/button1.gif" /><asp:ImageButton
                        ID="ImageButton14" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
              </asp:Panel>
              <asp:Panel ID="Panel8" runat="server">
             <div class="item">
                             <img src="images/bordtop.gif" alt="" width="274" height="2" />
                <div>
                  <asp:Image ID="Image8" runat="server" width="102" height="56px"/>
                    <span>
                        <asp:Label ID="lbl22" runat="server" Text="Label" Font-Bold="True" Font-Underline="True" ForeColor="DarkBlue"></asp:Label></span>
                    <p>
                        <strong>
                            <asp:Label ID="lblcode8" runat="server" Text="Label" Visible="False"></asp:Label>
                            <asp:Label ID="lb08" runat="server" Text="Label"></asp:Label></strong>&nbsp;</p>
                    <asp:Label ID="lbl24" runat="server" Text="Label" Font-Bold="True" ForeColor="Red"></asp:Label><a href="#"></a>&nbsp;<a href="#"></a>
                    <asp:ImageButton ID="ImageButton15" runat="server" ImageUrl="~/images/button1.gif" /><asp:ImageButton
                        ID="ImageButton16" runat="server" ImageUrl="~/images/button2.gif" Width="127px" /></div>
                <img src="images/bordbot.gif" alt="" width="274" height="2" />
            </div>
            </asp:Panel>
           
            
		</div>
		 </div>
		  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
            &nbsp;&nbsp; Pages:
            <asp:LinkButton ID="lnk1" runat="server">1</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk2" runat="server">2</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk3" runat="server" >3</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk4" runat="server">4</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk5" runat="server">5</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk6" runat="server">6</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk7" runat="server">7</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk8" runat="server">8</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk9" runat="server">9</asp:LinkButton>
            &nbsp;
            <asp:LinkButton ID="lnk10" runat="server">10</asp:LinkButton>&nbsp;
		 
	<div id="footer">
		Copyright &copy; 2007 CompanyName. All Rights Reserved / <a href="#" class="powered"><strong>Powered by osCommerce</strong></a><br />
		<a href="#" class="terms">Terms of Use</a> / <a href="#" class="terms">Privacy Policy</a>
	</div>
    
    </form>
</body>
</html>