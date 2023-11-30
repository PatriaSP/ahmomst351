/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ahm.mo.mst.app351.util;

import id.co.ahm.mo.mst.app351.vo.Mst351VoJson;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author patria
 */
public class Mst351UtilRestTemplate {
    public static HttpHeaders getHeader(String jxid, String tkid) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("JXID", jxid);
        headers.add("Cookie", "JXID=" + jxid);
        headers.add("Cookie", "TKID=" + tkid);
        headers.add("Content-Type", "application/json");
        return headers;
    }

    public static Mst351VoJson postService(Object vo, String jxid, String tkid, String url) {
        HttpEntity requestWithToken;
        if (vo != null) {
            requestWithToken = new HttpEntity(vo, getHeader(jxid, tkid));
        } else {
            requestWithToken = new HttpEntity(getHeader(jxid, tkid));
        }
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Mst351VoJson> res = rt.exchange(url,
                HttpMethod.POST,
                requestWithToken,
                new ParameterizedTypeReference<Mst351VoJson>() {
        });
        Mst351VoJson obj = res.getBody();
        return obj;
    }

    public static Mst351VoJson getService(String jxid, String tkid, String url) {
        HttpEntity requestWithToken = new HttpEntity(getHeader(jxid, tkid));
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Mst351VoJson> res = rt.exchange(url,
                HttpMethod.POST,
                requestWithToken,
                new ParameterizedTypeReference<Mst351VoJson>() {
        });

        Mst351VoJson obj = res.getBody();
        return obj;
    }
    
}
