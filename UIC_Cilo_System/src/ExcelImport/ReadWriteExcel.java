package ExcelImport;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;

import ExcelImport.MySQLAccess;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;


public class ReadWriteExcel {

    private static MySQLAccess mySQLAccess;
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";


    public static Workbook getWorkbok(InputStream in, File file) throws IOException {
        Workbook wb = null;
        if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }


    public static void checkExcelVaild(File file) throws Exception {
        if (!file.exists()) {
            throw new Exception("File Not Exisits");
        }
        if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
            throw new Exception("File not supported");
        }
    }


    @SuppressWarnings("finally")
    public static JSONArray readExcel(String path, String name) throws Exception {
        String sqlfile =path+ "//" + name.substring(0,name.lastIndexOf(".")) +".txt";
        System.out.println(sqlfile);

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(sqlfile)));
        String filename = path + "//" + name;
        JSONArray array =null;
        try {
            //Initialize a file object
            File excelFile = new File(filename);
            //File stream
            FileInputStream is = new FileInputStream(excelFile);
            checkExcelVaild(excelFile);
            Workbook workbook = getWorkbok(is, excelFile);
            //Count number of sheets.
            int sheetCount = workbook.getNumberOfSheets();
            //Foreach the first Sheet
            Sheet sheet = workbook.getSheetAt(0);
            Row row;
            Cell cell1;
            int rows = sheet.getLastRowNum();
            // Initialize a JSON array
            array = new JSONArray();
            //Saving content of excel sheet.
            String[] tag = new String[20];
            int tagNum =0;
            JSONObject jsonObj = null;
            System.out.println(rows);
            for (int icount = 0; icount <= rows; icount++) {

                jsonObj = new JSONObject();

                row = sheet.getRow(icount);
                int line = row.getPhysicalNumberOfCells();
                // System.out.println(line);

                for (int j = 0; j < line; j++) {
                    cell1 = row.getCell(j);
                    if (icount == 0) {
                        tagNum = line;
                        tag[j] = cell1.toString();
                    } else {

                        jsonObj.put(tag[j], cell1.toString());
                    }

                }
                if (icount != 0) {
                    array.put(jsonObj);
                }


            }

            String tableName="Score";
            writeSql(tag,array,bw,tagNum,tableName);

            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.close();
            return array;
        }
    }

    public void init() throws ServletException {
        mySQLAccess = new MySQLAccess();
    }

    private static void writeSql(String[] tag, JSONArray array, BufferedWriter bw, int tagNum,String tableName) {
        // TODO Auto-generated method stub
        String sql = "";
        sql = "INSERT INTO `" + tableName + "` ( ";
        for(int i = 0;i<tagNum;i++){
            if(i != tagNum-1){
                sql += "`"+tag[i]+"`" +", ";
            }else{
                sql += "`"+tag[i]+"`" +" ";
            }

        }
        sql += ") VALUES";
        JSONObject jsonObj = null;
        for(int i=0;i<array.length();i++){
            jsonObj = (JSONObject) array.get(i);
            for(int j=0;j<tagNum;j++){
                if(j==0){
                    sql += " ( ";
                    sql += "'" +jsonObj.get(tag[j])+"'" + " ,";
                }else if(j == tagNum-1){
                    sql += "'" +jsonObj.get(tag[j])+"'" +" )";
                }else{
                    sql += "'" +jsonObj.get(tag[j])+"'" +" ,";
                }
            }
            if(i != array.length()-1){
                sql += " ,";
            }else{
                sql += " ";
            }
        }

        System.out.print(sql);
        MySQLAccess.uploadExcel(sql);
        try {
            bw.write(sql);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Object getServletContext() {
        // TODO Auto-generated method stub
        return null;
    }


}

