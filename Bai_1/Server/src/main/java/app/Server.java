package app;

import dao.AlbumDAO;
import jakarta.persistence.EntityManager;
import services.AlbumService;
import services.EntityManagerFactoryUtil;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server start on port 8888");
//            ExecutorService executorService = Executors.newCachedThreadPool();
            while (true){
                Socket socket = serverSocket.accept();
//                executorService.execute(new Client);
//              Way 2
                Thread thread = new Thread();
                thread.start();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class ClientHandler implements Runnable {
    private Socket clientSocket;
    private EntityManagerFactoryUtil mangerFactoryUtil;
    private EntityManager entityManager;
    private AlbumService albumService;
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.mangerFactoryUtil = new EntityManagerFactoryUtil();
        this.entityManager = mangerFactoryUtil.getEntityManager();
        this.albumService = new AlbumService(entityManager);

    }

    @Override
    public void run() {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            int choice = 0;
            while(true) {
                choice = inputStream.read();
                switch (choice){
                    case 1:
//                        Map<Department, Long> map = departmentService.countCoursesByDepartment();
//                        out.writeObject(map);
//                        out.flush();
                        break;
                    case 2:
//                        String title = in.readUTF();
//                        System.out.println("Client requested to search for: " + title);
//                        List<Student> students = studentService.findStudentsEnrolledInCourseByCourseTitle(title);
//                        out.writeObject(students);
//                        out.flush();
                        break;

                    case 3:
//                        List<OnsiteCourse> onsiteCourses = courseService.findAllOnsiteCourses();
//                        out.writeObject(onsiteCourses);
//                        out.flush();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.mangerFactoryUtil.closeEntityManager();
            this.mangerFactoryUtil.closeEntityManagerFactory();
        }

    }
}
