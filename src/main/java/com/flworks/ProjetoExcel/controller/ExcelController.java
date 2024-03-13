package com.flworks.ProjetoExcel.controller;

import com.flworks.ProjetoExcel.service.ExcelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/uploadExcel")
    public ResponseEntity<?> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            List<Map<String, Object>> processedData = excelService.processExcelFile(file);
            return ResponseEntity.ok(processedData);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Falha ao processar o arquivo Excel.");
        }
    }
 
    @GetMapping("/excelData")
    public String getExcelData() {
        // List<Map<String, Object>> processedData = excelService.processExcelFile();
        return "OK";
    }
    // Remoção do endpoint getExcelData é apropriada se todos os dados necessários
    // são retornados imediatamente após o processamento/upload do arquivo.
}
