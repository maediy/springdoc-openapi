/*
 *
 *  * Copyright 2019-2020 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package test.org.springdoc.api.app68.api.pet;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import test.org.springdoc.api.app68.CustomizedOperation;
import test.org.springdoc.api.app68.model.ModelApiResponse;
import test.org.springdoc.api.app68.model.Pet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@SecurityScheme(name = "petstore_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(implicit = @OAuthFlow(authorizationUrl = "http://petstore.swagger.io/oauth/dialog", scopes = {
		@OAuthScope(name = "write:pets", description = "modify pets in your account"),
		@OAuthScope(name = "read:pets", description = "read your pets") })))
@Tag(name = "pet", description = "the pet API")
public interface PetApi {

	default PetApiDelegate getDelegate() {
		return new PetApiDelegate() {
		};
	}

	@Operation(summary = "Add a new pet to the store", description = "", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = { @ApiResponse(responseCode = "405", description = "Invalid input") })
	@PostMapping(value = "/pet", consumes = { "application/json", "application/xml" })
	@CustomizedOperation
	default void addPet(
			@Parameter(description = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody Pet pet) {
		// return getDelegate().addPet(pet);
	}

	@Operation(summary = "Deletes a pet", description = "", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
			@ApiResponse(responseCode = "404", description = "Pet not found") })
	@DeleteMapping(value = "/pet/{petId}")
	@CustomizedOperation
	default ResponseEntity<Void> deletePet(
			@Parameter(description = "Pet id to delete", required = true) @PathVariable("petId") Long petId,
			@Parameter(description = "") @RequestHeader(value = "api_key", required = false) String apiKey) {
		return getDelegate().deletePet(petId, apiKey);
	}

	@Operation(summary = "Finds Pets by status", description = "Multiple status values can be provided with comma separated strings", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),
			@ApiResponse(responseCode = "400", description = "Invalid status value") })
	@GetMapping(value = "/pet/findByStatus", produces = { "application/xml", "application/json" })
	default ResponseEntity<List<Pet>> findPetsByStatus(
			@NotNull @Parameter(description = "Status values that need to be considered for filter", required = true) @Valid @RequestParam(value = "status", required = true) List<String> status) {
		return getDelegate().findPetsByStatus(status);
	}

	@Operation(summary = "Finds Pets by tags", description = "Muliple tags can be provided with comma separated strings. Use         tag1, tag2, tag3 for testing.", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Pet.class)))),
			@ApiResponse(responseCode = "400", description = "Invalid tag value") })
	@GetMapping(value = "/pet/findByTags", produces = { "application/xml", "application/json" })
	default ResponseEntity<List<Pet>> findPetsByTags(
			@NotNull @Parameter(description = "Tags to filter by", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags) {
		return getDelegate().findPetsByTags(tags);
	}

	@Operation(summary = "Find pet by ID", description = "Returns a single pet", security = {
			@SecurityRequirement(name = "api_key") }, tags = { "pet" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Pet.class))),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
			@ApiResponse(responseCode = "404", description = "Pet not found") })
	@GetMapping(value = "/pet/{petId}", produces = { "application/xml", "application/json" })
	default ResponseEntity<Pet> getPetById(
			@Parameter(description = "ID of pet to return", required = true) @PathVariable("petId") Long petId) {
		return getDelegate().getPetById(petId);
	}

	@Operation(summary = "Update an existing pet", description = "", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
			@ApiResponse(responseCode = "404", description = "Pet not found"),
			@ApiResponse(responseCode = "405", description = "Validation exception") })
	@PutMapping(value = "/pet", consumes = { "application/json", "application/xml" })
	default ResponseEntity<Void> updatePet(
			@Parameter(description = "Pet object that needs to be added to the store", required = true) @Valid @RequestBody Pet pet) {
		return getDelegate().updatePet(pet);
	}

	@Operation(summary = "Updates a pet in the store with form data", description = "", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = { @ApiResponse(responseCode = "405", description = "Invalid input") })
	@PostMapping(value = "/pet/{petId}", consumes = { "application/x-www-form-urlencoded" })
	default ResponseEntity<Void> updatePetWithForm(
			@Parameter(description = "ID of pet that needs to be updated", required = true) @PathVariable("petId") Long petId,
			@Parameter(description = "Updated name of the pet") @RequestParam(value = "name", required = false) String name,
			@Parameter(description = "Updated status of the pet") @RequestParam(value = "status", required = false) String status) {
		return getDelegate().updatePetWithForm(petId, name, status);
	}

	@Operation(summary = "uploads an image", description = "", security = {
			@SecurityRequirement(name = "petstore_auth", scopes = { "write:pets", "read:pets" }) }, tags = { "pet" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ModelApiResponse.class))) })
	@PostMapping(value = "/pet/{petId}/uploadImage", produces = { "application/json" }, consumes = {
			"multipart/form-data" })
	default ResponseEntity<ModelApiResponse> uploadFile(
			@Parameter(description = "ID of pet to update", required = true) @PathVariable("petId") Long petId,
			@Parameter(description = "Additional data to pass to server") @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata,
			@Parameter(description = "file detail") @Valid @RequestPart("file") MultipartFile file) {
		return getDelegate().uploadFile(petId, additionalMetadata, file);
	}


	@GetMapping(value = "/v1/pets")
	default void pets(@Valid @NotBlank String name) {

	}
}
