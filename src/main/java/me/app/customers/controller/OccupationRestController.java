package me.app.customers.controller;

import me.app.customers.domain.model.Occupation;
import me.app.customers.service.impl.OccupationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("occupation")
public class OccupationRestController {

    @Autowired
    private OccupationServiceImpl occupationService;

    @GetMapping
    public ResponseEntity<Iterable<Occupation>> getAll(){
        return ResponseEntity.ok(occupationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Occupation> findById(@PathVariable Long id){
        return ResponseEntity.ok(occupationService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Occupation> save(@RequestBody Occupation occupationToSave){
        occupationService.create(occupationToSave);
        return ResponseEntity.ok(occupationToSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Occupation> update(@PathVariable Long id, @RequestBody Occupation occupation){
        occupationService.update(id, occupation);
        return ResponseEntity.ok(occupation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        occupationService.delete(id);
        return ResponseEntity.ok().build();
    }

}
