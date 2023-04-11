package org.digis.codechallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {
    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/record")
    public List<Record> index(){
        return recordRepository.findAll();
    }

    @GetMapping("/record/{id}")
    public Record show(@PathVariable String id){
        int recordId = Integer.parseInt(id);
        return recordRepository.findOne(recordId);
    }

    @PostMapping("/record")
    public Record create(@RequestBody Map<String, String> body){
        String fullname = body.get("fullname");
        String dateOfBirth = body.get("dateOfBirth");
        String gender = body.get("gender");
        return recordRepository.save(new Record(fullname,dateOfBirth,gender));
    }

    @PutMapping("/record/{id}")
    public Record update(@PathVariable String id, @RequestBody Map<String, String> body){
        int recordId = Integer.parseInt(id);
        Record record = recordRepository.findOne(recordId);
        record.setFullName(body.get("fullname"));
        record.setDateOfBirth(body.get("dateOfBirth"));
        record.setGender(body.get("gender"));
        return recordRepository.save(record);
    }

}
