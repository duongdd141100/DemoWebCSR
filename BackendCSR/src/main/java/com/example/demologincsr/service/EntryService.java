package com.example.demologincsr.service;

import com.example.demologincsr.entity.Entry;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EntryService {
    List<Entry> findHeader();

    List<Entry> findMenu();
}
