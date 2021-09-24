package com.dy.food.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dy.food.good.repository.dao.GoodCategory;
import com.dy.food.good.service.GoodCategoryService;
import com.dy.food.good.web.CreateGoodCategoryRequest;
import com.dy.food.good.web.GoodCategoriesPagedResponse;
import com.dy.food.good.web.UpdateGoodCategoryRequest;

import javax.validation.Valid;
import java.net.URI;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@RestController
public class GoodCategoryController {

    @Autowired
    GoodCategoryService goodCategoryService;

    @PostMapping("/productCategory")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> createGoodCategory(@RequestBody @Valid CreateGoodCategoryRequest createGoodCategoryRequest) {

        String productCategory = goodCategoryService.createGoodCategory(createGoodCategoryRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{productCategoryId}")
                .buildAndExpand(productCategory).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/productCategory/{productCategoryId}")
    public ResponseEntity<GoodCategory> getGoodCategory(@PathVariable("productCategoryId") String productCategoryId) {

        GoodCategory goodCategory = goodCategoryService.getGoodCategory(productCategoryId);

        return ResponseEntity.ok(goodCategory);
    }

    @DeleteMapping("/productCategory/{productCategoryId}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> deleteGoodCategory(@PathVariable("productCategoryId") String productCategoryId) {

        goodCategoryService.deleteGoodCategory(productCategoryId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/productCategory")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> updateGoodCategory(@RequestBody @Valid UpdateGoodCategoryRequest updateGoodCategoryRequest) {

        goodCategoryService.updateGoodCategory(updateGoodCategoryRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/productCategories", produces = "application/json")
    public ResponseEntity<?> getAllGoodCategories(@RequestParam(value = "sort", required = false) String sort,
                                                     @RequestParam(value = "page", required = false) Integer page,
                                                     @RequestParam(value = "size", required = false) Integer size,
                                                     PagedResourcesAssembler<GoodCategory> assembler) {
    
        Page<GoodCategory> list = goodCategoryService.getAllGoodCategories(sort, page, size);
    
        Link link = new Link(ServletUriComponentsBuilder.fromCurrentRequest()
                                                        .build()
                                                        .toUriString());

        PagedModel<EntityModel<GoodCategory>> resource = assembler.toModel(list, link);
    
        GoodCategoriesPagedResponse goodCategoriesPagedResponse = new GoodCategoriesPagedResponse();
        goodCategoriesPagedResponse.setPage(list);

        if (resource.getLink("first").isPresent()) {
            goodCategoriesPagedResponse.get_links().put("first", resource.getLink("first").get().getHref());
        }

        if (resource.getLink("prev").isPresent()) {
            goodCategoriesPagedResponse.get_links().put("prev", resource.getLink("prev").get().getHref());
        }

        if (resource.getLink("self").isPresent()) {
            goodCategoriesPagedResponse.get_links().put("self", resource.getLink("self").get().getHref());
        }

        if (resource.getLink("next").isPresent()) {
            goodCategoriesPagedResponse.get_links().put("next", resource.getLink("next").get().getHref());
        }

        if (resource.getLink("last").isPresent()) {
            goodCategoriesPagedResponse.get_links().put("last", resource.getLink("last").get().getHref());
        }
    
        return ResponseEntity.ok(goodCategoriesPagedResponse);

    }
}
