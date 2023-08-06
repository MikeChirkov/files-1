import java.io.File;

public class CreateFileLogger {
    private final StringBuilder message;

    public CreateFileLogger() {
        this.message = new StringBuilder();
    }

    public String getMessage() {
        return message.toString();
    }

    public void log(File file, Boolean result) {
        if (result && file.isDirectory()) {
            message.append("Директория «").append(file.getName()).append("» создана успешно.").append("\n");
        } else if (result && file.isFile()) {
            message.append("Файл «").append(file.getName()).append("» создан успешно.").append("\n");
        } else {
            message.append("Не удалось создать файл/директорию «").append(file.getName()).append("»\n");
        }
    }
}
