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

    public static Response response(String status, String message) {
        return new Response(status, message, null);
    }

    public static Response response(String status, String message, Object content) {
        return new Response(status, message, content);
    }
}
