package org.example.controller;

import org.example.model.CommReq;
import org.example.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class CommunicationController {

    private final VendorService vendorService;


    @Autowired
    public CommunicationController(VendorService vendorService) {
        this.vendorService = vendorService;
    }


    @PostMapping("/communicationRequest")
    public ResponseEntity<String> receiveCommunicationRequest(@RequestBody CommReq request) throws IOException {
        if (request.isValid()) {
            String res = vendorService.SendNotification(request);
            return ResponseEntity.ok(res);
        } else {
            return ResponseEntity.badRequest().body("Invalid communication request. Please check your request data.");
        }
    }


}
