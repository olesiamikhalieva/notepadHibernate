package com.checkData;

import com.entity.Notepad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CheckData {

    public static int checkPhone(Notepad notepad){
        Pattern p = Pattern.compile("^\\+380\\d{9}$");
        Matcher m = p.matcher(notepad.getPhone());
        if (m.matches()) {
            return 0;
        } else {
            return 1;
        }
    }
}
