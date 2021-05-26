package com.training.bookstore.service;

import com.training.bookstore.model.resources.Resource;
import com.training.bookstore.model.resources.ResourceNames;
import com.training.bookstore.model.site.SiteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SiteResource {
    @Autowired
    ResourceService resourceService;

    public List<SiteInfo> getSitesInfo () throws IOException {
        Resource resource = resourceService.getResourceByName(ResourceNames.CONFIG_SITES);
        SiteInfo[] readResource = resourceService.getGlobalResource(resource, SiteInfo[].class);
        return Arrays.asList(readResource);
    }

    public SiteInfo getSiteByShopCode (String shopCode) throws IOException {
        List<SiteInfo> sitesInfo = getSitesInfo();
        for (SiteInfo info : sitesInfo) {
            if (info.getShopCode().equals(shopCode)) {
                return info;
            }
        }
        throw new IllegalArgumentException("Cant find site with shop code: " + shopCode);
    }
}
