package com.valores.controller;

import com.valores.entity.Value;
import com.valores.ports.input.FetchValueInputPort;
import com.valores.ports.input.SaveValueInputPort;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "https://valores-front.onrender.com" })
@RestController
@RequestMapping("/valores")
public class ValoresController {

    private SaveValueInputPort saveValueInputPort;

    private FetchValueInputPort fetchValueInputPort;

    public ValoresController(SaveValueInputPort saveValueInputPort, FetchValueInputPort fetchValueInputPort) {
        this.saveValueInputPort = saveValueInputPort;
        this.fetchValueInputPort = fetchValueInputPort;
    }

    @PostMapping("/create-value")
    public String createValue(@RequestBody Value value) {
        return saveValueInputPort.saveValue(value);
    }

    @GetMapping("/get-value")
    public Value getValue(@RequestParam("nome") String nome) {
        return fetchValueInputPort.getValue(nome);
    }

}
