package com.agcoassignment.userservice.service;

import com.agcoassignment.userservice.entity.User;
import com.agcoassignment.userservice.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
    	Optional<User> optUser = Optional.ofNullable(user);
        log.info("user has been created successfullly {}",user);
        return userRepository.save(optUser.get());
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
    	Optional<List<User>> optionalUserList = Optional.ofNullable(userRepository.findAll());
        return optionalUserList.get();
    }

    @Override
    public User updateUser(User user) {
    	User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
    	Optional<Long> optUserId = Optional.ofNullable(userId);
        log.info("User successfully deleted! {}",optUserId.get());
        userRepository.deleteById(optUserId.get());
    }
}