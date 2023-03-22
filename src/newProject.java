import java.io.*;


public class newProject {

    public static StringBuilder SB = new StringBuilder();
    public static final String SUCCESSFULLY = "Уcпешно создан!";
    public static final String OPS = "Такой Файл или Папка уже существует! ";

    public void createDir(String dir) {
        File file = new File(dir);
        if (file.mkdir()) {
            SB.append(file.getName()).append(" - директория успешно создана").append("\n");
            System.out.println(file.getName() + " - " + SUCCESSFULLY);
        } else {
            System.err.println(file.getName() + " - " + OPS);
        }
    }


    public void createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                SB.append(file.getName()).append(" - файл успешно создан").append("\n");
                System.out.println(file.getName() + " - " + SUCCESSFULLY);
            } else {
                System.err.println(file.getName() + " - " + OPS);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LogWriter(String file, boolean Append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, Append))) {
            writer.write(SB.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}