package fmi.course.theatrethicketsystem.repository;

import fmi.course.theatrethicketsystem.model.User;

public interface UserRepository {

    /**
     * Create new user
     */
    void addUser(User u);

    /**
     * Delete user
     */
    void deleteUser(Long id);

    /**
     * Find user by id
     */
    User findById(Long id);

    /**
     * Update user information
     */
    void updateUser(User user);

}
