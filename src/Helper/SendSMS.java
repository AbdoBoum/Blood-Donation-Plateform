package Helper;

public class SendSMS {
    private final String API_KEY = "f3357b4e";
    private final String API_SECRET = "nr95Yg4Q4QKCAZ14";

      public static void main(String[] args) throws Exception {

        /*  AuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
          NexmoClient client = new NexmoClient(auth);

          TextMessage message = new TextMessage(FROM_NUMBER, TO_NUMBER, "Hello from Nexmo!");

          //There may be more than one response if the SMS sent is more than 160 characters.
          SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(message);
            for (SmsSubmissionResult response : responses) {
            System.out.println(response);
          } */
        /*
          NexmoClient client = new NexmoClient.Builder()
                  .apiKey(API_KEY)
                  .apiSecret(API_SECRET)
                  .build();

          SmsSubmissionResponse responses = client.getSmsClient().submitMessage(new TextMessage(
                  FROM_NUMBER,
                  TO_NUMBER,
                  "Hello from Nexmo!"));
          for (SmsSubmissionResponseMessage response : responses.getMessages()) {
              System.out.println(response);
          }
          */
      }
  }