package com.gbsb.tripmate.dto;

import lombok.Getter;

@Getter
public class JwtAuthenticationResponse {
    private final String accessToken;
    private final String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
