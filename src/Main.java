import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CreateDirAndFiles create = new CreateDirAndFiles();
        String gameDir = "D:/Games/";
        create.createDir(gameDir + "src");
        create.createDir(gameDir + "res");
        create.createDir(gameDir + "savegames");
        create.createDir(gameDir + "temp");
        create.createDir(gameDir + "src/main");
        create.createDir(gameDir + "src/test");
        create.createDir(gameDir + "res/drawables");
        create.createDir(gameDir + "res/vectors");
        create.createDir(gameDir + "res/icons");
        create.createFile(gameDir + "src/main/Main.java");
        create.createFile(gameDir + "src/main/Utils.java");
        create.createFile(gameDir + "temp/temp.txt");

        GameProgress gameProgress = new GameProgress(100, "Кирка", 5, 192);
        GameProgress gameProgress1 = new GameProgress(250, "Стальной меч", 25, 192);
        GameProgress gameProgress2 = new GameProgress(300, "Огненная булава из зуба дракона", 55,
                192);

        create.saveGame("save.dat", gameProgress);
        create.saveGame("save2.dat", gameProgress1);
        create.saveGame("save3.dat", gameProgress2);
        create.zipFiles(create.SAVEPATHLIST,"Save.zip");
        create.LogWriter(gameDir + "temp/temp.txt");
    }
}


