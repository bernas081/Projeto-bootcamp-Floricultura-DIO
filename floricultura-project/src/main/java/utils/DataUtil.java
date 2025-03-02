package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    public static String formatarData(Date data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy, EEEE, HH:mm");
        return formato.format(data);
    }
}
