package org.superbiz.moviefun.moviesapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Repository
public class AlbumClient {

    private String albumsUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
    }

    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }

    public AlbumInfo find(long albumId) {
        return restOperations.exchange(albumsUrl+"/"+albumId, GET, null, AlbumInfo.class).getBody();
    }
}
