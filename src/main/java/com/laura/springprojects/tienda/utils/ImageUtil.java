package com.laura.springprojects.tienda.utils;

import java.util.Base64;

public class ImageUtil {
    public static String getImgData(byte[] foto) {
        if(foto != null) {
            return Base64.getMimeEncoder().encodeToString(foto);
        } else {
            return null;
        }
    }
}
