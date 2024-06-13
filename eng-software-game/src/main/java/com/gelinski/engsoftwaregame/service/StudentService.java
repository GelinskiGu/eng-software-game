package com.gelinski.engsoftwaregame.service;

import com.gelinski.engsoftwaregame.dto.StudentDTO;
import com.gelinski.engsoftwaregame.mapper.StudentMapper;
import com.gelinski.engsoftwaregame.model.Group;
import com.gelinski.engsoftwaregame.model.Student;
import com.gelinski.engsoftwaregame.repository.GroupRepository;
import com.gelinski.engsoftwaregame.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GroupRepository groupRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student save(StudentDTO student) {
        Student entity = studentMapper.toEntity(student);
        Group group = groupRepository.findById(student.getGroup()).orElseThrow();
        entity.setGroup(group);
        return studentRepository.save(entity);
    }

    @Transactional
    public Student edit(StudentDTO student) {
        Student entity = studentRepository.findById(student.getId()).orElseThrow();
        entity.setName(student.getName());
        entity.setGroup(groupRepository.findById(student.getGroup()).orElseThrow());
        return studentRepository.save(entity);
    }
}
