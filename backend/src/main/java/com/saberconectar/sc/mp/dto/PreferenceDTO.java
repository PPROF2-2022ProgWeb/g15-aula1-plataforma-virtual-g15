package com.saberconectar.sc.mp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PreferenceDTO implements Serializable {
    private String accessToken;
    private List<ItemDTO> items;
}
