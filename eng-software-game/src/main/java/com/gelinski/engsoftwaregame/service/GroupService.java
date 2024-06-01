package com.gelinski.engsoftwaregame.service;

import com.gelinski.engsoftwaregame.model.Group;
import com.gelinski.engsoftwaregame.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupService {
    private final GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
