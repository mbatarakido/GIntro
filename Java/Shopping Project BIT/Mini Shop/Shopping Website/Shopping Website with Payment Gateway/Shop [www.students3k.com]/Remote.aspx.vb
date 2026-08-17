Imports System.Data
Imports System.Data.SqlClient
Partial Class Remote
    Inherits System.Web.UI.Page
    Public constr As String
    Public ds As New DataSet()
    Public da As SqlClient.SqlDataAdapter
    Public mySqlConn1 As New SqlClient.SqlConnection(constr)
    Public sql, code, asd, type, cartno As String

    Public Sub data(ByVal num As Integer)
        constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
        sql = "select top 8 * from item where code Not in(select top(" & num & ") code from item where category='Remote Controls' order by code)and category='Remote Controls' order by code"
        da = New SqlClient.SqlDataAdapter(sql, constr)
        da.Fill(ds)
        Dim CurrentTable As DataTable
        Dim CurrentRow As DataRow
        For Each CurrentTable In ds.Tables
            Dim count, i As Integer
            count = CurrentTable.Rows.Count
            For i = 0 To count - 1
                Select Case i
                    Case 0
                        Panel1.Visible = True
                        CurrentRow = CurrentTable.Rows(0)
                        lblcode1.Text = (CurrentRow(0))
                        lbl1.Text = (CurrentRow(1))
                        lb01.Text = (CurrentRow(6))
                        Image1.ImageUrl = (CurrentRow(3))
                        lbl3.Text = (CurrentRow(4))
                        '----
                    Case 1
                        Panel2.Visible = True
                        CurrentRow = CurrentTable.Rows(1)
                        lblcode2.Text = (CurrentRow(0))
                        lbl4.Text = (CurrentRow(1))
                        lb02.Text = (CurrentRow(6))
                        Image2.ImageUrl = (CurrentRow(3))
                        lbl6.Text = (CurrentRow(4))
                        '---
                    Case 2
                        Panel3.Visible = True
                        CurrentRow = CurrentTable.Rows(2)
                        lblcode3.Text = (CurrentRow(0))
                        lbl7.Text = (CurrentRow(1))
                        lb03.Text = (CurrentRow(6))
                        Image3.ImageUrl = (CurrentRow(3))
                        lbl9.Text = (CurrentRow(4))
                        '---
                    Case 3
                        Panel4.Visible = True
                        CurrentRow = CurrentTable.Rows(3)
                        lblcode4.Text = (CurrentRow(0))
                        lbl10.Text = (CurrentRow(1))
                        lb04.Text = (CurrentRow(6))
                        Image4.ImageUrl = (CurrentRow(3))
                        lbl12.Text = (CurrentRow(4))
                        '---
                    Case 4
                        Panel5.Visible = True
                        CurrentRow = CurrentTable.Rows(4)
                        lblcode5.Text = (CurrentRow(0))
                        lbl13.Text = (CurrentRow(1))
                        lb05.Text = (CurrentRow(6))
                        Image5.ImageUrl = (CurrentRow(3))
                        lbl15.Text = (CurrentRow(4))
                        ' --
                    Case 5
                        Panel6.Visible = True
                        CurrentRow = CurrentTable.Rows(5)
                        lblcode6.Text = (CurrentRow(0))
                        lbl16.Text = (CurrentRow(1))
                        lb06.Text = (CurrentRow(6))
                        Image6.ImageUrl = (CurrentRow(3))
                        lbl18.Text = (CurrentRow(4))
                        '---
                    Case 6
                        Panel7.Visible = True
                        CurrentRow = CurrentTable.Rows(6)
                        lblcode7.Text = (CurrentRow(0))
                        lbl19.Text = (CurrentRow(1))
                        lb07.Text = (CurrentRow(6))
                        Image7.ImageUrl = (CurrentRow(3))
                        lbl21.Text = (CurrentRow(4))
                        '---
                    Case 7
                        Panel8.Visible = True
                        CurrentRow = CurrentTable.Rows(7)
                        lblcode8.Text = (CurrentRow(0))
                        lbl22.Text = (CurrentRow(1))
                        lb08.Text = (CurrentRow(6))
                        Image8.ImageUrl = (CurrentRow(3))
                        lbl24.Text = (CurrentRow(4))
                End Select
            Next
        Next
        Session.Remove("line")
        mySqlConn1.Close()
    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        lnk1.Visible = False
        lnk2.Visible = False
        lnk3.Visible = False
        lnk4.Visible = False
        lnk5.Visible = False
        lnk6.Visible = False
        lnk7.Visible = False
        lnk8.Visible = False
        lnk9.Visible = False
        lnk10.Visible = False
        Dim conn As New SqlConnection
        Dim constr As String
        constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
        conn.ConnectionString = constr
        conn.Open()
        Dim sql = "select count(*) from item where category='Remote Controls'"
        Dim comm As New SqlCommand(sql, conn)
        Dim dr As SqlDataReader
        dr = comm.ExecuteReader
        If dr.Read() Then
            'MsgBox(dr.Item(0))
            If dr.Item(0) <= 8 Then
                lnk1.Visible = True
            ElseIf dr.Item(0) <= 16 Then
                lnk1.Visible = True
                lnk2.Visible = True
            ElseIf dr.Item(0) <= 24 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
            ElseIf dr.Item(0) <= 32 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
            ElseIf dr.Item(0) <= 40 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
                lnk5.Visible = True
            ElseIf dr.Item(0) <= 48 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
                lnk5.Visible = True
                lnk6.Visible = True
            ElseIf dr.Item(0) <= 56 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
                lnk5.Visible = True
                lnk6.Visible = True
                lnk7.Visible = True
            ElseIf dr.Item(0) <= 64 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
                lnk5.Visible = True
                lnk6.Visible = True
                lnk7.Visible = True
                lnk8.Visible = True
            ElseIf dr.Item(0) <= 72 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
                lnk5.Visible = True
                lnk6.Visible = True
                lnk7.Visible = True
                lnk8.Visible = True
                lnk9.Visible = True
            ElseIf dr.Item(0) <= 80 Then
                lnk1.Visible = True
                lnk2.Visible = True
                lnk3.Visible = True
                lnk4.Visible = True
                lnk5.Visible = True
                lnk6.Visible = True
                lnk7.Visible = True
                lnk8.Visible = True
                lnk9.Visible = True
                lnk10.Visible = True
            End If
        End If
        Panel1.Visible = False
        Panel2.Visible = False
        Panel3.Visible = False
        Panel4.Visible = False
        Panel5.Visible = False
        Panel6.Visible = False
        Panel7.Visible = False
        Panel8.Visible = False
        data(Session("line"))
    End Sub

    Protected Sub lnk1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk1.Click
        Session("line") = 0
        Response.Redirect("Remote.aspx")
        ' Session.Remove("line")

    End Sub

    Protected Sub lnk2_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk2.Click
        Session("line") = 8
        Response.Redirect("Remote.aspx")
        ' Session.Remove("line")
    End Sub

    Protected Sub lnk3_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk3.Click
        Session("line") = 16
        Response.Redirect("Remote.aspx")
        'Session.Remove("line")
    End Sub

    Protected Sub ImageButton1_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton1.Click
        Try
            Session("name") = lblcode1.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton2_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton2.Click
        Dim conn As New SqlConnection
        conn.ConnectionString = constr
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else

            conn.Open()
            Dim sql = "insert into cart values('" & lbl1.Text & "'," & lbl3.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton4_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton4.Click
        Try
            Session("name") = lblcode2.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton5_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton5.Click
        Try
            Session("name") = lblcode3.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton7_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton7.Click
        Try
            Session("name") = lblcode4.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton9_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton9.Click
        Try
            Session("name") = lblcode5.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton11_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton11.Click
        Try
            Session("name") = lblcode6.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton13_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton13.Click
        Try
            Session("name") = lblcode7.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub ImageButton15_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton15.Click
        Try
            Session("name") = lblcode8.Text
            Response.Redirect("viewrecord.aspx")
        Catch ex As Exception
        End Try
    End Sub

    Protected Sub lnk4_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk4.Click
        Session("line") = 24
        Response.Redirect("Remote.aspx")
        ' Session.Remove("line")
    End Sub

    Protected Sub lnk5_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk5.Click
        Session("line") = 32
        Response.Redirect("Remote.aspx")

        ' Session.Remove("line")
    End Sub

    Protected Sub lnk6_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk6.Click
        Session("line") = 40
        Response.Redirect("Remote.aspx")
        '  Session.Remove("line")
    End Sub

    Protected Sub lnk7_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk7.Click
        Session("line") = 48
        Response.Redirect("Remote.aspx")
        '  Session.Remove("line")
    End Sub

    Protected Sub lnk8_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk8.Click
        Session("line") = 56
        Response.Redirect("Remote.aspx")
        '   Session.Remove("line")
    End Sub

    Protected Sub lnk9_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk9.Click
        Session("line") = 64
        Response.Redirect("Remote.aspx")
        '   Session.Remove("line")
    End Sub

    Protected Sub lnk10_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles lnk10.Click
        Session("line") = 72
        Response.Redirect("Remote.aspx")
        'Session.Remove("line")
    End Sub

    Protected Sub ImageButton6_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton6.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl7.Text & "'," & lbl9.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton10_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton10.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl13.Text & "'," & lbl15.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton3_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton3.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl4.Text & "'," & lbl6.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton8_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton8.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl10.Text & "'," & lbl12.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton12_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton12.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl16.Text & "'," & lbl18.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton14_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton14.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl19.Text & "'," & lbl21.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub ImageButton16_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton16.Click
        If Session("userID") = "" Then
            Response.Redirect("login.aspx")
        Else
            Dim conn As New SqlConnection
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "insert into cart values('" & lbl22.Text & "'," & lbl24.Text & ",'" & Session("userid") & "', " & 1 & ")"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            conn.Close()
            Response.Redirect("Remote.aspx")
        End If
    End Sub

    Protected Sub form1_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles form1.Load
        If Session("Userid") = "" Then
            cart.Text = "0" & " Items"
        Else
            mySqlConn1.ConnectionString = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
            Dim comm As New SqlCommand("select count(*) from cart where uname='" & Session("Userid") & "'", mySqlConn1)
            'mySqlConn1.ConnectionString = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
            Dim dr As SqlDataReader
            mySqlConn1.Open()
            dr = comm.ExecuteReader
            If dr.Read Then
                cart.Text = dr.Item(0)
                cart.Text = cart.Text & " Items"
            End If
            dr.Close()
            mySqlConn1.Close()
        End If
    End Sub

    Protected Sub ImageButton17_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton17.Click
        If Session("Userid") = "" Then
            Response.Redirect("Remote.aspx")
        Else
            Response.Redirect("cart.aspx")
        End If
    End Sub
End Class
