package com.valores.controller;

import com.valores.entity.User;
import com.valores.ports.input.FetchUserInputPort;
import com.valores.ports.input.SaveUserInputPort;
import com.valores.ports.input.UpdateUserInputPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/valores")
public class UserController {

    private final SaveUserInputPort saveInputPort;

    private final UpdateUserInputPort updateUserInputPort;

    private final FetchUserInputPort fetchUserInputPort;

    public UserController(SaveUserInputPort saveInputPort, UpdateUserInputPort updateUserInputPort, FetchUserInputPort fetchUserInputPort) {
        this.saveInputPort = saveInputPort;
        this.updateUserInputPort = updateUserInputPort;
        this.fetchUserInputPort = fetchUserInputPort;
    }

    @PostMapping("/create-user")
    public String saveUser(@RequestBody User user){
        return saveInputPort.saveUser(user);
    }

    @PutMapping("/update-user")
    public String updateUser(@RequestBody User user, @RequestParam("nome") String nome) {
        return updateUserInputPort.update(user, nome);
    }

    @GetMapping("/ranking")
    public List<User> top10Ranking(){
        return fetchUserInputPort.top10Users();
    }
}
