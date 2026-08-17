Imports System.Data
Imports System.Data.SqlClient
Partial Class Dollor
    Inherits System.Web.UI.Page
    Public Sub frm()
        Dim conn As New SqlConnection
        Dim dr As SqlDataReader
        conn.ConnectionString = ("server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;")
        conn.Open()
        Dim cmd As New SqlCommand("select * from dolor", conn)
        dr = cmd.ExecuteReader
        If dr.Read Then
            TextBox2.Text = dr.Item(0)
        End If
    End Sub
    Protected Sub Button3_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button3.Click
        If TextBox1.Text = "" Then
            Label1.Text = "Enter the Today $ Price"
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = ("server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;")
            conn.Open()
            Dim cmd As New SqlCommand("update dolor set amount=" & TextBox1.Text & "", conn)
            cmd.ExecuteNonQuery()
            TextBox1.Text = ""
            Label1.Text = "Amount is updated Succsessfully"
            frm()
        End If

    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        frm()
    End Sub
End Class
