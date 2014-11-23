///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package team.soa.cms.msgUtil;
//
//import javax.jms.ExceptionListener;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.ObjectMessage;
//import javax.jms.TextMessage;
//
//
///**
// *
// * @author birui
// *   test class do not use it!!!
// */
//public class MsgQueueListener implements MessageListener, ExceptionListener {
//
//    @Override
//    public void onMessage(Message message) {
//        if (message instanceof ObjectMessage) {
//            ObjectMessage msg = (ObjectMessage) message;
//            try {
//                System.out.println("received object:"+msg.getObject().getClass().getName());
//            } catch (JMSException ex) {
//                ex.printStackTrace();
//            }
//        } else if (message instanceof TextMessage) {
//            TextMessage msg = (TextMessage) message;
//            try {
//                System.out.println("received: " + msg.getText());
//            } catch (JMSException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void onException(JMSException exception) {
//        System.err.println("an error occurred: " + exception); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
