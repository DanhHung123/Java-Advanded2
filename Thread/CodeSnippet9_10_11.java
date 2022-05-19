package Thread;

public class CodeSnippet9_10_11 {
    public static void main(String[] args) {
        // Code Snippet 9
//        while (true) {
//            while (!isProductReceived) {
//                System.out.println("Product received");
//            }
//        }
//        sendNotification();

        // Code Snippet 10
//        while (true) {
//            while (!isProductReceived) {
//                try {
//                    Thread.sleep(5000);
//                    System.out.println("Product received");
//                }catch (InterruptedException e) {}
//            }
//            sendNotification();
//        }

        // Code Snippet 11
//        while (true) {
//            while (!isProductReceived) {
//                Thread.onSpinWait();
//                System.out.println("Product received");
//            }
//            sendNotification();
//        }
    }
}
