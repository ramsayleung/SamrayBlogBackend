package com.samray.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author samray<samrayleung@gmail.com>
 *         Create on 1/17/17
 */
@Getter
@Setter
@Service
public class PaginationService {

    public HashMap<String,Object> getResponseBody(List data, int pageNum, int perPageSize,long totalPages, String url){
        HashMap<String,Object> responseBody=new HashMap<>();
        pageNum=pageNum+1;
        int lastPage = (int) totalPages/perPageSize+1;//it is safe to transform long to int
        responseBody.put("data", data);
        responseBody.put("total", totalPages); //total number of records available
        responseBody.put("per_page", perPageSize);//the number of records returned in this request/page
        responseBody.put("last_page", lastPage);//the last page of this data
        responseBody.put("current_page", pageNum);//the current page of this data chunck
        responseBody.put("from", 1);//the start record of this page
        responseBody.put("to",perPageSize);//the end record of this page
        if (pageNum == lastPage ) {//URL of the next page
            responseBody.put("next_page_url", null);
        } else {
            responseBody.put("next_page_url", url+"?pageNum=" + (pageNum + 1));
        }
        if (pageNum == 1) {
            responseBody.put("pre_page_url", null);
        } else {
            responseBody.put("pre_page_url", url+"?pageNum=" + (pageNum - 1));//URL of the previous page
        }
        return responseBody;
    }
}
