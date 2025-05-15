package restProject;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
public class DummyJsonRecipe {
// Fetch All Recipe
	@Test 
  public static void fetchRecipes(){
	given().when().get("https://dummyjson.com/recipes").then().statusCode(200).log().all();	
}
	
// Fetch Single Recipe
	@Test 
	  public static void fetchSingleRecipe(){
		given().when().get("https://dummyjson.com/recipes/1").then().statusCode(200).body("id",equalTo(1)).log().all();	
	}
	
// Search Recipe By Name
		@Test 
		  public static void RecipeByName(){
			given().when().get("https://dummyjson.com/recipes/search?q=chicken").then().statusCode(200).body("recipes.size()",greaterThan(0)).log().all();	
		}
		
// Add A new recipe
		@Test 
	  public static void AddRecipe(){
			JSONObject json = new JSONObject();
			json.put("name", "Paneer Butter");
			json.put("instructions", "Fry and Mix everything");
			json.put("ingredients", new JSONArray(List.of("Paneer", "Butter")));
		 given().contentType("application/json").body(json.toString()).when().post("https://dummyjson.com/recipes/add").then().statusCode(200).log().all();	
	}
	
// Update a recipe
				@Test 
			  public static void UpdateRecipe(){
					JSONObject json = new JSONObject();
					json.put("name", "Chana Masala");
				 given().contentType("application/json").body(json.toString()).when().put("https://dummyjson.com/recipes/1").then().statusCode(200).body("name",equalTo("Chana Masala")).log().all();	
		}
		
// Delete Recipe
				@Test 
			  public static void DeleteRecipes(){
				given().when().get("https://dummyjson.com/recipes/1").then().statusCode(200).log().all();	
			}
				
}
