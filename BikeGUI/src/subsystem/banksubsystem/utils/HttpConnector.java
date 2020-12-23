package subsystem.banksubsystem.utils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Class: provide medthod to sending request to server and get responds
 * Date: 16/12/2020
 * @author Group 10
 * @version 1.0
 */
public class HttpConnector {
    public static DateFormat DATE_FORMATER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static Logger LOGGER = Utils.getLogger(Utils.class.getName());

    /**
     * Get API
     * @param url an url + query
     * @return  a respond string
     * @throws Exception Exception for http get
     */
    public static String get(String url) throws Exception {
        // setup
        LOGGER.info("Request URL: " + url + "\n");
        URL line_api_url = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) line_api_url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
//        conn.setRequestProperty("Authorization", "Bearer " + token);
        // reading data from server
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder respone = new StringBuilder(); // using StringBuilder for the sake of memory and performance
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            respone.append(inputLine + "\n");
        }
        in.close();
        LOGGER.info("Respone Info: " + respone.substring(0, respone.length() - 1).toString());
        return respone.substring(0, respone.length() - 1).toString();
    }


    int var;

    /**
     * method allows api post (transaction...)
     * @param url url of server
     * @param data a json object
     * @return  respond data
     * @throws  IOException Exception for http post, patch
     */
    public static String post(String url, String data) throws IOException {
        allowMethods("PATCH");
        // setup
        URL line_api_url = new URL(url);
        String payload = data;
        LOGGER.info("Request Info:\nRequest URL: " + url + "\n" + "Payload Data: " + payload + "\n");
        HttpURLConnection conn = (HttpURLConnection) line_api_url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("PATCH");
        conn.setRequestProperty("Content-Type", "application/json");

        // sending data
        Writer writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        writer.write(payload);
        writer.close();

        // receiving data
        BufferedReader in;
        String inputLine;
        if (conn.getResponseCode() / 100 == 2) {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();
        LOGGER.info("Respone Info: " + response.toString());
        return response.toString();
    }

    /**
     * method allows api patch, put, ...
     * @deprecated chi hoat dong voi java nho hon 11
     * @param methods all of method possible like post, patch, ..
     */
    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");
            methodsField.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null/* static field */, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
