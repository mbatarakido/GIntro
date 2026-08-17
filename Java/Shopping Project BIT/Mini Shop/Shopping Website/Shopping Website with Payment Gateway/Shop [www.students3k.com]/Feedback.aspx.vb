
Partial Class Feedback
    Inherits System.Web.UI.Page

    Protected Sub Button1_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Button1.Click
        Try
            Dim FromEmailAddress, ToEmailAddress As String
            FromEmailAddress = TextBox1.Text
            ToEmailAddress = "nisar@isoftech.in"
            Dim mm As New Net.Mail.MailMessage(FromEmailAddress, ToEmailAddress)
            mm.Subject = "Feed Back From Shoping Site"
            mm.IsBodyHtml = True
            mm.Body = "<br><br>Subject : " & TextBox3.Text & "<br>Email Id : " & TextBox1.Text & "<br>Contact Inforamtion : " & TextBox4.Text & "<br>Discription : " & TextBox2.Text & ""
            Dim smtp As New Net.Mail.SmtpClient
            smtp.Host = "mx.isoftech.in"
            smtp.Send(mm)
            '  Panel1.Visible = False
            '  Session("hy") = 10
            Label1.Text = "Your Feed Back has been Sent to Administrator"
        Catch ex As Exception
            Label1.Text = "Enter the Carrect Email ID"
        End Try
    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Label1.Text = ""

    End Sub
End Class
