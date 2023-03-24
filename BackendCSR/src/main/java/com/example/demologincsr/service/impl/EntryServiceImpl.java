package com.example.demologincsr.service.impl;

import com.example.demologincsr.entity.Entry;
import com.example.demologincsr.repository.EntryRepository;
import com.example.demologincsr.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepo;

    private final String HEADER_POSITION = "header";

    private final String MENU_POSITION = "menu";

    @Override
    public List<Entry> findHeader() {
        return entryRepo.findAllByPosition(HEADER_POSITION);
    }

    @Override
    public List<Entry> findMenu() {
        return entryRepo.findAllByPosition(MENU_POSITION);
    }
}
