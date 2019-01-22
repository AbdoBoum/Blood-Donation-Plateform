package Helper;

import Models.Donnateur;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import java.util.List;

public class SendSMS {


      public static void sendSMS(List<Donnateur> donnateurList, String message) throws Exception {
          String API_KEY = "f3357b4e";
          String API_SECRET = "nr95Yg4Q4QKCAZ14";

          NexmoClient client = new NexmoClient.Builder()
                  .apiKey(API_KEY)
                  .apiSecret(API_SECRET)
                  .build();

          for(Donnateur donnateur : donnateurList){
              SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                      "BLOOD DONATION",
                      donnateur.getTeleDonnateur(),
                      message));
              for (SmsSubmissionResponseMessage response : responses.getMessages()) {
                  System.out.println(response);
              }
          }



      }
  }