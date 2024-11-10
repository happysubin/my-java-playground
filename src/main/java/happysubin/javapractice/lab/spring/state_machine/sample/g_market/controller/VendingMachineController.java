package happysubin.javapractice.lab.spring.state_machine.sample.g_market.controller;

import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.ResponseModel;
import happysubin.javapractice.lab.spring.state_machine.sample.g_market.service.VendingMachineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/state-machine")
@RestController
public class VendingMachineController {

    private final VendingMachineService service;

    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    @GetMapping("/insert/nickel")
    public ResponseModel insertNickel() {
        return service.insertNickel();
    }

    @GetMapping("/insert/dime")
    public ResponseModel insertDime() {
        return service.insertDime();
    }

    @GetMapping("/insert/quarter")
    public ResponseModel insertQuarter() {
        return service.insertQuarter();
    }

    @GetMapping("/push/orange")
    public ResponseModel pushOrangeJuice() {
        return service.pushOrangeJuice();
    }

    @GetMapping("/push/apple")
    public ResponseModel pushAppleJuice() {
        return service.pushAppleJuice();
    }
}
