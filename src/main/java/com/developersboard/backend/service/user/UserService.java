package com.developersboard.backend.service.user;

import com.developersboard.backend.persistent.domain.user.User;
import com.developersboard.enums.RoleType;
import com.developersboard.enums.UserHistoryType;
import com.developersboard.shared.dto.UserDto;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This UserService interface is the contract for the user service operations.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

  /**
   * Saves or updates the user with the user instance given.
   *
   * @param user the user with updated information
   * @param isUpdate if the operation is an update
   * @return the updated user.
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto saveOrUpdate(User user, boolean isUpdate);

  /**
   * Create the userDto with the userDto instance given.
   *
   * @param userDto the userDto with updated information
   * @return the updated userDto.
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto createUser(final UserDto userDto);

  /**
   * Create the userDto with the userDto instance given.
   *
   * @param userDto the userDto with updated information
   * @param roleTypes the roleTypes.
   * @return the updated userDto.
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto createUser(final UserDto userDto, final Set<RoleType> roleTypes);

  /**
   * Returns a user for the given id or null if a user could not be found.
   *
   * @param id The id associated to the user to find
   * @return a user for the given email or null if a user could not be found.
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto findById(Long id);

  /**
   * Returns a user for the given publicId or null if a user could not be found.
   *
   * @param publicId the publicId
   * @return the userDto
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto findByPublicId(String publicId);

  /**
   * Returns a user for the given username or null if a user could not be found.
   *
   * @param username The username associated to the user to find
   * @return a user for the given username or null if a user could not be found
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto findByUsername(String username);

  /**
   * Returns a user for the given email or null if a user could not be found.
   *
   * @param email The email associated to the user to find
   * @return a user for the given email or null if a user could not be found
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto findByEmail(String email);

  /**
   * Returns a userDetails for the given username or null if a user could not be found.
   *
   * @param username The username associated to the user to find
   * @return a user for the given username or null if a user could not be found
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDetails getUserDetails(String username);

  /**
   * Checks if the username already exists.
   *
   * @param username the username
   * @return <code>true</code> if username exists
   */
  boolean existsByUsername(String username);

  /**
   * Checks if the username or email already exists and enabled.
   *
   * @param username the username
   * @param email the email
   * @return <code>true</code> if username exists
   */
  boolean existsByUsernameOrEmailAndEnabled(String username, String email);

  /**
   * Validates the publicId exists and the verification token belongs to the user with the publicId.
   *
   * @param publicId the publicId
   * @param verification the verification
   * @return if verification is valid
   */
  boolean isVerificationTokenValid(String publicId, String verification);

  /**
   * Update the user with the user instance given and the update type for record.
   *
   * @param userDto The user with updated information
   * @param userHistoryType the history type to be recorded
   * @return the updated user
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto updateUser(UserDto userDto, UserHistoryType userHistoryType);

  /**
   * Assigns and saves the reset or verification token with the user object.
   *
   * @param userDto the userDto
   * @param verificationToken the verificationToken
   */
  void saveVerificationToken(UserDto userDto, String verificationToken);

  /**
   * Enables the user by setting the enabled state to true.
   *
   * @param publicId The user publicId
   * @return the updated user
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto enableUser(String publicId);

  /**
   * Disables the user by setting the enabled state to false.
   *
   * @param publicId The user publicId
   * @return the updated user
   * @throws NullPointerException in case the given entity is {@literal null}
   */
  UserDto disableUser(String publicId);
}
