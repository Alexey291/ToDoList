package main;


import main.model.Plan;
import main.model.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class PlanController {
  @Autowired
 private PlanRepository planeRepository;

  @RequestMapping(value = "/plans/", method = RequestMethod.GET)
  public Vector<Plan> getList (){
      Iterable<Plan> cases = planeRepository.findAll();
      Vector<Plan> listPlanes = new Vector<>();
      for (Plan i : cases){
          listPlanes.add(i);
      }
      return listPlanes;
  }

  @RequestMapping(value = "/plans/", method = RequestMethod.POST)
  public void makeCase (Plan cs){
      planeRepository.save(cs);
  }

  @RequestMapping(value = "/plans/{id}", method = RequestMethod.DELETE)
  public void deleteCase(@PathVariable int id){
      planeRepository.deleteById(id);
  }

  @RequestMapping(value = "/plans/", method = RequestMethod.DELETE)
  public void deleteCases(){
      planeRepository.deleteAll();
  }
  @RequestMapping(value = "/plans/{id}", method = RequestMethod.PUT)
  public void replaceCase (@PathVariable int id, Plan cs){
      planeRepository.deleteById(id);
      planeRepository.save(cs).setId(id);
  }
  @RequestMapping(value = "/plans/{id}", method = RequestMethod.GET)
  public ResponseEntity getCase (@PathVariable int id){
      Optional<Plan> optionalCase = planeRepository.findById(id);
      if (!optionalCase.isPresent()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
      return new ResponseEntity(optionalCase.get(),HttpStatus.OK);
  }
}

