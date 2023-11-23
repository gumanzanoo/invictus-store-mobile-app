package unipar.invictus.app.helpers;

public class Response {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public String status;
    public String message;

    public Object content;

    public Response(String status, String message, Object content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public boolean hasContent() {
        return content != null;
    }

    public <U> U getContent(Class<U> type) {
       if (type.isInstance(content)) {
            return type.cast(content);
        } else {
            throw new IllegalStateException("Objeto não compatível com o tipo passado por parâmetro");
        }
    }
}