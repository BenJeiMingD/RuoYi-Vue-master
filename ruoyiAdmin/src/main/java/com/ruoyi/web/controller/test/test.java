package com.ruoyi.web.controller.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class test {

    private String a;

    @Override
    public String toString() {
        return "[\n" +
                "  {\n" +
                "    \"name\": \"Sheet1\",\n" +
                "    \"config\": {},\n" +
                "    \"index\": \"1\",\n" +
                "    \"status\": \"1\",\n" +
                "    \"order\": \"0\",\n" +
                "    \"luckysheet_select_save\": [\n" +
                "      {\n" +
                "        \"row\": [\n" +
                "          0,\n" +
                "          0\n" +
                "        ],\n" +
                "        \"column\": [\n" +
                "          4,\n" +
                "          4\n" +
                "        ],\n" +
                "        \"sheetIndex\": 1\n" +
                "      }\n" +
                "    ],\n" +
                "    \"zoomRatio\": 1,\n" +
                "    \"showGridLines\": \"1\",\n" +
                "    \"defaultColWidth\": 80,\n" +
                "    \"defaultRowHeight\": 20,\n" +
                "    \"celldata\": [\n" +
                "      {\n" +
                "        \"r\": 0,\n" +
                "        \"c\": 0,\n" +
                "        \"v\": {\n" +
                "          \"v\": \"Luckysheet\",\n" +
                "          \"ct\": {\n" +
                "            \"fa\": \"General\",\n" +
                "            \"t\": \"g\"\n" +
                "          },\n" +
                "          \"bg\": null,\n" +
                "          \"bl\": 0,\n" +
                "          \"it\": 0,\n" +
                "          \"ff\": 1,\n" +
                "          \"fs\": \"11\",\n" +
                "          \"ht\": 1,\n" +
                "          \"vt\": 1,\n" +
                "          \"m\": \"Luckysheet\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"calcChain\": []\n" +
                "  }\n" +
                "]\n" ;
    }
}
