package com.example.demologincsr.service.impl;

import com.example.demologincsr.entity.Entry;
import com.example.demologincsr.entity.User;
import com.example.demologincsr.repository.EntryRepository;
import com.example.demologincsr.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepo;

    private final String HEADER_POSITION = "header";

    private final String MENU_POSITION = "menu";

    @Override
    public List<Entry> findHeader(User user) {
        return entryRepo.findAllByPosition(HEADER_POSITION)
                .stream().filter(entry -> Arrays.asList(entry.getRoleId().split(",")).contains(user.getRoles()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Entry> findMenu() {
        return entryRepo.findAllByPosition(MENU_POSITION);
    }
}
