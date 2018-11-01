package com.oc.projet3.escalade.contract;

import com.oc.projet3.escalade.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TopoRepository extends JpaRepository<Topo, Long> {
    public List<Topo> findAllByRegion_id(Long idregion);
    public Topo getFirstByRegion_id(Long idregion);
    public Topo findTopoById(Long id);

//    @Modifying
//    @Query("Update Topo t SET t.title=:title WHERE t.id=:id")
//    public void updateTitle(@Param("id") Long id, @Param("title") String title);

}
