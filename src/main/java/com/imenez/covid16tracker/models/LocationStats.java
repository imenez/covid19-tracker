package com.imenez.covid16tracker.models;

import lombok.*;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class LocationStats {


    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;


}
