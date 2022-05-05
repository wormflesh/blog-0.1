package com.wormflesh.experiment.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * @Description:
 * @Author: wormflesh
 * @Date: Created in 17:06 2022/5/4
 */
@Component
public class ConvertCsvToHtml {
    /**
     * 时间格式化
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");

    // jwt令牌的秘钥
    @Getter
    private static String FILEPATH;
    @Value("${save_path.file}")
    public void setFile(String file) {
        FILEPATH = file;
    }

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    public static String uploadFile(MultipartFile file) throws Exception {
        // 1.后半段目录：  2020/03/15
        String directory = simpleDateFormat.format(new Date());
        // 2.文件保存目录  xxxx/2020/03/15/ -->  如果目录不存在，则创建
        File dir = new File(FILEPATH + directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 3.给文件重新设置一个名字(无后缀)
        String newFileName= UUID.randomUUID().toString().replaceAll("-", "");
        // 4.创建一个新csv文件，创建一个新html文件（添加后缀）
        File newCSVFile = new File(FILEPATH + directory + newFileName + ".csv");
        File newHTMLFile = new File(FILEPATH + directory + newFileName + ".html");
        // 5.复制操作
        file.transferTo(newCSVFile);
        // 6读取文件
        ArrayList<String> stringList = readCsvByBufferedReader(FILEPATH + directory + newFileName + ".csv");
        // 转换文件
        convertFile(stringList, FILEPATH + directory + newFileName + ".html");

        // 文件目录(/images/2020/03/15/xxx.)
        String url = "/static/file/" + directory + newFileName + ".html";
        return url;
    }

    /**
     * 过滤一些特殊字符
     * @param lineIn
     * @return
     */
    public static String escapeChars(String lineIn) {
        StringBuilder sb = new StringBuilder();
        int lineLength = lineIn.length();
        for (int i = 0; i < lineLength; i++) {
            char c = lineIn.charAt(i);
            switch (c) {
                case '"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void buildRow(StringBuilder sb, String[] columns) {
        sb.append("<tr>");
        for (int i = 0; i < columns.length; i++) {
            sb.append("<th>");
            sb.append(escapeChars(columns[i]));
            sb.append("</th>");
        }
        sb.append("</tr>\n");
    }

    /**
     * BufferedReader 读取
     * @param filePath
     * @return
     */
    public static ArrayList<String> readCsvByBufferedReader(String filePath) {
        File csv = new File(filePath);
        csv.setReadable(true);
        csv.setWritable(true);
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(new FileInputStream(csv), "GBK");
            br = new BufferedReader(isr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line = "";
        ArrayList<String> records = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }


    /**
     * 转换文件
     * @param stringList
     * @throws Exception
     */
    public static void convertFile(ArrayList<String> stringList, String url) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
        sb.append("<head><meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\"/>\n");
        sb.append("<title>CSV2HTML</title>\n");
        sb.append("<style type=\"text/css\">");
        sb.append("body{background-color:#FFF;color:#000;font-family:OpenSans,sans-serif;font-size:10px;}");
        sb.append("table{border:0.2em solid #2F6FAB;border-collapse:collapse;}");
        sb.append("th{border:0.15em solid #2F6FAB;padding:0.5em;background-color:#E9E9E9;}");
        sb.append("td{border:0.1em solid #2F6FAB;padding:0.5em;background-color:#F9F9F9;}</style>");
        sb.append("</head><body><h1>CSV转换为HTML</h1>\n");
        sb.append("<table>\n");
        for (String line : stringList) {
            String[] columns = line.split(",");
            buildRow(sb, columns);
        }
        sb.append("</table></body></html>");

        // 文件写入
        try (FileWriter fileWriter = new FileWriter(url)) {
            fileWriter.append(sb);
        }
    }


}
