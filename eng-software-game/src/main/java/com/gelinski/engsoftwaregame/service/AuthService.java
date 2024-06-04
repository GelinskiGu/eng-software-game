package com.gelinski.engsoftwaregame.service;

import com.gelinski.engsoftwaregame.dto.security.AccountCredentialsDTO;
import com.gelinski.engsoftwaregame.dto.security.SignUpDTO;
import com.gelinski.engsoftwaregame.dto.security.TokenDTO;
import com.gelinski.engsoftwaregame.exception.ResourceNotFoundException;
import com.gelinski.engsoftwaregame.mapper.UserMapper;
import com.gelinski.engsoftwaregame.model.Permission;
import com.gelinski.engsoftwaregame.model.User;
import com.gelinski.engsoftwaregame.repository.PermissionRepository;
import com.gelinski.engsoftwaregame.repository.UserRepository;
import com.gelinski.engsoftwaregame.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PermissionRepository permissionRepository;

    public TokenDTO login(AccountCredentialsDTO credentialsDTO) {
        User user = userRepository.findByUsername(credentialsDTO.getUsername());

        if (user == null) {
            throw new ResourceNotFoundException("User " + credentialsDTO.getUsername() + " not found");
        }

        if (!passwordEncoder.matches(credentialsDTO.getPassword().trim(), user.getPassword())) {
            throw new RuntimeException("Incorrect password for user " + credentialsDTO.getUsername());
        }

        return jwtTokenProvider.createAccessToken(user.getIdUser(), user.getFullName(), user.getUsername(), user.getRoles());
    }

    public void register(SignUpDTO signUpDTO) {
        User user = UserMapper.INSTANCE.signUpDTOToEntity(signUpDTO);
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()).substring(8));

        Permission permission = permissionRepository.findByDescription("TEACHER");
        user.setPermissions(List.of(permission));

        userRepository.save(user);
    }
}
