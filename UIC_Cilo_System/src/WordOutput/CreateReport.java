package WordOutput;

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

/**
 * Created by ZHONG on 2016/10/23.
 */
public class CreateReport {

    public static ByteArrayInputStream getPieChartImage(int C_ID) {
        MySQLAccess DBA = new MySQLAccess();
        //创建数据集对象
        //如果要从数据库中获取数据
        //你只需把数据填写到此数据集中就OK了
        ArrayList<HashMap<String,String>> percentage = DBA.readCILOPercentageByCID(C_ID);
        ByteArrayInputStream in = null;
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("cilo1", 50);
        dataset.setValue("cilo2", 800);
        dataset.setValue("cilo3", 400);
        dataset.setValue("cilo4", 100);
        dataset.setValue("cilo5", 29);

        JFreeChart chart = ChartFactory.createPieChart3D("CILO", dataset, true, true, true);
        // 副标题
        chart.addSubtitle(new TextTitle("2016"));
        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setLabelFont(new Font("宋体", 0, 11));
        // 设置饼图是圆的（true），还是椭圆的（false）；默认为true
        pieplot.setCircular(true);
        // 没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator("{0}:({1}.{2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
        pieplot.setLabelGenerator(standarPieIG);

        PiePlot3D pieplot3d = (PiePlot3D) chart.getPlot();
        //设置开始角度
        pieplot3d.setStartAngle(120D);
        //设置方向为”顺时针方向“
        pieplot3d.setDirection(Rotation.CLOCKWISE);
        //设置透明度，0.5F为半透明，1为不透明，0为全透明
        pieplot3d.setForegroundAlpha(0.7F);
        //最后返回组成的饼图数值
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ChartUtilities.writeChartAsPNG(out, chart, 400, 300);
            in = new ByteArrayInputStream(out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return in;
    }

    private XWPFDocument doc;
    private String imgFile;

    public void CreateReportDoc() throws Exception {

        doc = new XWPFDocument();
        // 创建一个段落
        XWPFParagraph para = doc.createParagraph();
        // 设置对齐方式
        para.setAlignment(ParagraphAlignment.CENTER);

        // 一个XWPFRun代表具有相同属性的一个区域。
        XWPFRun run = para.createRun();
        // 加粗
        run.setBold(true);
        // 设置内容
        run.setText("Report of Course");
        // 设置字体大小
        run.setFontSize(20);
        // 换行
        run.addBreak();
        run.setText("CILO alignment in final exam and course-work");
        // 设置字体大小
        run.setFontSize(18);
        // 换行
        run.addBreak();

        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.CENTER);
        run = para.createRun();
        run.setBold(false);
        run.setText("--Author: ");
        run.setFontSize(10);
        run.addBreak();


        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);
        run = para.createRun();
        run.setBold(true);
        run.setText("1. Course Intended Learning Outcomes (CILOs) and alignment to Program Intended Learning Outcomes (PILOs)");
        run.setFontSize(15);
        run.addBreak();

        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);

        run = para.createRun();
        run.setBold(true);
        run.setText("1. Create Table");
        run.setFontSize(16);

        run.addBreak();

        // 生成 table
        createTable();

        // para = doc.createParagraph();
        // para.setAlignment(ParagraphAlignment.BOTH);
        //run = para.createRun();
        //run.setBold(false);
        //run.setFontSize(12);
        //run.setText(
        //      "The all-volunteer ASF develops, stewards, and incubates more than 350 Open Source projects and initiatives that cover a wide range of technologies. From Abdera to Zookeeper, if you are looking for a rewarding experience in Open Source and industry leading software, chances are you are going to find it here. Are you powered by Apache?");


        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);
        run = para.createRun();
        run.setBold(true);
        run.setText("2. Course assessment pattern");
        run.setFontSize(15);
        run.addBreak();

//        String content;
//        int a = 1;
//        content = MySQLAccess.select(a);
//        System.out.println(content);
//        para = doc.createParagraph();
//        para.setAlignment(ParagraphAlignment.BOTH);
//        run = para.createRun();
//        run.setBold(false);
//        run.setFontSize(14);
//        run.setText(content);
//        run.addBreak();

        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);
        run = para.createRun();
        run.setBold(true);
        run.setText("3. CILO alignment in examination: ");
        run.setFontSize(15);
        run.addBreak();

        ByteArrayInputStream in = getPieChartImage();
        run.addPicture(in, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(280));

        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.BOTH);
        run = para.createRun();
        run.setBold(false);
        run.setFontSize(12);
        run.setText("（i） Coverage of different CILOs in the examination and students’ achievement");


        ByteArrayInputStream in1 = getPieChartImage();
        run.addPicture(in1, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(280));
        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.BOTH);
        run = para.createRun();
        run.setBold(false);
        run.setFontSize(12);
        run.setText("（ii） Coverage of different cognitive levels in the examination and students’ achievement");


        ByteArrayInputStream in2 = getPieChartImage();
        run.addPicture(in2, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(280));

        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);
        run = para.createRun();
        run.setBold(true);
        run.setText("4. CILO alignment in course-work ");
        run.setFontSize(15);
        run.addBreak();

        ByteArrayInputStream in3 = getPieChartImage();
        run.addPicture(in3, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(280));

        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);
        run = para.createRun();
        run.setBold(true);
        run.setText("5. Overall achievement on different CILOs in the entire course ");
        run.setFontSize(15);
        run.addBreak();

        ByteArrayInputStream in4 = getPieChartImage();
        run.addPicture(in4, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(280));

        // 插入圖片
       /* String imgFile = "C:\\Users\\UIC\\Desktop\\test.png";
        FileInputStream is = new FileInputStream(imgFile);
        run.addBreak();
        run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, imgFile, Units.toEMU(400), Units.toEMU(280)); // 400x280
                                                                                                        // pixels
        is.close(); */

        OutputStream os = new FileOutputStream("C:\\Users\\ZHONG\\Desktop\\Report.docx");
        // 把doc输出到输出流
        doc.write(os);
        this.close(os);
    }

    private void createTable() {

        // 構造數據 也可以從數據庫獲取存入二維數據
        String[][] tableData = {
                //  { "No.", "CILOs","Algnment to PILOs" },
                {"1", "Acquire information using electronic means.", "PILO 2"},
                {"2", "Use appropriate IT tools to manage numerical, textual, and multimedia information for problem-solving and creative applications", "PILO 2"},
                {"3", "Explain the principles, opportunities and challenges behind the latest development of information technologies and the impact of Information Technology on human society", "PILO6"}};

        // 创建一个3行3列的表格
        XWPFTable table = doc.createTable(3, 3);
        // 获取table rows List
        List<XWPFTableRow> rows = table.getRows();
        // 表格属性
        CTTblPr tablePr = table.getCTTbl().addNewTblPr();
        // 表格宽度
        CTTblWidth width = tablePr.addNewTblW();
        width.setW(BigInteger.valueOf(8000));

        XWPFTableRow row;
        List<XWPFTableCell> cells;
        XWPFTableCell cell;

        int rowSize = rows.size();

        int cellSize;
        for (int i = 0; i < rowSize; i++) {
            row = rows.get(i);
            // 新增单元格
            // row.addNewTableCell();
            // 设置行的高度
            // row.setHeight(500);

            // 行属性
            // CTTrPr rowPr = row.getCtRow().addNewTrPr();
            // 这种方式是可以获取到新增的cell的。
            cells = row.getTableCells();
            cellSize = cells.size();
            for (int j = 0; j < cellSize; j++) {
                cell = cells.get(j);

                // 单元格属性
                CTTcPr cellPr = cell.getCTTc().addNewTcPr();
                cellPr.addNewVAlign().setVal(STVerticalJc.TOP);
                if (j == 1) {
                    // 设置宽度
                    cellPr.addNewTcW().setW(BigInteger.valueOf(5000));
                } else if (j == 2) {
                    cellPr.addNewTcW().setW(BigInteger.valueOf(2000));
                }
                cell.setText(tableData[i][j]);
            }
        }
    }

    private void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
