Imports System.Data
Imports System.Data.SqlClient
Partial Class Report
    Inherits System.Web.UI.Page
    Protected Sub btnhome_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btnhome.Click
        If Session("admin") = "" Then
            Response.Redirect("expire.aspx")
        Else
            Response.Redirect("admin.aspx")
        End If
    End Sub

    Protected Sub btnadd_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btnadd.Click
        If Session("admin") = "" Then
            Response.Redirect("expire.aspx")
        Else
            Response.Redirect("additem.aspx")
        End If
    End Sub

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click
        If Session("admin") = "" Then
            Response.Redirect("expire.aspx")
        Else
            Response.Redirect("report.aspx")
        End If
    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        If IsPostBack = False Then
            If Session("admin") = "" Then
                Response.Redirect("expire.aspx")
            Else
                Dim conn As New SqlConnection
                Dim constr As String
                constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
                conn.ConnectionString = constr
                conn.Open()
                Dim sql = "select billno,d,uname,total from order1 where status='Pending'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            End If
        End If
    End Sub

    Protected Sub Button2_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button2.Click
        Calendar1.Visible = True
    End Sub

    Protected Sub Calendar1_SelectionChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles Calendar1.SelectionChanged
        d.Text = Calendar1.SelectedDate
        Calendar1.Visible = False
    End Sub

    Protected Sub btnshow_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles btnshow.Click

        Try
            If Session("admin") = "" Then
                Response.Redirect("expire.aspx")
            End If
            Dim conn As New SqlConnection
            Dim constr As String
            constr = "server=.\SQLEXPRESS;database=shoping;trusted_connection=yes;"
            conn.ConnectionString = constr
            conn.Open()
            If d.Text = "" And txtamount.Text = "" Then
                Dim sql = "select billno,d,uname,total from order1 where billno='" & txtbill.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            ElseIf txtbill.Text = "" And d.Text = "" Then
                Dim sql = "select billno,d,uname,total from order1 where total='" & txtamount.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            ElseIf txtbill.Text = "" And txtamount.Text = "" Then
                Dim sql = "select billno,d,uname,total from order1 where d='" & d.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            ElseIf d.Text = "" Then
                Dim sql = "select billno,d,uname,total from order1 where billno='" & txtbill.Text & "' and total='" & txtamount.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            ElseIf txtbill.Text = "" Then
                Dim sql = "select billno,d,uname,total from order1 where d='" & d.Text & "' and total='" & txtamount.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            ElseIf txtamount.Text = "" Then
                Dim sql = "select billno,d,uname,total from order1 where billno='" & txtbill.Text & "'and d='" & d.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            Else
                Dim sql = "select billno,d,uname,total from order1 where billno='" & txtbill.Text & "'and d='" & d.Text & "' and total='" & txtamount.Text & "'and status='Paid'"
                Dim comm As New SqlCommand(sql, conn)
                Dim ds As New DataSet
                Dim da As New SqlDataAdapter(comm)
                da.Fill(ds)
                GridView1.DataSource = ds
                GridView1.DataMember = ds.Tables(0).ToString
                GridView1.DataBind()
                conn.Close()
            End If
        Catch ex As Exception
            MsgBox(ex.Message)
        End Try

    End Sub

    Protected Sub GridView1_ItemCommand(ByVal source As Object, ByVal e As System.Web.UI.WebControls.DataGridCommandEventArgs) Handles GridView1.ItemCommand
        Dim dr As New TableCell
        dr = e.Item.Cells(1)
        Session("paid") = dr.Text
        Response.Redirect("status.aspx")
       
    End Sub

    Protected Sub GridView1_SelectedIndexChanged(ByVal sender As Object, ByVal e As System.EventArgs) Handles GridView1.SelectedIndexChanged

    End Sub
End Class
