package com.example.demologincsr.service;

import com.example.demologincsr.entity.Entry;
import com.example.demologincsr.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EntryService {
    List<Entry> findHeader(User user);

    List<Entry> findMenu();
}
