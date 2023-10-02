package com.weatherapp.business.city;

import com.weatherapp.business.city.dto.CityBasicInfo;
import com.weatherapp.business.city.dto.CityMeasurementData;
import com.weatherapp.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CitiesController {

    @Resource
    private CitiesService citiesService;


    @GetMapping("/all")
    @Operation(summary = "Leiab andmebaasist kõik linnad",
            description = """
                    Tagastab kõikide leitud linnade cityId ja cityName-i""")
    public List<CityBasicInfo> findAllCities() {
        return citiesService.findAllCities();
    }

    @GetMapping("")
    @Operation(summary = "Leiab andmebaasist ühe linna ilmainfo",
            description = """
                    Leiab andmebaasist cityId järgi linna ja tagastab selle linna ilmainfo""")
    public List<CityMeasurementData> findCityWeatherData(@RequestParam Integer cityId) {
        return citiesService.findCityWeatherData(cityId);
    }

    @PostMapping("")
    @Operation(summary = "Uue linna lisamine andmebaasi.",
            description = "Kontrollib cityName järgi kas linn on juba andmebaasis ja mis on tema status. " +
                    "Kui linna ei ole siis lisab uue linna")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "403", description = "Sellise nimega linn on andmebaasis juba olemas",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public void addCity(@RequestParam String cityName) {
        citiesService.addCity(cityName);
    }

    @DeleteMapping("")
    @Operation(summary = "Kustutab linna andmebaasist",
            description = """
                    Leiab andmebaasist cityId järgi linna ja muudab selle statuse active -> deleted""")
    public void deleteCity(@RequestParam Integer cityId) {
        citiesService.deleteCity(cityId);
    }


}
