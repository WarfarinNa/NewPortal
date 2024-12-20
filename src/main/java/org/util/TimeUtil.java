package org.util;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TimeUtil {

    // 私有构造方法，防止实例化工具类
    private void DateTimeUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * 获取当前时间，并格式化为指定的文本格式
     *
     * @param pattern 格式模式，如 "yyyy-MM-dd HH:mm:ss"
     * @return 格式化后的当前时间文本
     */
    public static String getCurrentDateTimeFormatted(String pattern) {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 创建日期时间格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // 将当前时间格式化为文本
        return now.format(formatter);
    }

    // 可以在这里添加其他与日期时间相关的静态方法
}

