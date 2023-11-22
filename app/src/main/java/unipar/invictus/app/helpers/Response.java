package unipar.invictus.app.helpers;

public class Response<T> {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public String status;
    public String message;

    public T content;

    public Response(String status, String message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public static <T> Response<T> response(String status, String message) {
        return new Response<>(status, message, null);
    }

    public static <T> Response<T> response(String status, String message, T content) {
        return new Response<>(status, message, content);
    }

    public static Response<Void> success(String message) {
        return new Response<>(SUCCESS, message, null);
    }

    public static Response<Void> error(String message) {
        return new Response<>(ERROR, message, null);
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public <U> U getContent(Class<U> type) {
        if (type.isInstance(content)) {
            return type.cast(content);
        } else {
            throw new IllegalStateException("Objeto não compatível com o tipo passado por parâmetro");
        }
    }
}