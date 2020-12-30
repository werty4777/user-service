package com.sulluscocha.user_web.infrastructure.api;

import com.sulluscocha.types.types.RecordRequest;
import com.sulluscocha.user_application.Imp.RecordServiceImp;
import com.sulluscocha.user_domain.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class recordController {

    private final RecordServiceImp recordServiceImp;

    @Autowired
    public recordController(RecordServiceImp recordServiceImp) {
        this.recordServiceImp = recordServiceImp;
    }


    @GetMapping("")
    public ResponseEntity<RecordRequest> getRecord(@RequestHeader("Authorization") String token) {

        try {
            return new ResponseEntity<>(this.recordServiceImp.obtenerRecord(token), HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }

    @PostMapping("")
    public ResponseEntity<?> guardarRecord(@RequestHeader("Authorization") String token, @RequestBody RecordRequest recordRequest) {

        boolean status = this.recordServiceImp.guardarRecord(recordRequest);

        if (!status) {


            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
