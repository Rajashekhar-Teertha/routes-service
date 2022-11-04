package com.reactivespring.service;

import com.reactivespring.domain.RouteInfo;
import com.reactivespring.repository.RouteInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RouteInfoService {
    @Autowired
    private RouteInfoRepository routeInfoRepository;

    /**
     * This method adds routeInfo data to database
     * @param routeInfo
     * @return
     */
    public Mono<RouteInfo> addRouteInfo(RouteInfo routeInfo) {
        log.info("Saves routeInfo Object :{} to the database ", routeInfo);
        return routeInfoRepository.save(routeInfo).log();
    }

    /**
     * This method gets routeInfo data from database based on source and destination
     * @param source
     * @param destination
     * @return
     */
    public Mono<RouteInfo> getRouteListForSourceToDestination(String source, String destination) {
        log.info("Get the RouteInfo for source: {} | destination: {}", source, destination);
        return routeInfoRepository.findRouteListBySourceAndDestination(source,destination).log();
    }
}
