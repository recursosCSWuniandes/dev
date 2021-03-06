/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.stamps.resources;

import co.edu.uniandes.csw.auth.provider.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.stamps.api.IArtistLogic;
import co.edu.uniandes.csw.stamps.dtos.basic.ArtistBasicDTO;
import co.edu.uniandes.csw.stamps.entities.ArtistEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * @generated
 */
@Path("/artists")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtistResource {

    @Inject private IArtistLogic artistLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de ArtistEntity a una lista de ArtistBasicDTO.
     *
     * @param entityList Lista de ArtistEntity a convertir.
     * @return Lista de ArtistBasicDTO convertida.
     * @generated
     */
    private List<ArtistBasicDTO> listEntity2DTO(List<ArtistEntity> entityList){
        List<ArtistBasicDTO> list = new ArrayList<>();
        for (ArtistEntity entity : entityList) {
            list.add(new ArtistBasicDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Artist
     *
     * @return Colección de objetos de ArtistBasicDTO
     * @generated
     */
    @GET
    public List<ArtistBasicDTO> getArtists() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", artistLogic.countArtists());
            return listEntity2DTO(artistLogic.getArtists(page, maxRecords));
        }
        return listEntity2DTO(artistLogic.getArtists());
    }

    /**
     * Obtiene los datos de una instancia de Artist a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ArtistBasicDTO con los datos del Artist consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public ArtistBasicDTO getArtist(@PathParam("id") Long id) {
        return new ArtistBasicDTO(artistLogic.getArtist(id));
    }

    /**
     * Se encarga de crear un Artist en la base de datos
     *
     * @param dto Objeto de ArtistBasicDTO con los datos nuevos
     * @return Objeto de ArtistBasicDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public ArtistBasicDTO createArtist(ArtistBasicDTO dto) {
        return new ArtistBasicDTO(artistLogic.createArtist(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Artist
     *
     * @param id Identificador de la instancia de Artist a modificar
     * @param dto Instancia de ArtistBasicDTO con los nuevos datos
     * @return Instancia de ArtistBasicDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public ArtistBasicDTO updateArtist(@PathParam("id") Long id, ArtistBasicDTO dto) {
        ArtistEntity entity = dto.toEntity();
        entity.setId(id);
        ArtistEntity oldEntity = artistLogic.getArtist(id);
        return new ArtistBasicDTO(artistLogic.updateArtist(entity));
    }

    /**
     * Elimina una instancia de Artist de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteArtist(@PathParam("id") Long id) {
        artistLogic.deleteArtist(id);
    }
    public void existsArtist(Long artistId){
        ArtistBasicDTO artist = getArtist(artistId);
        if (artist== null) {
            throw new WebApplicationException(404);
        }
    }
    
    @Path("{artistId: \\d+}/stamps")
    public Class<StampResource> getStampResource(@PathParam("artistId") Long artistId){
        existsArtist(artistId);
        return StampResource.class;
    }
    
}
