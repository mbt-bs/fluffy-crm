package ru.mbt_bs.fluffy_crm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mbt_bs.fluffy_crm.data.json.Work;
import ru.mbt_bs.fluffy_crm.services.WorkService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WorkController {
    private static final Logger logger = LoggerFactory.getLogger(WorkController.class);

    private WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @RequestMapping(value = "/work", method = RequestMethod.PUT)
    public ResponseEntity<Work> updateCustomer(@RequestBody Work work) {
        workService.updateWork(work);
        return work.getId() != null
                ? ResponseEntity.status(HttpStatus.OK).body(work)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
