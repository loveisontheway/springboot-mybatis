package com.liotw.springboot.mybatis.utils;

import com.liotw.springboot.mybatis.core.ExcelSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Excel导入工具
 *
 * @author jiangjialiang on 2017-09-12
 * @version 1.1.0
 */
public class ExcelImportUtil {
    private static Logger logger = LoggerFactory.getLogger(ExcelImportUtil.class);

    /**
     * 从Workbook导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param workbook
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, Workbook workbook) {
        try {
            // sheet
            ExcelSheet excelSheet = sheetClass.getAnnotation(ExcelSheet.class);
            String sheetName = (excelSheet!=null && excelSheet.name()!=null && excelSheet.name().trim().length()>0)?excelSheet.name().trim():sheetClass.getSimpleName();

            // sheet field
            List<Field> fields = new ArrayList<Field>();
            if (sheetClass.getDeclaredFields()!=null && sheetClass.getDeclaredFields().length>0) {
                for (Field field: sheetClass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    fields.add(field);
                }
            }

            if (fields==null || fields.size()==0) {
                throw new RuntimeException(">>>>>>>>>>> xxl-excel error, data field can not be empty.");
            }

            // sheet data
            Sheet sheet = workbook.getSheet(sheetName);

            Iterator<Row> sheetIterator = sheet.rowIterator();
            int rowIndex = 0;
            List<Object> dataList = new ArrayList<Object>();
            while (sheetIterator.hasNext()) {
                Row rowX = sheetIterator.next();
                if (rowIndex > 0) {
                    Object rowObj = sheetClass.newInstance();
                    for (int i = 0; i < fields.size(); i++) {
                        Field field = fields.get(i);
                        /** Cannot get a STRING value from a NUMERIC cell: 不能从数字单元获取字符串值 (解决) */
                        rowX.getCell(i).setCellType(CellType.STRING);
                        String fieldValueStr = rowX.getCell(i).getStringCellValue();

                        Object fieldValue = FieldReflectionUtil.parseValue(field, fieldValueStr);

                        field.setAccessible(true);
                        field.set(rowObj, fieldValue);
                    }
                    dataList.add(rowObj);
                }
                rowIndex++;
            }
            return dataList;
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param excelFile
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, File excelFile) {
        try {
            Workbook workbook = WorkbookFactory.create(excelFile);
            List<Object> dataList = importExcel(sheetClass, workbook);
            return dataList;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 从文件路径导入Excel文件，并封装成对象
     *
     * @param sheetClass
     * @param filePath
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, String filePath) {
        File excelFile = new File(filePath);
        List<Object> dataList = importExcel(sheetClass, excelFile);
        return dataList;
    }

    /**
     * 导入Excel数据流，并封装成对象
     *
     * @param sheetClass
     * @param inputStream
     * @return
     */
    public static List<Object> importExcel(Class<?> sheetClass, InputStream inputStream) {
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            List<Object> dataList = importExcel(sheetClass, workbook);
            return dataList;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
