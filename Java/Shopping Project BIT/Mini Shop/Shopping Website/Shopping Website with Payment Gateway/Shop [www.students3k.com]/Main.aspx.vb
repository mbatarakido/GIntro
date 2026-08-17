Imports System.Data
Imports System.Data.SqlClient
Partial Class Main
    Inherits System.Web.UI.Page

  
    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Response.Buffer = True
        Response.ExpiresAbsolute = Now().Subtract(New TimeSpan(1, 0, 0, 0))
        Response.Expires = 0
        Response.CacheControl = "no-cache"
        Response.Expires = 0
        Response.Cache.SetNoStore()
        Response.AppendHeader("Pragma", "no-cache")
        If Session("userid") = "" Then
            Response.Redirect("Expire.aspx")
        Else
            Panel1.Visible = False
            Label1.Text = Session("userid")
            If Session("wrong") <> Val(10) Then
                Panel1.Visible = False
            Else
                Panel1.Visible = True
                Label2.Text = "Invalid Password !"
            End If
        End If
       
    End Sub

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim con As New SqlClient.SqlConnection("server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;")
        con.Open()
        Dim dr As SqlClient.SqlDataReader
        Dim cmd As New SqlClient.SqlCommand("select * from user1 where email='" & Session("userid") & "' and pass='" & TextBox1.Text & "'", con)
        dr = cmd.ExecuteReader
        If dr.Read Then
            dr.Close()
            Dim cmd1 As New SqlClient.SqlCommand("update user1 set pass='" & TextBox2.Text & "' where email='" & Session("userid") & "'", con)
            cmd1.ExecuteNonQuery()
            Session.Remove("wrong")
            Response.Redirect("Main.aspx")
        Else
            Session("wrong") = 10
            Response.Redirect("Main.aspx")
        End If
        dr.Close()
    End Sub

 

    Protected Sub ImageButton1_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton1.Click
        Session.RemoveAll()
        Response.Redirect("view.aspx")
    End Sub

    
    Protected Sub ImageButton4_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton4.Click
        Panel1.Visible = True
    End Sub

    Protected Sub ImageButton2_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton2.Click
        Response.Redirect("view.aspx")
    End Sub

    Protected Sub ImageButton3_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton3.Click
        Response.Redirect("Search.aspx")
    End Sub

    Protected Sub ImageButton5_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton5.Click
        Response.Redirect("Address.aspx")
    End Sub
End Class
