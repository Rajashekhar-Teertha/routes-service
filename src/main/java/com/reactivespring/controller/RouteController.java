package com.reactivespring.controller;

import com.reactivespring.domain.RouteInfo;
import com.reactivespring.service.RouteInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RouteController {
    @Autowired
    private RouteInfoService routeInfoService;

    /**
     * This method adds routesInfo to the database
     * @param routeInfo
     * @return
     */
    @PostMapping("/routeInfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RouteInfo> addRouteInfo(@RequestBody RouteInfo routeInfo)
    {
        log.info("Request received to add routeInfo :{}", routeInfo);
        return routeInfoService.addRouteInfo(routeInfo);

    }


    /**
     * This method gets routesInfo from database based on source and destination
     * @param source
     * @param destination
     * @return
     */
    @GetMapping("/routeInfos")
    public Mono<RouteInfo> addRouteInfo(@RequestParam("source") String source,
                                        @RequestParam("destination") String destination)
    {
        log.info("Request received to get routeInfo for source : {}, destination : {}", source, destination);
        return routeInfoService.getRouteListForSourceToDestination(source, destination);

    }

}
