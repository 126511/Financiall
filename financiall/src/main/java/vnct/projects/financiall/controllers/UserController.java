package vnct.projects.financiall.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vnct.projects.financiall.api.UsersApi;
import vnct.projects.financiall.entities.User;
import vnct.projects.financiall.execeptions.UserNotFoundException;
import vnct.projects.financiall.model.UserDTO;
import vnct.projects.financiall.model.UserObject;
import vnct.projects.financiall.services.UserService;

@RestController
public class UserController implements UsersApi {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Void> usersDelete(Integer id) {

        try {

            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UserObject> usersGet(Integer id) {

        try {

            User user = userService.getUser(id);
            return new ResponseEntity<>(user.toUserObject(), HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UserObject> usersPost(UserDTO userDTO) {

        try {

            User user = userService.addUser(userDTO);
            return new ResponseEntity<>(user.toUserObject(), HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<UserObject> usersPut(Integer id, UserDTO userDTO) {

        try {
            User details = User.fromUserDto(userDTO);
            details.setId(id);

            User user = userService.updateUser(details);
            return new ResponseEntity<>(user.toUserObject(), HttpStatus.OK);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
