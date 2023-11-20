package unipar.invictus.app.config;

public class Response {

    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int BAD_REQUEST = 400;
    public static final int NOT_FOUND = 404;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public int status;
    public String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response response(int status, String message) {
        return new Response(status, message);
    }
}
