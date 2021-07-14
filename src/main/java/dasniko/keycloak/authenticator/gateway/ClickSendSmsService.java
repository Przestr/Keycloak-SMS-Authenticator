package dasniko.keycloak.authenticator.gateway;

import java.util.Arrays;
import java.util.List;
import ClickSend.Api.SmsApi;
import ClickSend.ApiClient;
import ClickSend.ApiException;
import ClickSend.Model.SmsMessage;
import ClickSend.Model.SmsMessageCollection;

public class ClickSendSmsService implements SmsService{

	public ClickSendSmsService() {
	}

	@Override
	public void send(String phoneNumber, String message) {
		ApiClient defaultClient = new ApiClient();
		defaultClient.setUsername("struminski.przemyslaw@gmail.com");
		defaultClient.setPassword("1BCABCC1-6F02-AA77-D6CD-94DEFBF6FA95");
		SmsApi apiInstance = new SmsApi(defaultClient);

		SmsMessage smsMessage=new SmsMessage();
		smsMessage.body(message);
		smsMessage.to(phoneNumber);
		smsMessage.source("test");

		List<SmsMessage> smsMessageList=Arrays.asList(smsMessage);
		// SmsMessageCollection | SmsMessageCollection model
		SmsMessageCollection smsMessages = new SmsMessageCollection();
		smsMessages.messages(smsMessageList);
		try {
			String result = apiInstance.smsSendPost(smsMessages);
			System.out.println(result);
		} catch (ApiException e) {
			System.err.println("Exception when calling SmsApi#smsSendPost");
			e.printStackTrace();
		}
	}


}

