package com.gelinski.engsoftwaregame.service;

import com.gelinski.engsoftwaregame.dto.GroupDTO;
import com.gelinski.engsoftwaregame.mapper.GroupMapper;
import com.gelinski.engsoftwaregame.model.Group;
import com.gelinski.engsoftwaregame.model.User;
import com.gelinski.engsoftwaregame.repository.GroupRepository;
import com.gelinski.engsoftwaregame.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final UserRepository userRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Transactional
    public Group save(GroupDTO group) {
        Group entity = groupMapper.toEntity(group);
        User teacher = userRepository.findById(group.getTeacher()).orElseThrow();
        entity.setTeacher(teacher);
        return groupRepository.save(entity);
    }

    @Transactional
    public Group edit(GroupDTO group) {
        Group entity = groupRepository.findById(group.getId()).orElseThrow();
        entity.setName(group.getName());
        entity.setAcronym(group.getAcronym());

        User teacher = userRepository.findById(group.getTeacher()).orElseThrow();
        entity.setTeacher(teacher);
        return groupRepository.save(entity);
    }

    public List<Group> findByTeacher(Long teacherId) {
        return groupRepository.findByTeacher(teacherId);
    }
}
