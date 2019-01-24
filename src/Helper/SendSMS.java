package Helper;

import Models.Donnateur;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

import java.util.List;

public class SendSMS implements Runnable{
    private List<Donnateur> donnateurList;
    private String message;

    public SendSMS(List<Donnateur> donnateurList, String message) {
        this.donnateurList = donnateurList;
        this.message = message;
    }

    private void sendSMS() throws Exception {
          String API_KEY = "f3357b4e";
          String API_SECRET = "nr95Yg4Q4QKCAZ14";

          NexmoClient client = new NexmoClient.Builder()
                  .apiKey(API_KEY)
                  .apiSecret(API_SECRET)
                  .build();

          for(Donnateur donnateur : donnateurList){
              SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                      "BLOOD BROTHERS",
                      donnateur.getTeleDonnateur(),
                      message));
              for (SmsSubmissionResponseMessage response : responses.getMessages()) {
                  System.out.println(response);
              }
          }



      }

    @Override
    public void run() {
        try {
            sendSMS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}