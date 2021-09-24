package com.dy.food.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dy.food.good.service.GoodService;
import com.dy.food.good.web.CreateGoodRequest;
import com.dy.food.good.web.GoodResponse;
import com.dy.food.good.web.GoodsPagedResponse;
import com.dy.food.good.web.UpdateGoodRequest;

import javax.validation.Valid;
import java.net.URI;

/**
 * @author: Yuqi.Bai,
 * Date : 2019-06-06
 */
@RestController
@CrossOrigin
public class GoodController {

    @Autowired
    private GoodService goodService;

    @PostMapping("/good")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> creategood(@RequestBody @Valid CreateGoodRequest createGoodRequest){

        String good = goodService.createGood(createGoodRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{goodId}")
                .buildAndExpand(good).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/good/{goodId}")
    public ResponseEntity<GoodResponse> getGood(@PathVariable("goodId") String goodId) {

        GoodResponse good = goodService.getGood(goodId);

        return ResponseEntity.ok(good);
    }

    @DeleteMapping("/good/{goodId}")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> deleteGoodCategory(@PathVariable("goodId") String goodId) {

        goodService.deleteGood(goodId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/good")
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public ResponseEntity<?> updateGood(@RequestBody @Valid UpdateGoodRequest updateGoodRequest) {

        goodService.updateGood(updateGoodRequest);

        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/goods", produces = "application/json")
    public ResponseEntity<?> getAllGoods(@RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "size", required = false) Integer size,
                                            PagedResourcesAssembler<GoodResponse> assembler) {

        Page<GoodResponse> list = goodService.getAllGoods(sort, page, size);
    
        Link link = new Link(ServletUriComponentsBuilder.fromCurrentRequest().build()
                                                        .toUriString());

        PagedModel<EntityModel<GoodResponse>> resource = assembler.toModel(list, link);
    
        GoodsPagedResponse goodsPagedResponse = new GoodsPagedResponse();
        goodsPagedResponse.setPage(list);

        if (resource.getLink("first").isPresent()) {
            goodsPagedResponse.get_links().put("first", resource.getLink("first").get().getHref());
        }

        if (resource.getLink("prev").isPresent()) {
            goodsPagedResponse.get_links().put("prev", resource.getLink("prev").get().getHref());
        }

        if (resource.getLink("self").isPresent()) {
            goodsPagedResponse.get_links().put("self", resource.getLink("self").get().getHref());
        }

        if (resource.getLink("next").isPresent()) {
            goodsPagedResponse.get_links().put("next", resource.getLink("next").get().getHref());
        }

        if (resource.getLink("last").isPresent()) {
            goodsPagedResponse.get_links().put("last", resource.getLink("last").get().getHref());
        }
    
        return ResponseEntity.ok(goodsPagedResponse);

    }
}
