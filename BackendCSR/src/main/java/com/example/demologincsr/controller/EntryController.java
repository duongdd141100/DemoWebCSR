package com.example.demologincsr.controller;

import com.example.demologincsr.common.BaseResponse;
import com.example.demologincsr.entity.Entry;
import com.example.demologincsr.repository.EntryRepository;
import com.example.demologincsr.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entries")
@CrossOrigin
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/header")
    public ResponseEntity<BaseResponse<Entry>> getHeader() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(entryService.findHeader()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<BaseResponse<Entry>> getMenu() {
        try {
            return ResponseEntity.ok(BaseResponse.ok(entryService.findMenu()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BaseResponse.fail(e.getMessage()));
        }
    }
}
