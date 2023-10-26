package org.example.project.service;

import org.example.project.service.dto.resp.UserRespDTO;

/**
 * <p>
 * IUserService
 * </p>
 *
 * @author xiaochuan
 * @since 2023/10/26 12:04
 */
public interface IUserService {
    void saveUser(String username, String password, String telephone);
    void updateUser(Integer id, String password, String telephone);
    void deleteUser(Integer id);
    UserRespDTO getUser(Integer id);
}
