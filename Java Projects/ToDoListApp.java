import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListApp extends JFrame {
    DefaultListModel<String> taskListModel;
    JList<String> taskList;
    JTextField taskInput;
    public ToDoListApp(){
        setTitle("To-Do List");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        loadTasks();

        taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        addButton.addActionListener(e -> {
            String task = taskInput.getText();
            if(!task.isEmpty()){
                taskListModel.addElement(task);
                taskInput.setText("");
                saveTasks();
            }
        });
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if(index != -1){
                taskListModel.remove(index);
                saveTasks();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(taskInput, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        setVisible(true);
    }
    void loadTasks(){
        try(BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                taskListModel.addElement(line);
            }
        } catch(IOException ignored){}
    }
    void saveTasks(){
        try(PrintWriter writer = new PrintWriter(new FileWriter("tasks.txt"))){
            for(int i=0;i<taskListModel.size();i++){
                writer.println(taskListModel.get(i));
            }
        } catch(IOException e){
            System.out.println("Error saving tasks.");
        }
    }
    public static void main(String[] args) {
        new ToDoListApp();
    }
}
