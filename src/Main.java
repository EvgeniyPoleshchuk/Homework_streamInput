public class Main {


    public static void main(String[] args) {
        newProject project = new newProject();

        project.createDir("D:/Games/src");
        project.createDir("D:/Games/res");
        project.createDir("D:/Games/savegames");
        project.createDir("D:/Games/temp");
        project.createDir("D:/Games/src/main");
        project.createDir("D:/Games/src/test");
        project.createDir("D:/Games/res/drawables");
        project.createDir("D:/Games/res/vectors");
        project.createDir("D:/Games/res/icons");
        project.createFile("D:/Games/src/main/Main.java");
        project.createFile("D:/Games/src/main/Utils.java");
        project.createFile("D:/Games/temp/temp.txt");
        project.LogWriter("D:/Games/temp/temp.txt",false);


    }
}
