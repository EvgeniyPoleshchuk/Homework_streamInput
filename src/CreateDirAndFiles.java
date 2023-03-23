import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class CreateDirAndFiles {

    public static StringBuilder SB = new StringBuilder();
    public static final String SUCCESSFULLY = "Уcпешно создан!";
    public static final String OPS = "Такой Файл или Папка уже существует! ";
    public static final String SAVE = "D:/Games/savegames/";
    public ArrayList <String> SAVEPATHLIST = new ArrayList<>();

    public File createDir(String dir) {
        File file = new File(dir);
        if (file.mkdir()) {
            SB.append(file.getName()).append(" - директория успешно создана\n");
            System.out.println(file.getName() + " - " + SUCCESSFULLY);
        } else {
            System.err.println(file.getName() + " - " + OPS);
        }
        return file;
    }

    public File createFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                SB.append(file.getName()).append(" - файл успешно создан\n");
                System.out.println(file.getName() + " - " + SUCCESSFULLY);
            } else {
                System.err.println(file.getName() + " - " + OPS);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void delete(String file) {
        try {
            Files.delete(Path.of(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void LogWriter(String file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(SB.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGame(String name, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(SAVE + name);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
            oos.flush();
            SAVEPATHLIST.add(name);
            SB.append(name).append("- сохранение успешно создано\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void zipFiles(ArrayList<String> list, String zipName) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(SAVE + zipName))) {
            for (String s : list) {
                FileInputStream fis = new FileInputStream(SAVE + s);
                zos.putNextEntry(new ZipEntry(s));
                byte[] buffer = new byte[fis.available()];
                int a;
                if ((a = fis.read(buffer)) != -1) {
                    zos.write(buffer,0,a);
                    SB.append(s).append(" - файл успешно записан в архив\n");
                } else {
                    SB.append(s).append(" - ошибка записи\n");
                }
                fis.close();
                zos.closeEntry();
                Files.delete(Path.of(SAVE + s));
                SB.append(s).append(" - файл успешно удален\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

