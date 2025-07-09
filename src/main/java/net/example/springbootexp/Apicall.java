package net.example.springbootexp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")

public class Apicall { 

	 @Autowired
	    private StudentRepository studentRepository;

	    @GetMapping
	    public List<Student> getAll() {
	        return studentRepository.findAll();
	    }

	    @PostMapping
	    public Student create(@RequestBody Student student) {
	        return studentRepository.save(student);
	    }

	    @PutMapping("/{id}") 
	    public Student update(@PathVariable int id, @RequestBody Student s) {
	        Student existing = studentRepository.findById(id).orElseThrow();
	        existing.setName(s.getName());
	        existing.setMark(s.getMark());
	        return studentRepository.save(existing);
	    }

	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable int id) {
	        studentRepository.deleteById(id);
	        return "Deleted!";
	    }
	}
