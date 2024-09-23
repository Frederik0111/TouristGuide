package Tourism.controller;

import Tourism.repository.TouristRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("attractions")
public class TouristController {

    // GET /attractions - Returns all tourist attractions
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<String>> getAllAttractions() {
        return new ResponseEntity<>(TouristRepository.attractions, HttpStatus.OK);
    }

    // GET /attractions/{name} - Get a specific attraction by its name
    @GetMapping("/{name}")
    @ResponseBody
    public ResponseEntity<String> getAttractionByName(@PathVariable("name") String name) {
        Optional<String> attraction = TouristRepository.attractions.stream().filter(a -> a.equalsIgnoreCase(name)).findFirst();
        if (attraction.isPresent()) {
            return new ResponseEntity<>(attraction.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Attraction not found", HttpStatus.NOT_FOUND);
        }
    }

    // GET /attractions/{name}/tags

    // GET /attractions/add

    // POST /attractions/save - save a new tourist attraction
    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity<String> addAttraction(@RequestParam String name) {
        if (TouristRepository.attractions.contains(name)) {
            return new ResponseEntity<>("Attraction already exists", HttpStatus.CONFLICT);
        }
        TouristRepository.attractions.add(name);
        return new ResponseEntity<>("Attraction added successfully", HttpStatus.CREATED);
    }

    // GET attractions/{name}/edit

    // POST /attractions/update - Update an existing tourist attraction
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateAttraction(@RequestParam String oldName, @RequestParam String newName) {
        int index = TouristRepository.attractions.indexOf(oldName);
        if (index != -1) {
            TouristRepository.attractions.set(index, newName);
            return new ResponseEntity<>("Attraction updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Attraction not found", HttpStatus.NOT_FOUND);
        }
    }

    // POST /attractions/delete/{name} - Delete an attraction by its name
    @PostMapping("/delete/{name}")
    @ResponseBody
    public ResponseEntity<String> deleteAttraction(@PathVariable("name") String name) {
        boolean removed = TouristRepository.attractions.removeIf(attraction -> attraction.equalsIgnoreCase(name));
        if (removed) {
            return new ResponseEntity<>("Attraction deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Attraction not found", HttpStatus.NOT_FOUND);
        }
    }
}
