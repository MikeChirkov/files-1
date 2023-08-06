import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final CreateFileLogger logger = new CreateFileLogger();

    public static void main(String[] args) {
        String path = "/Users/mikechirkov/Games/";

        createSrc(path);
        createRes(path);
        createSaveGame(path);
        File temp = createTemp(path);
        writeLogToFile(temp);
        System.out.println(logger.getMessage());
    }

    public static void createSrc(String pathname) {

        File src = new File(pathname + "src");
        logger.log(src, src.mkdir());

        File main = createSubDir(src, "main");

        File mainJava = createFile(main, "Main.java");
        File utilsJava = createFile(main, "Utils.java");

        File test = new File(src, "test");
        logger.log(test, test.mkdir());
    }

    public static void createRes(String pathname) {
        File res = new File(pathname + "res");
        logger.log(res, res.mkdir());

        File drawables = createSubDir(res, "drawables");
        File vectors = createSubDir(res, "vectors");
        File icons = createSubDir(res, "icons");
    }

    public static void createSaveGame(String pathname) {
        File savegames = new File(pathname + "savegames");
        logger.log(savegames, savegames.mkdir());
    }

    public static File createTemp(String pathname) {
        File temp = new File(pathname + "temp");
        logger.log(temp, temp.mkdir());
        File txt = createFile(temp, "temp.txt");
        return txt;
    }

    public static File createSubDir(File parent, String dir) {
        File subDir = new File(parent, dir);
        logger.log(subDir, subDir.mkdir());
        return subDir;
    }

    public static File createFile(File parent, String fileName) {
        File newFile = new File(parent, fileName);
        try {
            logger.log(newFile, newFile.createNewFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return newFile;
    }

    public static void writeLogToFile(File file) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(logger.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}