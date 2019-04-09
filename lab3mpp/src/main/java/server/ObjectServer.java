//package server;
//
//import repo.*;
//import service.Service;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Properties;
//
//public class ObjectServer {
//    private static int defaultPort = 55565;
//
//    static ArtistDbRepo artistDbRepo = new ArtistDbRepo();
//    static EmployeesDbRepo employeesDbRepo = new EmployeesDbRepo();
//    static ShowDbRepo showDbRepo = new ShowDbRepo();
//    static ShowArtistDbRepo showArtistDbRepo = new ShowArtistDbRepo();
//    static TicketDbRepo ticketDbRepo = new TicketDbRepo();
//
//    static Service service = new Service(artistDbRepo, employeesDbRepo, showDbRepo, showArtistDbRepo, ticketDbRepo);
//
//    public static void main(String[] args) {
//        Properties serverProps = new Properties();
//
//        try {
//            serverProps.load(ObjectServer.class.getResourceAsStream("server.properties"));
//            System.out.println("Server properties set. ");
//            serverProps.list(System.out);
//        } catch (IOException var10) {
//            System.err.println("Cannot find server.properties " + var10);
//            return;
//        }
//
//
//        try {
//            ServerSocket socket = new ServerSocket(defaultPort);
//            while(true){
//                Socket client = socket.accept();
//                Thread thread = new Thread(()->{
//                    procesare(client);
//                });
//                thread.start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void procesare(Socket client){
//        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))){
//            try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))){
//                String primit = br.readLine();
//                String[] date = primit.split(",");
//                Boolean rez = service.checkLogin(date[0], date[1]);
//                if(rez){
//                    bw.write("Acceptat.");
//                }
//                else{
//                    bw.write("Rejected.");
//                }
//                bw.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
