public class Main extends CreateDirAndFiles {
    public static void main(String[] args) {
        String gameDir = "D:/Games/";
        createDir(gameDir + "src");
        createDir(gameDir + "res");
        createDir(gameDir + "savegames");
        createDir(gameDir + "temp");
        createDir(gameDir + "src/main");
        createDir(gameDir + "src/test");
        createDir(gameDir + "res/drawables");
        createDir(gameDir + "res/vectors");
        createDir(gameDir + "res/icons");
        createFile(gameDir + "src/main/Main.java");
        createFile(gameDir + "src/main/Utils.java");
        createFile(gameDir + "temp/temp.txt");

        GameProgress gameProgress = new GameProgress(100, "Кирка", 5, 102);
        GameProgress gameProgress1 = new GameProgress(250, "Стальной меч", 25, 132);
        GameProgress gameProgress2 = new GameProgress(300, "Огненная булава из зуба дракона", 55,
                205);

        saveGame("save.dat", gameProgress);
        saveGame("save2.dat", gameProgress1);
        saveGame("save3.dat", gameProgress2);
        zipFiles(SAVEPATHLIST, "allSaves.zip");
        openZip(SAVE + "allSaves.zip", SAVE);
        System.out.println(openProgress(SAVE + "save.dat"));
        LogWriter(gameDir + "temp/temp.txt");
    }
}


