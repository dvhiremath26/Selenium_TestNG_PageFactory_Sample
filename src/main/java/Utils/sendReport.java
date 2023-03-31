package Utils;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class sendReport {
	
	// Find your Account Sid and Token at twilio.com/console
	public static final String ACCOUNT_SID = "ACb944e47d50d468cf34ea3bf1d1bca409";
	public static final String AUTH_TOKEN = "1138bd31a23887f73da6c5e7d1108444";
	
	public static String report;

	String reportFilePath = "./reports/TestExecutionReport.html";



	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
				new com.twilio.type.PhoneNumber("+919663639016"),
				new com.twilio.type.PhoneNumber("+14345955185"),
				"Test report is Ready!")
				.create();

		System.out.println(message.getSid());
	}
}

