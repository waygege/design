package com.ecut.design.Config.util;

import com.ecut.design.Model.PageExample;
import io.netty.util.internal.StringUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageableUtil {

    public Pageable getPageable (PageExample page) {
        if (StringUtil.isNullOrEmpty (page.getSortType ())) {
            page.setSortType ("ASC");
        }
        if (StringUtil.isNullOrEmpty (page.getSortableFields ())) {
            page.setSortableFields ("id");
        }
        Sort sort = "ASC".equals (page.getSortType ()) ? Sort.by (Sort.Direction.ASC, page.getSortableFields ()) : Sort.by (Sort.Direction.DESC, page.getSortableFields ());
        Pageable pageable = PageRequest.of (page.getPageNumber () - 1, page.getPageSize (), sort);
        return pageable;
    }



}
