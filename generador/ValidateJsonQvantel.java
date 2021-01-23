package co.com.tigo.modelo;

import co.com.tigo.modelo.IncompleteDataDTO;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jsarria
 */
public class ValidateJsonQvantel {

    private static final String TYPE_MOBILE = "mobile";
    private static final String TYPE_FIJO = "fijo";

    public static Object cleanMedia(String text, String key) throws Exception {

        Object value = "";

        try {

            JSONObject json = new JSONObject(text);
            JSONArray jsonArray = new JSONArray(cleanMedia(jsonGet(text, key).toString().toString()).toString());

            json.put(key, jsonArray);

            value = json.toString();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return value;
    }

    public static Object cleanMedia(String text) throws Exception {

        Object value = "";

        try {
            JSONArray newArray = new JSONArray();
            JSONArray array = new JSONArray(text);

            for (int i = array.length() - 1; i >= 0; i--) {
                Object role = jsonGet(array.get(i).toString(), "role");
                if (role.equals("primary")) {
                    Object type = jsonGet(array.get(i).toString(), "medium.number-type");
                    if (type == null) {
                        newArray.put(array.get(i));
                    } else if (type.toString().equalsIgnoreCase(TYPE_MOBILE)
                            || type.toString().equalsIgnoreCase(TYPE_FIJO)) {
                        newArray.put(array.get(i));
                    }
                }
            }

            value = newArray.toString();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return value;
    }

    public static Object arrayGet(String text, String key) throws Exception {

        Object value = null;

        try {
            JSONArray array = new JSONArray(text);

            for (int i = 0; i < array.length(); i++) {
                Object item = jsonGet(array.get(i).toString(), key);
                if (item != null) {
                    value = item;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error " + e.getMessage());
        }
        return value;
    }

    public static Object jsonGet(String text, String key) throws Exception {
        try {
            if (key.contains(".")) {

                text = valueGet(text, key.substring(0, key.indexOf("."))).toString();
                key = key.substring(key.indexOf(".") + 1);

                if (text.charAt(0) == '[') {
                    return arrayGet(text, key);
                } else {
                    return jsonGet(text, key);
                }
            }
            return valueGet(text, key);
        } catch (Exception e) {
            return null;
        }
    }

    private static Object valueGet(String text, String key) throws Exception {

        Object value = null;
        try {
            JSONObject json = new JSONObject(text);

            if (json.has(key)) {
                value = json.get(key);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error " + e.getMessage());
        }
        return value;
    }

    private static String dataFunction(String funcion) {
        return "setData" + funcion;
    }

    private static String foundFunction(String funcion) {
        return "setFound" + funcion;
    }

    public static void executeMethod(Object value, String funcion, IncompleteDataDTO incompleteDataDTO)
            throws Exception {

        try {
            Method[] metodos = incompleteDataDTO.getClass().getMethods();
            for (Method metodo : metodos) {
                if (metodo.getName().equalsIgnoreCase(dataFunction(funcion))) {
                    Method method = incompleteDataDTO.getClass().getMethod(dataFunction(funcion), String.class);
                    method.invoke(incompleteDataDTO, value != null ? value.toString() : "");
                } else if (metodo.getName().equalsIgnoreCase(foundFunction(funcion))) {
                    Method method = incompleteDataDTO.getClass().getMethod(foundFunction(funcion), Boolean.TYPE);
                    method.invoke(incompleteDataDTO, (value != null));
                }
            }
        } catch (Exception ex) {
            throw new Exception("Error ejecuntado metodo " + funcion, ex);
        }
    }

}
