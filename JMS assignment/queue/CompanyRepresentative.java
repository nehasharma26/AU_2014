import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Session;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import java.util.logging.Level;


public class CompanyRepresentative {

    /**
     * Main line.
     *
     * @param args command line arguments
     */

    private static final Logger logger = Logger.getLogger(CompanyRepresentative.class.getName());
    public static void main(String[] args) {
        Context context = null;
        ConnectionFactory factory = null;
        Connection connection = null;
        String factoryName = "ConnectionFactory";
        String orderQueue = "OrderQueue";
        String approvalQueue = "ApprovalQueue";
        Destination orderQueueDest = null;
        Destination approvalQueueDest = null;
        int count = 1;
        Session session = null;
        MessageConsumer receiver = null;
        MessageProducer sender = null;

        if (args.length != 0) {
            logger.log(Level.INFO,"usage: CompanyRepresentative");
            System.exit(1);
        }

        try {
            // create the JNDI initial context
            context = new InitialContext();

            // look up the ConnectionFactory
            factory = (ConnectionFactory) context.lookup(factoryName);

            // look up the Destination
            orderQueueDest = (Destination) context.lookup(orderQueue);
            approvalQueueDest = (Destination) context.lookup(approvalQueue);

            // create the connection
            connection = factory.createConnection();

            // create the session
            session = connection.createSession(
                false, Session.AUTO_ACKNOWLEDGE);

            // create the receiver
            receiver = session.createConsumer(orderQueueDest);

            //create the sender
            sender = session.createProducer(approvalQueueDest);
            
            // start the connection, to enable message receipt
            connection.start();

            // your code to receive the order quantity from OrderQueue goes here
            Message message = receiver.receive();
            if (message instanceof TextMessage) {
                TextMessage text = (TextMessage) message;
                logger.log(Level.INFO,"Number of orders placed: " + text.getText());
            } else if (message != null) {
                logger.log(Level.INFO,"didnt receive message");
                }


            // your code to send the approved/non-approved flag to ApprovalQueue goes here

                    
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("Your order cant be processed");
            sender.send(textMessage);
            logger.log(Level.INFO,"Sent: " + textMessage.getText());




        } catch (JMSException exception) {
            exception.printStackTrace();
        } catch (NamingException exception) {
            exception.printStackTrace();
        } finally {
            // close the context
            if (context != null) {
                try {
                    context.close();
                } catch (NamingException exception) {
                    exception.printStackTrace();
                }
            }

            // close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
