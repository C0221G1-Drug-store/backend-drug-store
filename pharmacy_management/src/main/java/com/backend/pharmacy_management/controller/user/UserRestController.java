package com.backend.pharmacy_management.controller.user;

import com.backend.pharmacy_management.model.dto.user_role.UserDto;
import com.backend.pharmacy_management.model.dto.user_role.UserRoleDto;
import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.entity.user_role.User;
import com.backend.pharmacy_management.model.entity.user_role.UserRole;
import com.backend.pharmacy_management.model.service.user.IRoleService;
import com.backend.pharmacy_management.model.service.user.IUserRoleService;
import com.backend.pharmacy_management.model.service.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserRoleService userRoleService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<User>> findAllUser(@RequestParam Integer page,
                                                  @RequestParam Integer size,
                                                  @RequestParam String keyWord,
                                                  @RequestParam Long property
                                                  ) {
        Page<User> users = userService.findAllByProperty(PageRequest.of(page,size),keyWord,property);

        if (users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<Page<User>> findAllUser(@RequestParam Integer page,
//                                                  @RequestParam Integer size
//    ) {
//        Page<User> users = userService.findAll(PageRequest.of(page,size));
//
//        if (users.isEmpty()) {
//            return new ResponseEntity<>(users, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value= "edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setUserId(userOptional.get().getUserId());
        userService.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value= "/role")
    public ResponseEntity<Iterable<Role>> findAllUser() {
        Iterable<Role> roles = roleService.findAll();

        if (roles == null) {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value= "editUserRole/{id}")
    public ResponseEntity<Void> updateUserRole(@PathVariable Long id, @RequestBody UserRoleDto userRoleDto) {
        Optional<UserRole> userRoleOptional = userRoleService.findByIdUser(id);
        if (!userRoleOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserRole userRole = new UserRole();
        BeanUtils.copyProperties(userRoleDto,userRole);
        userRole.setId(userRoleOptional.get().getId());
        userRoleService.save(userRole);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
