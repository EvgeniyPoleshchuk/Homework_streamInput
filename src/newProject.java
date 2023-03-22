import java.io.*;

public class newProject {

    public static void main(String[] args) {

        String[] dirName = {"D:/Games/src", "D:/Games/res", "D:/Games/savegames", "D:/Games/temp",
                "D:/Games/src/main",
                "D:/Games/src/test",
                "D:/Games/res/drawables",
                "D:/Games/res/vectors",
                "D:/Games/res/icons"};
        String[] fileName = {"D:/Games/src/main/Main.java", "D:/Games/src/main/Utils.java", "D:/Games/temp/temp.txt"};
        StringBuilder sb = new StringBuilder();

        for (String s : dirName) {
            File file = new File(s);
            if (file.mkdir()) {
                System.out.println("Успешно");
                sb.append(file.getName()).append(" - директория успешно создана").append("\n");
            }else {
                System.out.println("Что то пошло не так");
            }
        }
        for (String files : fileName) {
            File file = new File(files);
            try {
                if (file.createNewFile()) {
                    System.out.println("Успешно");
                    sb.append(file.getName()).append(" - файл успешно создан").append("\n");
                }else {
                    System.out.println("Что то пошло не так");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String txtFile = "D:/Games/temp/temp.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtFile))){
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
