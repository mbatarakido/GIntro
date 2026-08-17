Imports System.Data
Imports System.Data.SqlClient
Partial Class cart
    Inherits System.Web.UI.Page
    Public constr As String
    Public ds As New DataSet()
    Public da As SqlClient.SqlDataAdapter
    Public mySqlConn1 As New SqlClient.SqlConnection(constr)

  
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

            Dim conn As New SqlConnection
            Dim constr As String
            constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "select name,quntity,amount from cart where Uname='" & Session("userid") & "'"
            Dim comm As New SqlCommand(sql, conn)
            Dim ds As New DataSet
            Dim da As New SqlDataAdapter(comm)
            da.Fill(ds)
            GridView1.DataSource = ds
            GridView1.DataMember = ds.Tables(0).ToString
            GridView1.DataBind()
            conn.Close()
        End If

    End Sub

    Protected Sub GridView1_RowDeleting(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.GridViewDeleteEventArgs) Handles GridView1.RowDeleting
        Try
            Dim k As String
            k = GridView1.SelectedRow.Cells(1).Text
            '  MsgBox(k)
            Dim conn As New SqlConnection
            Dim constr As String
            constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
            conn.ConnectionString = constr
            conn.Open()
            Dim sql = "delete from cart where Name='" & k & "' and Uname='" & Session("userid") & "'"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            Response.Redirect("cart.aspx")
            conn.Close()
        Catch ex As Exception
            Label1.Text = "Please Select the Product To Delete...."
        End Try

    End Sub

    Protected Sub cartt_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles cartt.Load
        If Session("userid") = "" Then
            Response.Redirect("Expire.aspx")
        Else
            Try
                mySqlConn1.ConnectionString = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
                Dim comm As New SqlCommand("select count(*) from cart where uname='" & Session("Userid") & "'", mySqlConn1)
                Dim dr As SqlDataReader
                mySqlConn1.Open()
                dr = comm.ExecuteReader
                If dr.Read Then
                    cartt.Text = dr.Item(0)
                    cartt.Text = cartt.Text & " Items"
                End If
                dr.Close()
                mySqlConn1.Close()
            Catch ex As Exception
            End Try
        End If

    End Sub

    Protected Sub form1_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles form1.Load
        If Session("userid") = "" Then
            Response.Redirect("Expire.aspx")
        Else
            Try
                mySqlConn1.ConnectionString = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
                Dim comm As New SqlCommand("select sum(Amount) from cart where uname='" & Session("Userid") & "'", mySqlConn1)
                Dim dr As SqlDataReader
                mySqlConn1.Open()
                dr = comm.ExecuteReader
                If dr.Read Then
                    txtamount.Text = dr.Item(0)
                    txtamount.Text = Val(txtamount.Text)
                End If
                dr.Close()
                mySqlConn1.Close()
            Catch ex As Exception
            End Try
        End If
    End Sub
    Protected Sub GridView1_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles GridView1.SelectedIndexChanged
        '  Try
        txtqunity.Text = GridView1.SelectedRow.Cells(2).Text
        TextBox2.Text = GridView1.SelectedRow.Cells(1).Text
        mySqlConn1.ConnectionString = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
        Dim comm As New SqlCommand("select amount from item where name='" & TextBox2.Text & "'", mySqlConn1)
        Dim dr As SqlDataReader
        mySqlConn1.Open()
        dr = comm.ExecuteReader
        If dr.Read Then
            TextBox3.Text = dr.Item(0)
        End If
        dr.Close()
        mySqlConn1.Close()
    End Sub

    Protected Sub ImageButton2_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton2.Click
        If Session("userid") = "" Then
            Response.Redirect("Expire.aspx")
        Else
            If txtqunity.Text = "" Then
                Label1.Text = "Please Select the Product To update Your Cart Quntity...."
            Else
                Dim amount As Double
                amount = Val(txtqunity.Text) * Val(TextBox3.Text)
                '  MsgBox(amount)
                Dim conn As New SqlConnection
                Dim constr As String
                constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
                conn.ConnectionString = constr
                conn.Open()
                Dim sql = "update cart set Quntity=" & Val(txtqunity.Text) & ",amount=" & amount & " where name='" & TextBox2.Text & "' and uname='" & Session("Userid") & "'"
                Dim comm As New SqlCommand(sql, conn)
                comm.ExecuteNonQuery()
                Response.Redirect("cart.aspx")
                conn.Close()
            End If
        End If
    End Sub

    Protected Sub ImageButton1_Click(ByVal sender As Object, ByVal e As System.Web.UI.ImageClickEventArgs) Handles ImageButton1.Click
        If Session("userid") = "" Then
            Response.Redirect("Expire.aspx")
        Else
            Session("amount") = txtamount.Text
            Dim conn As New SqlClient.SqlConnection("server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;")
            conn.Open()
            Dim sql = "insert into Order1(d,total,uname,status) values('" & Now.ToShortDateString & "'," & txtamount.Text & ",'" & Session("userid") & "','" & "Pending" & "')"
            Dim comm As New SqlCommand(sql, conn)
            comm.ExecuteNonQuery()
            ' conn.Close()
            'Dim conn As New SqlConnection("server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;")
            ' Dim da As New SqlClient.SqlDataAdapter
            Dim cmb As New SqlClient.SqlCommand
            Dim ds As New DataSet
            Dim dr1 As SqlClient.SqlDataReader
            Dim dt As New DataTable
            Dim dr As DataRow
            cmb.Connection = conn
            cmb.CommandText = "Select * from cart where uname='" & Session("Userid") & "'"
            dr1 = cmb.ExecuteReader
            dt.Columns.Add("name")
            dt.Columns.Add("amount")
            dt.Columns.Add("uname")
            dt.Columns.Add("quantity")
            Do While dr1.Read
                dr = dt.NewRow()
                dr("name") = dr1.Item(0)
                dr("amount") = dr1.Item(1)
                dr("uname") = dr1.Item(2)
                dr("quantity") = dr1.Item(3)
                dt.Rows.Add(dr)
            Loop
            dr1.Close()
            cmb.CommandText = "Select max(billno) from order1 where uname='" & Session("Userid") & "'"
            Dim a
            dr1 = cmb.ExecuteReader
            dr1.Read()
            a = dr1.Item(0)
            Session("billno") = a
            dr1.Close()
            Dim i
            For i = 0 To dt.Rows.Count - 1
                dr = dt.Rows(i)
                cmb.CommandText = "insert into Order_details values(" & a & ",'" & dr("name") & "'," & dr("amount") & "," & dr("quantity") & ")"
                cmb.ExecuteNonQuery()
            Next
            Response.Redirect("invoice.aspx")
        End If

    End Sub
End Class
