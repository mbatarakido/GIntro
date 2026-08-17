Imports System.Data
Imports System.Data.SqlClient
Partial Class log
    Inherits System.Web.UI.Page
    Public constr As String
    Public ds As New DataSet()
    Public da As SqlClient.SqlDataAdapter
    Public mySqlConn1 As New SqlClient.SqlConnection(constr)
    Public sql, code, asd, type, cartno As String

    Protected Sub Button2_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button2.Click
        If txtemail.Text = "" Or txtpass.Text = "" Then
            lblpass.Text = "Enter the Email address and Password"
        Else
            lblpass.Text = ""
            Dim conn As New SqlConnection
            Dim constr As String
            constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "select * from User1 where email='" & txtemail.Text & "' and pass='" & txtpass.Text & "'"
            Dim comm As New SqlCommand(sql, conn)
            Dim dr As SqlDataReader
            dr = comm.ExecuteReader
            Dim a
            If dr.Read() = True Then
                a = 1
            Else
                a = 0
            End If
            dr.Close()
            If a = 1 Then
                Session("Userid") = txtemail.Text
                sql = "delete cart where uname='" & Session("Userid") & "'"
                Dim cmd As New SqlCommand(sql, conn)
                cmd.ExecuteNonQuery()
                Response.Redirect("Main.aspx")
            Else
                lblpass.Text = "Enter Valid User Name and Password!"
                txtpass.Focus()
            End If
            conn.Close()
        End If
    End Sub

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click
        Response.Redirect("Signin.aspx")
    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

        'If Session("Userid") = "" Then
        '    cart.Text = "0" & " Items"
        'Else
        '    mySqlConn1.ConnectionString = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
        '    Dim comm As New SqlCommand("select count(*) from cart where uname='" & Session("Userid") & "'", mySqlConn1)
        '    Dim dr As SqlDataReader
        '    mySqlConn1.Open()
        '    dr = comm.ExecuteReader
        '    If dr.Read Then
        '        cart.Text = dr.Item(0)
        '        cart.Text = cart.Text & " Items"
        '    End If
        '    dr.Close()
        '    mySqlConn1.Close()
        'End If
        If Session("Userid") <> "" Then
            Response.Redirect("Main.aspx")
        End If

    End Sub
End Class
