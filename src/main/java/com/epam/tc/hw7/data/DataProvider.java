package com.epam.tc.hw7.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class DataProvider {

    private static final String TEST_DATA_JSON = "src/test/resources/com/epam/tc/hw7/JDI_ex8_metalsColorsDataSet.json";

    public Object[][] getData() throws FileNotFoundException {
        return testData().stream().map(data -> new MetalsAndColorsData[] {data}).toArray(Object[][]::new);
    }

    public static List<MetalsAndColorsData> testData() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonParser().parse(new FileReader(TEST_DATA_JSON)).getAsJsonObject();

        return jsonObject.keySet().stream().map(key -> gson.fromJson(jsonObject.get(key), MetalsAndColorsData.class))
                         .collect(Collectors.toList());
    }
}
