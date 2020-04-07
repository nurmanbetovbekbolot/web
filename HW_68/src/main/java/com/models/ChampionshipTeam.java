package com.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ChampionshipTeam {
    String name;
    String country;
    String sportType;
}
