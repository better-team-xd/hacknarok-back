package pl.teamxd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.teamxd.repository.RecipeRepository;
import pl.teamxd.service.IngredientService;
import pl.teamxd.service.RecipeService;

@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<Object> getIngredients(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ingredientService.getIngredients());
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.toString());
        }
    }
}
