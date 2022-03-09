package Handler;

import Request.ClearRequest;
import Result.ClearResult;
import Service.ClearService;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.*;
import java.net.*;
import java.nio.file.Files;

import com.sun.net.httpserver.*;
import com.google.gson.*;
public class FileHandler implements HttpHandler {
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().toLowerCase().equals("get")) {
            String urlPath= exchange.getRequestURI().toString();
            if (urlPath.equals("/")) {
                urlPath = "/index.html";
            }
            String filePath= "web" + urlPath;
            File fileobject = new File(filePath);
            if (fileobject.exists() != true) {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                exchange.getResponseBody().close();
            }
            else {
                OutputStream respBody= exchange.getResponseBody();
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                Files.copy(fileobject.toPath(), respBody);
                exchange.getResponseBody().close();
            }
        }
    }
}
