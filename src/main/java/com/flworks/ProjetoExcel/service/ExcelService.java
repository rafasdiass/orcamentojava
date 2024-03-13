package com.flworks.ProjetoExcel.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    public List<Map<String, Object>> processExcelFile(MultipartFile file) throws IOException {
        List<Map<String, Object>> processedData = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            List<String> headers = new ArrayList<>();
            sheet.getRow(0).forEach(cell -> headers.add(cell.getStringCellValue()));

            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                Map<String, Object> rowData = new HashMap<>();
                for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData.put(headers.get(cellNum), getCellValue(cell));
                }
                processedData.add(rowData);
            }
        }

        return processedData;
    }

    private Object getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        Object value = null;
        switch (cell.getCellType()) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                value = DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue() : cell.getNumericCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case FORMULA:
                // Para simplificar, vamos tratar a fórmula como uma string
                value = cell.getCellFormula();
                break;
            case BLANK:
                value = "";
                break;
            default:
                value = "Unknown Cell Type";
        }
        return value;
    }
    
}
