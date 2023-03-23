import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static ArrayList <String> SAVEPATHLIST = new ArrayList<>();
    public static final String GAMEDIR = "D:/Games/";

    public static void main(String[] args) {
        CreateDirAndFiles create = new CreateDirAndFiles();

        create.createDir(GAMEDIR + "src");
        create.createDir(GAMEDIR + "res");
        create.createDir(GAMEDIR + "savegames");
        create.createDir(GAMEDIR + "temp");
        create.createDir(GAMEDIR + "src/main");
        create.createDir(GAMEDIR + "src/test");
        create.createDir(GAMEDIR + "res/drawables");
        create.createDir(GAMEDIR + "res/vectors");
        create.createDir(GAMEDIR + "res/icons");
        create.createFile(GAMEDIR + "src/main/Main.java");
        create.createFile(GAMEDIR + "src/main/Utils.java");
        create.createFile(GAMEDIR + "temp/temp.txt");

        GameProgress gameProgress = new GameProgress(100, "Кирка", 5, 192);
        GameProgress gameProgress1 = new GameProgress(250, "Стальной меч", 25, 192);
        GameProgress gameProgress2 = new GameProgress(300, "Огненная булава из зуба дракона", 55, 192);

        create.saveGame("save.dat", gameProgress);
        create.saveGame("save2.dat", gameProgress1);
        create.saveGame("save3.dat", gameProgress2);
        create.zipFiles(SAVEPATHLIST,"ziptest3.zip");
        create.LogWriter(GAMEDIR + "temp/temp.txt");
    }
}


