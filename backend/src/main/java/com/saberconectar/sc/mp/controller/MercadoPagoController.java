package com.saberconectar.sc.mp.controller;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.saberconectar.sc.mp.dto.PreferenceDTO;
import com.saberconectar.sc.mp.service.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/reference")
@CrossOrigin
public class MercadoPagoController {

    @Autowired
    MercadoPagoService mercadoPagoService;

    @PostMapping("/new")
    public ResponseEntity<Preference> createPreference(@RequestBody PreferenceDTO preferenceDTO)
            throws MPException, MPApiException {
        return mercadoPagoService.preference(preferenceDTO);
    }

    @GetMapping("/success")
    public void compra(HttpServletResponse resp) throws IOException {
        /*CompraDTO compra = new CompraDTO();
        compra.setStatus(collectionStatus);
        compra.setPreferenceId(preferenceId);
        compra.setPaymentId(paymentId);
        System.out.println(compra.toString());*/
        resp.sendRedirect("http://localhost:4200");
    }
}
