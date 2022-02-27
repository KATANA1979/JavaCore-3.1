import java.io.*;

public class Main {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        File sourceDir = new File("D:\\\\Games");

        File src = mkdir(sourceDir.getPath() + "\\src");
        if (src != null) {
            File main = mkdir(src.getPath() + "\\main");
            if (main != null) {
                mkfile(main.getPath() + "\\Main.java");
                mkfile(main.getPath() + "\\Utils.java");
            }
            mkdir(src.getPath() + "\\test");
        }

        File res = mkdir(sourceDir.getPath() + "\\res");
        if (res != null) {
            mkdir(res.getPath() + "\\drawables");
            mkdir(res.getPath() + "\\vectors");
            mkdir(res.getPath() + "\\icons");
        }

        mkdir(sourceDir.getPath() + "\\savegames");

        File temp = mkdir(sourceDir.getPath() + "\\temp");
        if (temp != null) {
            try (FileWriter log = new FileWriter(temp.getPath() + "\\temp.txt", false)) {
                result.append("Лог действий записан в файл: temp.txt");
                log.write(result.toString());
                log.flush();
                System.out.println("Лог действий записан в файл: " + temp.getPath() + "\\temp.txt");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("\n\n" + result.toString());
            }
        } else {
            System.out.println(result.toString());
        }
    }

    public static File mkdir(String path) {
        File dir = new File(path);

        if (!dir.mkdir()) {
            result.append("Папка: ").append(path).append("  >> ошибка создания !").append("\n");
            return null;
        }

        result.append("Папка: ").append(path).append("  >> успешно создана").append("\n");
        return dir;
    }

    public static File mkfile(String path) {
        File file = new File(path);
        Boolean resultCreate = false;
        String error = "";

        try {
            resultCreate = file.createNewFile();
        } catch (IOException ex) {
            error = ex.getMessage();
        }

        if (!resultCreate) {
            result.append("Файл: ").append(path).append(". ").append(error).append("  >> ошибка создания !").append("\n");
            return null;
        }

        result.append("Файл: ").append(path).append("  >> успешно создан").append("\n");
        return file;
    }
}
