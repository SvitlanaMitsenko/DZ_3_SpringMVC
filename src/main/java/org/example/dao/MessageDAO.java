package org.example.dao;

import org.example.models.Message;
import org.omg.IOP.Encoding;
import org.springframework.stereotype.Repository;
import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageDAO {
    private static ArrayList<Message> list = new ArrayList<Message>();
    //private static String path = "../../../../resources/messageData.txt";
    private static String path = "C:\\Users\\User\\Documents\\JAVA\\Spring\\SpringDZ\\DZ_3_SpringMVC\\src\\main\\resources\\messageData.txt";
    private static File file;

    static {
        createFile();
        list = readMessagesFromFile();
    }

    public List<Message> getMessageList() {
        return list;
    }

    public void addMessage(Message message) {
        list.add(message);
        writeMessageToFile(list);
    }

    private boolean writeMessageToFile(ArrayList<Message> list) {
        try {
            FileOutputStream writeData = new FileOutputStream(file, false);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(list);
            writeStream.flush();
            writeStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static ArrayList<Message> readMessagesFromFile() {
        ArrayList<Message> messages = new ArrayList<Message>();
        try {
            FileInputStream readData = new FileInputStream(file);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            messages = (ArrayList<Message>) readStream.readObject();
            readStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ( messages == null) messages = new ArrayList<Message>();
        return messages;
    }
    private static void createFile() {
        file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
