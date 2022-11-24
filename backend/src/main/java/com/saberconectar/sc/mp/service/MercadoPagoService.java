package com.saberconectar.sc.mp.service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.saberconectar.sc.mp.dto.PreferenceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoPagoService {

    public ResponseEntity<Preference> preference(PreferenceDTO preferenceDTO) throws MPException, MPApiException {

        MercadoPagoConfig.setAccessToken(preferenceDTO.getAccessToken());
        // Crea un objeto de preferencia
        PreferenceClient client = new PreferenceClient();
        // Crea un ítem en la preferencia
        List<PreferenceItemRequest> items = new ArrayList<>();

        // setear los items
        for (int j = 0; j < preferenceDTO.getItems().size() ; j++) {
            PreferenceItemRequest item =
                    PreferenceItemRequest.builder()
                            .title(preferenceDTO.getItems().get(j).getTitle())
                            .quantity(preferenceDTO.getItems().get(j).getQuantity())
                            .unitPrice(preferenceDTO.getItems().get(j).getPrice())
                            .build();
            items.add(item);
        }

        /* Setear los backUrls */
        PreferenceBackUrlsRequest backUrls =
                PreferenceBackUrlsRequest.builder()
                        .success("https://localhost:4200/login")
                        .pending("https://localhost:8080/pending")
                        .failure("https://localhost:8080/failure")
                        .build();

        /* Setear los backUrls */
        PreferenceRequest request = PreferenceRequest.builder().
                items(items).
                backUrls(backUrls).
                autoReturn("approved").
                build();

        return ResponseEntity.ok(client.create(request));

    }

}
