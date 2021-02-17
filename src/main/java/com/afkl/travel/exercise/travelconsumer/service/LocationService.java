package com.afkl.travel.exercise.travelconsumer.service;

import com.afkl.travel.exercise.travelconsumer.dto.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class LocationService {

    private final String TYPE_COUNTRY = "country";
    private final String TYPE_CITY = "city";
    private final String TYPE_AIRPORT = "airport";
    private final String COUNTRY_CODE_US = "US";

    @Autowired
    private RestTemplate restTemplate;

    public void printAirportsFromUSA() {
        LocationDto[] locationDtos = getAllLocations();
        List<LocationDto> airports = new LinkedList<>();
        Set<String> cityCodeSet = new HashSet<>();

        for (LocationDto location : locationDtos) {
            if (TYPE_CITY.equals(location.getType())) {
                // Checks if the city belongs to USA
                // and puts the code of the city in a Set
                if (TYPE_COUNTRY.equals(location.getParentType()) &&
                        COUNTRY_CODE_US.equals(location.getParentCode())) {
                    cityCodeSet.add(location.getCode());
                }

            } else if (TYPE_AIRPORT.equals(location.getType())) {
                // All airports will be put in a list
                airports.add(location);
            }
        }

        // Iterates all airports looking for the ones that belong to cities of USA
        airports.stream()
                .filter(airport -> TYPE_CITY.equals(airport.getParentType())
                                && cityCodeSet.contains(airport.getParentCode()))
                .forEach(System.out::println);
    }


    private LocationDto[] getAllLocations() {
        String url = "http://localhost:8080/travel/locations";

        ResponseEntity<LocationDto[]> response =
                restTemplate.getForEntity(
                        url,
                        LocationDto[].class);
        LocationDto[] locationDtos = response.getBody();
        return locationDtos;

    }


    public void printOut() {
        String url = "http://localhost:8080/travel/locations/country/US";

        ResponseEntity<LocationDto> response =
                restTemplate.getForEntity(url, LocationDto.class);

        LocationDto locationDto = response.getBody();
        System.out.println(locationDto.getCode());
    }


}
