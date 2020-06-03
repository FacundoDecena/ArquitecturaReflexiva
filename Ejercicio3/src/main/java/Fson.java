import java.lang.reflect.Field;

public class Fson {
    // Returns the json format of o
    public static String toFson(Object o){
        StringBuilder fson = new StringBuilder("{");
        // Tomo la clase
        Class<?> c = o.getClass();
        // Y sus campos
        Field[] fields = c.getFields();
        // Para cada campo
        for (Field field : fields) {
            String fieldName = field.getName();
            // Agrego el nombre a la respuesta
            fson.append("\"").append(fieldName).append("\":");
            Class<?> typeClass = field.getType();
            // Si es un objeto compuesto hago lo mismo sobre ese objeto
            if (typeClass.getFields().length > 1) {
                try {
                    fson.append(toFson(field.get(o))).append(",");
                } catch (IllegalAccessException ignored) {
                    fson.append("\"").append("\",");
                }
            }else {
                try {
                    Object fieldValue = field.get(o);
                    fson.append("\"").append(fieldValue).append("\",");
                } catch (IllegalAccessException ignored) {
                    fson.append("\"").append("\",");
                }
            }
        }
        // Elimino la ultima coma y agrego la llave que cierra
        fson.deleteCharAt(fson.lastIndexOf(","));
        fson.append("}");
        return fson.toString();
    }

}
