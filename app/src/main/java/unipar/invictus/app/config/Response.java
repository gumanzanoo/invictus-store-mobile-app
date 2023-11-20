package unipar.invictus.app.config;

public class Response {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public String status;
    public String message;

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response response(String status, String message) {
        return new Response(status, message);
    }
}
