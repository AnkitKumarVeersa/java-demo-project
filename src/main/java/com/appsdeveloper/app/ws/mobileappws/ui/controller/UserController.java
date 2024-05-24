package com.appsdeveloper.app.ws.mobileappws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.app.ws.exceptions.UserServiceException;
import com.appsdeveloper.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloper.app.ws.mobileappws.ui.model.response.ErrorMessages;
import com.appsdeveloper.app.ws.mobileappws.ui.model.response.OperationStatusModel;
import com.appsdeveloper.app.ws.mobileappws.ui.model.response.UserRest;
import com.appsdeveloper.app.ws.service.UserService;
import com.appsdeveloper.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("users")  //http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id)
    {
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUSerId(id);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    @PostMapping
    public UserRest CreateUser(@RequestBody UserDetailsRequestModel userDetails) throws UserServiceException
    {
        UserRest returnValue = new UserRest();
        if (userDetails.getFirstName() == null || userDetails.getFirstName().isEmpty() ) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createdUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;
    }

    @PutMapping(path="/{id}")
    public UserRest UpdateUser(@RequestBody UserDetailsRequestModel userDetails, @PathVariable String id)
    {
        UserRest returnValue = new UserRest();
        if (userDetails.getFirstName() == null || userDetails.getFirstName().isEmpty() ) throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto updatedUser = userService.updateUser(id, userDto);
        BeanUtils.copyProperties(updatedUser, returnValue);
        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public OperationStatusModel deleteUser(@PathVariable String id)
    {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName("DELETE");
        userService.deleteUser(id);
        returnValue.setOperationResult("success");
        return returnValue;
    }
}
